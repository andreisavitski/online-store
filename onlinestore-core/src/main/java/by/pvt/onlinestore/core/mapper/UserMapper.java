package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;

import java.sql.ResultSet;

public interface UserMapper {
    User mapUserRequestDTOtoUser(UserRequestDTO userRequestDTO);

    UserResponseDTO mapUserToUserResponseDTO(User user);
    User mapResultSetToUser(ResultSet resultSet);
}
