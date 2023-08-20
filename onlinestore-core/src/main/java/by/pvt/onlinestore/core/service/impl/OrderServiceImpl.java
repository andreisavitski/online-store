package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.mapper.OrderMapper;
import by.pvt.onlinestore.core.repository.OrderRepository;
import by.pvt.onlinestore.core.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

}
