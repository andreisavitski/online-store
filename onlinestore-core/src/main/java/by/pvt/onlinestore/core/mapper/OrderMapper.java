package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;

public interface OrderMapper {

    Order orderRequestDTOtoOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO orderToOrderResponseDTO(Order order);
}
