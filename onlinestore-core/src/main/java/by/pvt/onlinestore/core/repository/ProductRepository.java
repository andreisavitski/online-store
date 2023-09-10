package by.pvt.onlinestore.core.repository;

import by.pvt.onlinestore.core.domain.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(Long id);

    void deleteProductWithoutSaving(Long id);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    boolean existProductById(Long id);

    Product getProductByName(String name);

    Product getProductBySku(String productSku);

    Product getProductByIdForChange(Long id);

    boolean existBySku(String sku);

    List<Product> getAllProductsById(List<Long> listId);
}
