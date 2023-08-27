package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OrderCompletionServlet extends HttpServlet {
    OrderService orderService;

    public OrderCompletionServlet() {
        orderService = ApplicationContext.getInstance().getOrderService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long orderId = Long.valueOf(req.getParameter("order"));
        OrderResponseDTO order = orderService.getOrderById(orderId);
        resp.setContentType("text/html");
        req.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/order").forward(req, resp);
    }
}
