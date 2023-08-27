package by.pvt.onlinestore.core.repository;

import by.pvt.onlinestore.core.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();

    Order addOrder(Order order);

    void deleteOrderById(Long id);

    Order getOrderById(Long id);

    Order updateTotalCost(Order order);

    Order updateStatus(Order order);

    List<Order> getOrderByUserId(Long id);
}
