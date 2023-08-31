package by.pvt.onlinestore.core.service;

import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;

import java.util.List;

public interface BasketService {
    BasketResponseDTO addBasket(BasketRequestDTO basketRequestDTO);

    List<BasketResponseDTO> getAllBasketsByOrderId(Long id);

    boolean existBasketsByOrderId(Long id);
}
