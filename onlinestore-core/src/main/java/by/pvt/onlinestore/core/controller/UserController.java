package by.pvt.onlinestore.core.controller;

import by.pvt.onlinestore.api.contract.UserApi;
import by.pvt.onlinestore.api.dto.UserRequestDTO;
import by.pvt.onlinestore.api.dto.UserResponseDTO;
import by.pvt.onlinestore.core.service.impl.UserServiceImpl;

public class UserController implements UserApi {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void registration(UserRequestDTO userRequestDTO) {
        userServiceImpl.addUser(userRequestDTO);
    }

    @Override
    public UserResponseDTO authorization(String login, String password) {
        return null;
    }
}
