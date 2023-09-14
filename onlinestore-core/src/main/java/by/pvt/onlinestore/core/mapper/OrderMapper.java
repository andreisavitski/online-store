package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;

import java.sql.ResultSet;

public interface OrderMapper {

    Order mapOrderRequestDTOtoOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO mapOrderToOrderResponseDTO(Order order);

    Order mapResultSetToOrder(ResultSet resultSet);
}
