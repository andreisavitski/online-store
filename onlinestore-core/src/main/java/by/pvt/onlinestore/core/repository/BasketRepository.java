package by.pvt.onlinestore.core.repository;

import by.pvt.onlinestore.core.domain.Basket;

import java.util.List;

public interface BasketRepository {
    List<Basket> getAllBaskets();

    Basket addBasket(Basket basket);

    void deleteBasketById(Long id);

    Basket getBasketById(Long id);

    List<Basket> getAllBasketsByOrderId(Long id);

    Basket updateBasket(Basket basket);

    void deleteBasketByOrderId(Long id);

    void deleteBasketByOrderIdAndProductId(Basket basket);
}
