package by.pvt.onlinestore.core.repository;

import by.pvt.onlinestore.core.domain.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getAllOrders();

}
