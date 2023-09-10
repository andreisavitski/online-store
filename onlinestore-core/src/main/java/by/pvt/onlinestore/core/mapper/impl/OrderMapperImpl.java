package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.domain.Status;
import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.mapper.OrderMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapperImpl implements OrderMapper {
    private final String id = "id";
    private final String userId = "user_id";
    private final String totalCost = "total_cost";
    private final String status = "status";

    @Override
    public Order mapOrderRequestDTOtoOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setId(orderRequestDTO.getId());
        order.setStatus(orderRequestDTO.getStatus());
        order.setUserId(orderRequestDTO.getUserId());
        order.setTotalCost(orderRequestDTO.getTotalCost());
        return order;
    }

    @Override
    public OrderResponseDTO mapOrderToOrderResponseDTO(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setStatus(order.getStatus());
        orderResponseDTO.setUserId(order.getUserId());
        orderResponseDTO.setTotalCost(order.getTotalCost());
        return orderResponseDTO;
    }

    @Override
    public Order mapResultSetToOrder(ResultSet resultSet) {
        Order order = new Order();
        try {
            order.setId(resultSet.getLong(id));
            order.setUserId(resultSet.getLong(userId));
            order.setTotalCost(resultSet.getLong(totalCost));
            order.setStatus(Status.valueOf(resultSet.getString(status)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }
}
