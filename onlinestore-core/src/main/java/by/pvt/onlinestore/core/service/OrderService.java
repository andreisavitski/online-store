package by.pvt.onlinestore.core.service;

import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderById(Long id);

    OrderResponseDTO closeOrderById(Long id);

    void deleteOrderById(Long id);

    List<OrderResponseDTO> getAllOrders();

    List<OrderResponseDTO> getOrderByUserId(Long id);
}
