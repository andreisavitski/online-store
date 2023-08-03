package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.api.dto.UserRequestDTO;
import by.pvt.onlinestore.api.dto.UserResponseDTO;
import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.repository.UserRepository;
import by.pvt.onlinestore.core.service.UserService;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void addUser(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO.getName(), userRequestDTO.getSurname(),
                userRequestDTO.getLogin(), userRequestDTO.getPassword());
        userRepository.addUser(user);
    }

    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = Optional.ofNullable(userRepository.getUserById(id));
        return modelMapper.map(user, UserResponseDTO.class);
    }
}
