package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreationOrderServlet extends HttpServlet {
    OrderService orderService;

    public CreationOrderServlet() {
        orderService = ApplicationContext.getInstance().getOrderService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long orderId = Long.valueOf(req.getParameter("order"));
        UserResponseDTO user = (UserResponseDTO) req.getSession().getAttribute("userAuthorize");
        OrderResponseDTO order = orderService.closeOrderById(orderId);
        req.setAttribute("user", user);
        resp.setContentType("text/html");
        req.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/closeorder").forward(req, resp);
    }
}
