package by.pvt.onlinestore.api.controller;

import by.pvt.onlinestore.core.config.ApplicationContext;
import by.pvt.onlinestore.core.domain.ProductType;
import by.pvt.onlinestore.core.dto.product.ProductRequestDTO;
import by.pvt.onlinestore.core.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProductChangerServlet extends HttpServlet {
    ProductService productService;

    public ProductChangerServlet() {
        productService = ApplicationContext.getInstance().getProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductRequestDTO productRequestDTO = new ProductRequestDTO();
            productRequestDTO.setProductId(Long.valueOf(req.getParameter("id")));
            productRequestDTO.setName(req.getParameter("name"));
            productRequestDTO.setProductSku(req.getParameter("sku"));
            productRequestDTO.setProductType(ProductType.valueOf(req.getParameter("type")));
            productRequestDTO.setDescription(req.getParameter("description"));
            productRequestDTO.setPrice(req.getParameter("price"));
            productRequestDTO.setQuantityInStock(Integer.parseInt(req.getParameter("quantity")));
            productService.updateProduct(productRequestDTO);
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("jsp/error.jsp").forward(req, resp);
        }
        resp.setContentType("text/html");
        req.setAttribute("alert", "Product data changed!");
        getServletContext().getRequestDispatcher("/alert").forward(req, resp);
    }
}
