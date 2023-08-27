package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserGetterServlet extends HttpServlet {
    private final UserService userService;

    public UserGetterServlet() {
        userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        UserResponseDTO user = userService.getUserByLogin(req.getParameter("login"));
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/admin/getuser").forward(req, resp);
    }
}
