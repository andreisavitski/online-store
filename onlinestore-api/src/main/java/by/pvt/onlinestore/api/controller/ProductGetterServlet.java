package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProductGetterServlet extends HttpServlet {
    ProductService productService;

    public ProductGetterServlet() {
        productService = ApplicationContext.getInstance().getProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ProductResponseDTO product = null;
        try {
            product = productService.getProductById(Long.valueOf(req.getParameter("id")));
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        req.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/getproductpage").forward(req, resp);
    }
}
