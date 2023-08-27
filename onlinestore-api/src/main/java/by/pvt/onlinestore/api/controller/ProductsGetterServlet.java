package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProductsGetterServlet extends HttpServlet {
    ProductService productService;

    public ProductsGetterServlet() {
        productService = ApplicationContext.getInstance().getProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<ProductResponseDTO> products = productService.getAllProducts();
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/buy").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<ProductResponseDTO> products = productService.getAllProducts();
        req.setAttribute("products", products);
        getServletContext().getRequestDispatcher("/getproductspage").forward(req, resp);
    }
}
