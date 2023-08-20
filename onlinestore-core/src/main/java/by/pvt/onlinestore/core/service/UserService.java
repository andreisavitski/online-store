package by.pvt.onlinestore.core.service;

import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO register(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getAllUsers();
    UserResponseDTO viewUserInformation(String login);

    UserResponseDTO authenticate(String login, String password);

    boolean checkIfExist(String login);
}
