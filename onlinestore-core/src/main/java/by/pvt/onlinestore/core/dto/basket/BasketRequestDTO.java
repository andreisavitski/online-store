package by.pvt.onlinestore.core.dto.basket;

import java.util.Objects;

public class BasketRequestDTO {
    private Long basketId;
    private Long productId;
    private Long orderId;
    private int quantityOfGoods;

    public BasketRequestDTO() {
    }

    public BasketRequestDTO(Long basketId, Long productId, Long orderId, int quantityOfGoods) {
        this.basketId = basketId;
        this.productId = productId;
        this.orderId = orderId;
        this.quantityOfGoods = quantityOfGoods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasketRequestDTO that = (BasketRequestDTO) o;
        return quantityOfGoods == that.quantityOfGoods && Objects.equals(basketId, that.basketId) && Objects.equals(productId, that.productId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketId, productId, orderId, quantityOfGoods);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BasketRequestDTO{");
        sb.append("basketId=").append(basketId);
        sb.append(", productId=").append(productId);
        sb.append(", orderId=").append(orderId);
        sb.append(", quantityOfGoods=").append(quantityOfGoods);
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

    public int getQuantityOfGoods() {
        return quantityOfGoods;
    }

    public void setQuantityOfGoods(int quantityOfGoods) {
        this.quantityOfGoods = quantityOfGoods;
    }
}
