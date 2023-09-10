package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.service.BasketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BasketRemoverServlet extends HttpServlet {
    BasketService basketService;

    public BasketRemoverServlet() {
        basketService = ApplicationContext.getInstance().getBasketService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BasketRequestDTO basketRequestDTO = new BasketRequestDTO();
            basketRequestDTO.setOrderId(Long.valueOf(req.getParameter("order")));
            basketRequestDTO.setProductId(Long.valueOf(req.getParameter("product")));
            basketService.deleteBasket(basketRequestDTO);
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        resp.setContentType("text/html");
        req.setAttribute("alert", "Product removed from basket!");
        getServletContext().getRequestDispatcher("/alert").forward(req, resp);
    }
}
