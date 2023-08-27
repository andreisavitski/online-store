package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.domain.Status;
import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.dto.user.UserResponseDTO;
import by.pvt.onlinestore.core.service.OrderService;
import by.pvt.onlinestore.core.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class OrderAdderServlet extends HttpServlet {
    OrderService orderService;
    ProductService productService;

    public OrderAdderServlet() {
        orderService = ApplicationContext.getInstance().getOrderService();
        productService = ApplicationContext.getInstance().getProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductResponseDTO> products = productService.getAllProducts();
        req.setAttribute("products.txt", products);
        UserResponseDTO user = (UserResponseDTO) req.getSession().getAttribute("userAuthorize");
        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setUserId(user.getId());
        orderRequestDTO.setStatus(Status.NOT_FORMED);
        OrderResponseDTO order = orderService.addOrder(orderRequestDTO);
        resp.setContentType("text/html");
        req.setAttribute("order", order);
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/buy").forward(req, resp);
    }
}
