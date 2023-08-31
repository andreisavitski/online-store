package by.pvt.onlinestore.core.repository.impl;

import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderRepositoryImpl extends FileWorker implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\orders.txt";

    @Override
    public List<Order> getAllOrders() {
        return getOrders();
    }

    @Override
    public Order addOrder(Order order) {
        List<Order> orderList = getOrders();
        order.setId((long) (orderList.size() + 1));
        List<Order> orders = getOrders();
        orders.add(order);
        serializeObject(orders, PATH);
        return order;
    }

    @Override
    public void deleteOrderById(Long id) {
        List<Order> orders = getOrders();
        if (orders.isEmpty()) return;
        orders.remove((int) (id - 1));
        serializeObject(orders, PATH);
    }

    @Override
    public Order getOrderById(Long id) {
        try {
            return getOrders().stream().filter(a -> Objects.equals(a.getId(), id)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("Order with given Id does not exist.");
        }
    }

    @Override
    public Order updateTotalCost(Order order) {
        List<Order> orders = getOrders();
        Order orderById = getOrderById(order.getId());
        orderById.setTotalCost(order.getTotalCost());
        orders.set((int) (orderById.getId() - 1), orderById);
        serializeObject(orders, PATH);
        return orderById;
    }

    @Override
    public Order updateStatus(Order order) {
        List<Order> orders = getOrders();
        Order orderById = getOrderById(order.getId());
        orderById.setStatus(order.getStatus());
        orders.set((int) (orderById.getId() - 1), orderById);
        serializeObject(orders, PATH);
        return orderById;
    }

    @Override
    public List<Order> getOrderByUserId(Long id) {
        List<Order> orders = getOrders();
        List<Order> ordersAfterFilter = orders.stream().filter(order -> order.getUserId().equals(id)).toList();
        return ordersAfterFilter;
    }

    private List<Order> getOrders() {
        Object o = deserializeObject(PATH);
        List<Order> orders = new ArrayList<>();
        if (o instanceof List<?>) {
            orders = (List<Order>) o;
        }
        return orders;
    }
}
