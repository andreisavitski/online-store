package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;
import by.pvt.onlinestore.core.mapper.BasketMapper;

public class BasketMapperImpl implements BasketMapper {
    @Override
    public Basket basketRequestDTOtoBasket(BasketRequestDTO basketRequestDTO) {
        Basket basket = new Basket();
        basket.setBasketId(basketRequestDTO.getBasketId());
        basket.setOrderId(basketRequestDTO.getOrderId());
        basket.setProductId(basketRequestDTO.getProductId());
        basket.setQuantityOfGoods(basketRequestDTO.getQuantityOfGoods());
        return basket;
    }

    @Override
    public BasketResponseDTO basketToBasketResponseDTO(Basket basket) {
        BasketResponseDTO basketResponseDTO = new BasketResponseDTO();
        basketResponseDTO.setBasketId(basket.getBasketId());
        basketResponseDTO.setOrderId(basket.getOrderId());
        basketResponseDTO.setProductId(basket.getProductId());
        basketResponseDTO.setQuantityOfGoods(basket.getQuantityOfGoods());
        return basketResponseDTO;
    }
}
