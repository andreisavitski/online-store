package by.pvt.onlinestore.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private Long id;
    private Long userld;
    private Basket basket;
    private LocalDateTime orderDate;
    private BigDecimal orderCost;
    private int numberOfUnits;

    public Order() {
    }

    public Order(Long id, Long userld, Basket basket, LocalDateTime orderDate, int numberOfUnits) {
        this.id = id;
        this.userld = userld;
        this.basket = basket;
        this.orderDate = orderDate;
//        this.orderCost = basket.getPrice().multiply(new BigDecimal(numberOfUnits).setScale(0, RoundingMode.CEILING));
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", userld=").append(userld);
        sb.append(", basket=").append(basket);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", orderCost=").append(orderCost);
        sb.append(", numberOfUnits=").append(numberOfUnits);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userld, basket, orderDate, orderCost, numberOfUnits);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return numberOfUnits == order.numberOfUnits && Objects.equals(id, order.id) && Objects.equals(userld, order.userld) && Objects.equals(basket, order.basket) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderCost, order.orderCost);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserld() {
        return userld;
    }

    public void setUserld(Long userld) {
        this.userld = userld;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
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
