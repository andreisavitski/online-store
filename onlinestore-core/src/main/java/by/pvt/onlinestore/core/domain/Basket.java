package by.pvt.onlinestore.core.domain;

import java.util.Objects;

public class Basket {
    private Long basketId;
    private Long productId;
    private Long orderId;

    public Basket() {
    }

    public Basket(Long basketId, Long productId, Long orderId) {
        this.basketId = basketId;
        this.productId = productId;
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(basketId, basket.basketId) && Objects.equals(productId, basket.productId) && Objects.equals(orderId, basket.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketId, productId, orderId);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Basket{");
        sb.append("basketId=").append(basketId);
        sb.append(", productId=").append(productId);
        sb.append(", orderId=").append(orderId);
        sb.append('}');
        return sb.toString();
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}