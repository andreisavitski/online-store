package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {

    @Override
    public User userRequestDTOtoUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setFirstName(userRequestDTO.getName());
        user.setLastName(userRequestDTO.getSurname());
        user.setLogin(userRequestDTO.getLogin());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(userRequestDTO.getRole());
        return user;
    }

    @Override
    public UserResponseDTO userToUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getFirstName());
        userResponseDTO.setSurname(user.getLastName());
        userResponseDTO.setLogin(user.getLogin());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setFullName(user.getFirstName() + " " + user.getLastName());
        return userResponseDTO;
    }

}
