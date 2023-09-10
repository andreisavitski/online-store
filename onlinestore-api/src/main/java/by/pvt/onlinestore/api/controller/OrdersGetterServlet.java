package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class OrdersGetterServlet extends HttpServlet {
    OrderService orderService;

    public OrdersGetterServlet() {
        orderService = ApplicationContext.getInstance().getOrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderResponseDTO> orders = null;
        try {
            orders = orderService.getAllOrders();
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        resp.setContentType("text/html");
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/getorderspage").forward(req, resp);
    }
}
