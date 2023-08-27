package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;

public interface UserMapper {
    User userRequestDTOtoUser(UserRequestDTO userRequestDTO);

    UserResponseDTO userToUserResponseDTO(User user);
}
