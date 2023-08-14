package by.pvt.onlinestore.core.repository.impl;


import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.repository.ProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\products";


    @Override
    public void addProduct(Product product) {
        product.setProductId((idCounter.getAndIncrement()));
        products.add(product);
        serializeObject(products);
    }

    @Override
    public void deleteProductById(Long id) {
        List<Product> products = deserializeObject();
        if (products.isEmpty()) return;
        Product product = getProductById(id);
        products.remove(product);
        serializeObject(products);
    }

    @Override
    public List<Product> getAllProducts() {
        return deserializeObject();
    }

    @Override
    public Product getProductById(Long id) {
        try {
            return deserializeObject().stream().filter(a -> Objects.equals(a.getProductId(), id)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Product with given Id does not exist.");
        }
    }

    @Override
    public Product getProductByName(String name) {
        try {
            return deserializeObject().stream().filter(a -> Objects.equals(a.getProductSku(), name)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Product with given Name does not exist.");
        }
    }

    @Override
    public Product getProductBySku(Long productSku) {
        try {
            return deserializeObject().stream().filter(a -> Objects.equals(a.getProductSku(), productSku)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Product with given Sku does not exist.");
        }
    }

    private void serializeObject(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ProductRepositoryImpl.PATH))) {
            oos.writeObject(products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Product> deserializeObject() {
        List<Product> products;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ProductRepositoryImpl.PATH))) {
            products = (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
