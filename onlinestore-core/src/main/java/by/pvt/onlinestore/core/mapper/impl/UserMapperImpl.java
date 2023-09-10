package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Role;
import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.mapper.UserMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapperImpl implements UserMapper {
    private final String id = "id";
    private final String name = "name";
    private final String surname = "surname";
    private final String login = "login";
    private final String password = "password";
    private final String role = "role";

    @Override
    public User mapUserRequestDTOtoUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setSurname(userRequestDTO.getSurname());
        user.setLogin(userRequestDTO.getLogin());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(userRequestDTO.getRole());
        return user;
    }

    @Override
    public UserResponseDTO mapUserToUserResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setSurname(user.getSurname());
        userResponseDTO.setLogin(user.getLogin());
        userResponseDTO.setRole(user.getRole());
        userResponseDTO.setFullName(user.getName() + " " + user.getSurname());
        return userResponseDTO;
    }

    @Override
    public User mapResultSetToUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong(id));
            user.setName(resultSet.getString(name));
            user.setSurname(resultSet.getString(surname));
            user.setLogin(resultSet.getString(login));
            user.setPassword(resultSet.getString(password));
            user.setRole(Role.valueOf(resultSet.getString(role)));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }
}
