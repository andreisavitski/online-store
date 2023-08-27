package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;

public interface BasketMapper {

    Basket basketRequestDTOtoBasket(BasketRequestDTO basketRequestDTO);

    BasketResponseDTO basketToBasketResponseDTO(Basket basket);
}
