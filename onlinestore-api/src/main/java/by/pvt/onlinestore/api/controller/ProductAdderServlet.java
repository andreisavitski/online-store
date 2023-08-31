package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.domain.ProductType;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

public class ProductAdderServlet extends HttpServlet {
    ProductService productService;

    public ProductAdderServlet() {
        productService = ApplicationContext.getInstance().getProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setName(req.getParameter("name"));
        productRequestDTO.setProductSku(req.getParameter("sku"));
        productRequestDTO.setProductType(ProductType.valueOf(req.getParameter("type")));
        productRequestDTO.setDescription(req.getParameter("description"));
        productRequestDTO.setPrice(req.getParameter("price"));
        productRequestDTO.setQuantityInStock(Integer.parseInt(req.getParameter("quantity")));
        ProductResponseDTO product = productService.addProduct(productRequestDTO);
        resp.setContentType("text/html");
        req.setAttribute("alert", "Product added!");
        getServletContext().getRequestDispatcher("/alert").forward(req, resp);
    }
}
