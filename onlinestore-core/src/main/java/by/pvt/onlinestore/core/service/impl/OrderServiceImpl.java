package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.repository.OrderRepository;
import by.pvt.onlinestore.core.service.OrderService;
import org.modelmapper.ModelMapper;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

}
