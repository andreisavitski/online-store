package by.pvt.onlinestore.core.mapper;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;

import java.sql.ResultSet;

public interface BasketMapper {

    Basket mapBasketRequestDTOtoBasket(BasketRequestDTO basketRequestDTO);

    BasketResponseDTO mapBasketToBasketResponseDTO(Basket basket);

    Basket mapResultSetToBasket(ResultSet resultSet);
}
