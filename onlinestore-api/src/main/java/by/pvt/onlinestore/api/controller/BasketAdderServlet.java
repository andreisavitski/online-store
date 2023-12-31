package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;
import by.pvt.onlinestore.core.service.BasketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class BasketAdderServlet extends HttpServlet {
    BasketService basketService;

    public BasketAdderServlet() {
        basketService = ApplicationContext.getInstance().getBasketService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BasketRequestDTO basketRequestDTO = new BasketRequestDTO();
        basketRequestDTO.setOrderId(Long.valueOf(req.getParameter("order")));
        basketRequestDTO.setProductId(Long.valueOf(req.getParameter("product")));
        basketRequestDTO.setQuantityOfGoods(Integer.parseInt(req.getParameter("quantity")));
        BasketResponseDTO basket = basketService.addBasket(basketRequestDTO);
        resp.setContentType("text/html");
        req.setAttribute("basket", basket);
        req.setAttribute("alert", "Product added to basket!");
        getServletContext().getRequestDispatcher("/alert").forward(req, resp);
    }
}
