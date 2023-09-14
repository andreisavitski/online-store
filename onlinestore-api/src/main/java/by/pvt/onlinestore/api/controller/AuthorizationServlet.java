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

public class AuthorizationServlet extends HttpServlet {
    private final UserService userService;

    public AuthorizationServlet() {
        userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setLogin(req.getParameter("login"));
        userRequestDTO.setPassword(req.getParameter("password"));
        UserResponseDTO user = null;
        try {
            user = userService.authenticate(userRequestDTO.getLogin(), userRequestDTO.getPassword());
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        HttpSession session = req.getSession(true);
        session.setAttribute("userAuthorize", user);
        req.setAttribute("user", user);
        assert user != null;
        if (user.getRole().equals(Role.ADMIN)) {
            req.getRequestDispatcher("/jsp/admin.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/jsp/client.jsp").forward(req, resp);
        }
    }
}
