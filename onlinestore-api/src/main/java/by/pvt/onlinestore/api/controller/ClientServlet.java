package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.service.UserService;
import jakarta.servlet.http.HttpServlet;

public class ClientServlet extends HttpServlet {
    private final UserService userService;

    public ClientServlet() {
        userService = ApplicationContext.getInstance().getUserService();
    }
}
