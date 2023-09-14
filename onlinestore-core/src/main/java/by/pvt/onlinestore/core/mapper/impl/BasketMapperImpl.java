package by.pvt.onlinestore.core.mapper.impl;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;
import by.pvt.onlinestore.core.mapper.BasketMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketMapperImpl implements BasketMapper {
    private final String id = "id";
    private final String productId = "product_id";
    private final String orderId = "order_id";
    private final String quantityOfGoods = "quantity_of_goods";

    @Override
    public Basket mapBasketRequestDTOtoBasket(BasketRequestDTO basketRequestDTO) {
        Basket basket = new Basket();
        basket.setBasketId(basketRequestDTO.getBasketId());
        basket.setOrderId(basketRequestDTO.getOrderId());
        basket.setProductId(basketRequestDTO.getProductId());
        basket.setQuantityOfGoods(basketRequestDTO.getQuantityOfGoods());
        return basket;
    }

    @Override
    public BasketResponseDTO mapBasketToBasketResponseDTO(Basket basket) {
        BasketResponseDTO basketResponseDTO = new BasketResponseDTO();
        basketResponseDTO.setBasketId(basket.getBasketId());
        basketResponseDTO.setOrderId(basket.getOrderId());
        basketResponseDTO.setProductId(basket.getProductId());
        basketResponseDTO.setQuantityOfGoods(basket.getQuantityOfGoods());
        return basketResponseDTO;
    }

    @Override
    public Basket mapResultSetToBasket(ResultSet resultSet) {
        Basket basket = new Basket();
        try {
            basket.setBasketId(resultSet.getLong(id));
            basket.setProductId(resultSet.getLong(productId));
            basket.setOrderId(resultSet.getLong(orderId));
            basket.setQuantityOfGoods(resultSet.getInt(quantityOfGoods));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return basket;
    }
}
