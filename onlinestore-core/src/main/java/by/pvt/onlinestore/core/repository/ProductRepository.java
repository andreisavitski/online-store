package by.pvt.onlinestore.core.repository;

import by.pvt.onlinestore.core.domain.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);

    void deleteProductById(Long id);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product getProductByName(String name);

    Product getProductBySku(Long productSku);
}
