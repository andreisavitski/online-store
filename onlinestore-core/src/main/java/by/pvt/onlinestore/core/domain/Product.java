package by.pvt.onlinestore.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

    private Long productId;
    private String productSku;
    private String name;
    private ProductType productType;
    private Long price;
    private String description;
    private int quantityInStock;

    public Product() {
    }

    public Product(String productSku, String name, ProductType productType, Long price, String description, int quantityInStock) {
        this.productSku = productSku;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    public Product(Long productId, String productSku, String name, ProductType productType, Long price, String description, int quantityInStock) {
        this.productId = productId;
        this.productSku = productSku;
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantityInStock == product.quantityInStock && Objects.equals(productId, product.productId) && Objects.equals(productSku, product.productSku) && Objects.equals(name, product.name) && productType == product.productType && Objects.equals(price, product.price) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productSku, name, productType, price, description, quantityInStock);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("productId=").append(productId);
        sb.append(", productSku=").append(productSku);
        sb.append(", name='").append(name).append('\'');
        sb.append(", productType=").append(productType);
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", quantityInStock=").append(quantityInStock);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
