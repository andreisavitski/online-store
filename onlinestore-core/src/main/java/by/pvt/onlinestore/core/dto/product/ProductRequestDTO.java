package by.pvt.onlinestore.core.dto.product;

import by.pvt.onlinestore.core.domain.ProductType;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductRequestDTO {
    private Long productId;
    private String  productSku;
    private String name;
    private ProductType productType;
    private Long price;
    private String description;
    private int quantityInStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequestDTO that = (ProductRequestDTO) o;
        return quantityInStock == that.quantityInStock && Objects.equals(productId, that.productId) && Objects.equals(productSku, that.productSku) && Objects.equals(name, that.name) && productType == that.productType && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productSku, name, productType, price, description, quantityInStock);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductRequestDTO{");
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Long.parseLong(price);
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
