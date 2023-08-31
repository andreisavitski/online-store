package by.pvt.onlinestore.core.dto.order;

import by.pvt.onlinestore.core.domain.Status;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;

import java.util.List;
import java.util.Objects;

public class OrderResponseDTO {
    private Long id;
    private Long userId;
    private Long totalCost;
    private Status status;
    private List<ProductResponseDTO> products;
    private List<BasketResponseDTO> baskets;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Long id, Long userId, Long totalCost, Status status, List<ProductResponseDTO> products, List<BasketResponseDTO> baskets) {
        this.id = id;
        this.userId = userId;
        this.totalCost = totalCost;
        this.status = status;
        this.products = products;
        this.baskets = baskets;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderResponseDTO{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", status=").append(status);
        sb.append(", products.txt=").append(products);
        sb.append(", baskets.txt=").append(baskets);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResponseDTO that = (OrderResponseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(totalCost, that.totalCost) && status == that.status && Objects.equals(products, that.products) && Objects.equals(baskets, that.baskets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, totalCost, status, products, baskets);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDTO> products) {
        this.products = products;
    }

    public List<BasketResponseDTO> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<BasketResponseDTO> baskets) {
        this.baskets = baskets;
    }
}
