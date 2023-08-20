package by.pvt.onlinestore.core.repository.impl;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepositoryImpl extends FileWorker implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\products";


    @Override
    public void addProduct(Product product) {
        product.setProductId((idCounter.getAndIncrement()));
        List<Product> products = getProduct();
        products.add(product);
        serializeObject(products, PATH);
    }

    @Override
    public void addOldProduct(Product product) {
        List<Product> products = getProduct();
        products.add(product);
        serializeObject(products, PATH);
    }

    @Override
    public void deleteProductById(Long id) {
        List<Product> products = getProduct();
        if (products.isEmpty()) return;
        Product product = getProductById(id);
        products.remove(product);
        serializeObject(products, PATH);
    }

    @Override
    public void deleteProductWithoutSaving(Long id) {
        List<Product> products = getProduct();
        if (products.isEmpty()) return;
        Product product = getProductById(id);
        products.remove(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return getProduct();
    }

    @Override
    public Product getProductById(Long id) {
        try {
            return getProduct().stream().filter(a -> Objects.equals(a.getProductId(), id)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Product with given Id does not exist.");
        }
    }

    @Override
    public Product getProductByIdForChange(Long id) {
        Product product;
        try {
            product = getProduct().stream().filter(a -> Objects.equals(a.getProductId(), id)).toList().get(0);
        } catch (RuntimeException e) {
            throw new RuntimeException("Product does not exist");
        }
        return product;
    }

    @Override
    public Product getProductByName(String name) {
        try {
            return getProduct().stream().filter(a -> Objects.equals(a.getName(), name)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Product with given Name does not exist.");
        }
    }

    @Override
    public Product getProductBySku(String productSku) {
        try {
            return getProduct().stream().filter(a -> Objects.equals(a.getProductSku(), productSku)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Product with given Sku does not exist.");
        }
    }


    @Override
    public boolean findBySku(String sku) {
        return getProduct().stream().anyMatch(product -> sku.equals(product.getProductSku()));
    }

    private List<Product> getProduct() {
        Object o = deserializeObject(PATH);
        List<Product> products = new ArrayList<>();
        if (o instanceof List<?>) {
            products = (List<Product>) o;
        }
        return products;
    }
}
