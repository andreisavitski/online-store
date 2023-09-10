package by.pvt.onlinestore.core.repository.impl.file;

import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductFileRepository extends FileWorker implements ProductRepository {
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\products.txt";

    @Override
    public void addProduct(Product product) {
        List<Product> productList = getProduct();
        product.setProductId((long) (productList.size() + 1));
        List<Product> products = getProduct();
        products.add(product);
        serializeObject(products, PATH);
    }

    @Override
    public void updateProduct(Product product) {
        List<Product> products = getProduct();
        if (products.get((int) (product.getProductId() - 1)) == null) {
            throw new RuntimeException("There is no product with this ID");
        }
        products.set((int) (product.getProductId() - 1), product);
        serializeObject(products, PATH);
    }

    @Override
    public void deleteProductById(Long id) {
        List<Product> products = getProduct();
        if (products.isEmpty()) return;
        products.remove((int) (id - 1));
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
        Product product = getProduct().stream().filter(a -> Objects.equals(a.getProductId(), id)).toList().get(0);
        if (product == null) {
            throw new RuntimeException("There is no product with this ID");
        }
        return product;
    }

    @Override
    public boolean existProductById(Long id) {
        return getProduct().stream().anyMatch(a -> Objects.equals(a.getProductId(), id));
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
    public boolean existBySku(String sku) {
        return getProduct().stream().anyMatch(product -> sku.equals(product.getProductSku()));
    }

    @Override
    public List<Product> getAllProductsById(List<Long> listId) {
        List<Product> products = new ArrayList<>();
        for (Long id : listId) {
            products.add(getProductById(id));
        }
        return products;
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
