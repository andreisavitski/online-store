package by.pvt.onlinestore.api.contract;

import by.pvt.onlinestore.api.dto.UserRequestDTO;
import by.pvt.onlinestore.api.dto.UserResponseDTO;

public interface UserApi {
    void registration(UserRequestDTO userRequestDTO);

    UserResponseDTO authorization(String login, String password);
}
