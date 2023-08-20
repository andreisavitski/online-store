package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class UsersGetterServlet extends HttpServlet {
    private final UserService userService;

    public UsersGetterServlet() {
        userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<UserResponseDTO> users = userService.getAllUsers();
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/admin/getusers").forward(req, resp);
    }
}
