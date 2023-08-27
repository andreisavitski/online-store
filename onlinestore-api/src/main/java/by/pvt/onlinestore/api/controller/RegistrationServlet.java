package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.domain.Role;
import by.pvt.onlinestore.core.dto.user.UserRequestDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private final UserService userService;

    public RegistrationServlet() {
        userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setLogin(req.getParameter("login"));
        userRequestDTO.setPassword(req.getParameter("password"));
        userRequestDTO.setName(req.getParameter("name"));
        userRequestDTO.setSurname(req.getParameter("surname"));
        UserResponseDTO user = userService.register(userRequestDTO);
        HttpSession session = req.getSession(true);
        session.setAttribute("userAuthorize", user);
        req.setAttribute("user", user);
        if (user.getRole().equals(Role.ADMIN)) {
            req.getRequestDispatcher("/jsp/admin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/jsp/client.jsp").forward(req, resp);
        }
    }
}
