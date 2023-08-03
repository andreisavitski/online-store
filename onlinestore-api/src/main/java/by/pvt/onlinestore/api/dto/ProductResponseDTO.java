package by.pvt.onlinestore.api.dto;

import by.pvt.onlinestore.api.enums.ProductType;

import java.math.BigDecimal;

public class ProductResponseDTO {
    private Long productId;
    private Long productSku;
    private String name;
    private ProductType productType;
    private BigDecimal price;
    private String description;
    private String isoCurrency;
    private int quantityInStock;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductSku() {
        return productSku;
    }

    public void setProductSku(Long productSku) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsoCurrency() {
        return isoCurrency;
    }

    public void setIsoCurrency(String isoCurrency) {
        this.isoCurrency = isoCurrency;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
