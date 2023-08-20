package by.pvt.onlinestore.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private Long id;
    private Long userId;
    private Long basketId;
    private LocalDateTime orderDate;
    private BigDecimal orderCost;
    private int numberOfUnits;

    public Order() {
    }

    public Order(Long id, Long userId, Long basketId, LocalDateTime orderDate, int numberOfUnits) {
        this.id = id;
        this.userId = userId;
        this.basketId = basketId;
        this.orderDate = orderDate;
//        this.orderCost = basket.getPrice().multiply(new BigDecimal(numberOfUnits).setScale(0, RoundingMode.CEILING));
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", basketId=").append(basketId);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", orderCost=").append(orderCost);
        sb.append(", numberOfUnits=").append(numberOfUnits);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, basketId, orderDate, orderCost, numberOfUnits);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return numberOfUnits == order.numberOfUnits && Objects.equals(id, order.id) && Objects.equals(userId, order.userId) && Objects.equals(basketId, order.basketId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderCost, order.orderCost);
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

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
}
