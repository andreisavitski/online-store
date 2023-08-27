package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.mapper.OrderMapper;

public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order orderRequestDTOtoOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setId(orderRequestDTO.getId());
        order.setStatus(orderRequestDTO.getStatus());
        order.setUserId(orderRequestDTO.getUserId());
        order.setTotalCost(orderRequestDTO.getTotalCost());
        return order;
    }

    @Override
    public OrderResponseDTO orderToOrderResponseDTO(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setStatus(order.getStatus());
        orderResponseDTO.setUserId(order.getUserId());
        orderResponseDTO.setTotalCost(order.getTotalCost());
        return orderResponseDTO;
    }
}
