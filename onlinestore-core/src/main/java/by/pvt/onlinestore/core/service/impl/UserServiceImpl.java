package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.domain.Role;
import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.mapper.UserMapper;
import by.pvt.onlinestore.core.repository.UserRepository;
import by.pvt.onlinestore.core.service.UserService;

import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
        if (checkIfExist(userRequestDTO.getLogin())) {
            throw new RuntimeException("The login " + userRequestDTO.getLogin() + " entered already exists. Enter another login.");
        }
        if (Objects.equals(userRequestDTO.getName(), "")
                || Objects.equals(userRequestDTO.getSurname(), "")
                || Objects.equals(userRequestDTO.getLogin(), "")
                || Objects.equals(userRequestDTO.getPassword(), "")) {
            throw new RuntimeException("Fill in all the fields.");
        }
        userRequestDTO.setRole(Role.CLIENT);
        User user = userRepository.addUser(userMapper.userRequestDTOtoUser(userRequestDTO));
        return userMapper.userToUserResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.getAllUser();
        return users.stream().map(userMapper::userToUserResponseDTO).toList();
    }

    @Override
    public UserResponseDTO getUserByLogin(String login) {
        return userMapper.userToUserResponseDTO(userRepository.getByLogin(login));
    }

    @Override
    public UserResponseDTO authenticate(String login, String password) {
        User user = userRepository.getByLogin(login);
        if (user == null) {
            throw new RuntimeException("User with login " + login + " not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Password entered incorrectly");
        }
        return userMapper.userToUserResponseDTO(user);
    }

    @Override
    public boolean checkIfExist(String login) {
        return userRepository.existByLogin(login);
    }
}
