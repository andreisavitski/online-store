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
import java.util.List;

public class OrderGetterServlet extends HttpServlet {
    OrderService orderService;

    public OrderGetterServlet() {
        orderService = ApplicationContext.getInstance().getOrderService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserResponseDTO user = (UserResponseDTO) req.getSession().getAttribute("userAuthorize");
        List<OrderResponseDTO> orders = null;
        try {
            orders = orderService.getOrderByUserId(user.getId());
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        resp.setContentType("text/html");
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/getorderspage").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderResponseDTO> orders = null;
        try {
            orders = orderService.getOrderByUserId(Long.valueOf(req.getParameter("id")));
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        resp.setContentType("text/html");
        req.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/getorderspage").forward(req, resp);
    }
}
