package by.pvt.onlinestore.core.domain;

import java.util.Objects;

public class Basket {
    private Long basketId;
    private Product product;
    private Order order;

    public Basket() {
    }

    public Basket(Long basketId, Product product, Order order) {
        this.basketId = basketId;
        this.product = product;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(basketId, basket.basketId) && Objects.equals(product, basket.product) && Objects.equals(order, basket.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basketId, product, order);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Basket{");
        sb.append("basketId=").append(basketId);
        sb.append(", product=").append(product);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
