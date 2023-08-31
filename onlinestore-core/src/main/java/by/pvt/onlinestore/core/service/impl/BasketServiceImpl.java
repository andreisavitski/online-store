package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.dto.basket.BasketRequestDTO;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;
import by.pvt.onlinestore.core.mapper.BasketMapper;
import by.pvt.onlinestore.core.repository.BasketRepository;
import by.pvt.onlinestore.core.repository.UserRepository;
import by.pvt.onlinestore.core.service.BasketService;

import java.util.List;

public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final UserRepository userRepository;

    public BasketServiceImpl(BasketRepository basketRepository, BasketMapper basketMapper, UserRepository userRepository) {
        this.basketRepository = basketRepository;
        this.basketMapper = basketMapper;
        this.userRepository = userRepository;
    }

    @Override
    public BasketResponseDTO addBasket(BasketRequestDTO basketRequestDTO) {
        Basket newBasket;
        if (existBasketsByOrderId(basketRequestDTO.getOrderId())) {
            List<Basket> basketsFromOneOrder = basketRepository.getAllBasketsByOrderId(basketRequestDTO.getOrderId());
            if (basketsFromOneOrder.stream().anyMatch(basket -> basket.getProductId().equals(basketRequestDTO.getProductId()))) {
                newBasket = basketsFromOneOrder.stream().filter(basket -> basket.getProductId().equals(basketRequestDTO.getProductId())).toList().get(0);
                newBasket.setQuantityOfGoods(newBasket.getQuantityOfGoods() + basketRequestDTO.getQuantityOfGoods());
                basketRepository.updateBasket(newBasket);
            } else {
                newBasket = basketRepository.addBasket(basketMapper.basketRequestDTOtoBasket(basketRequestDTO));
            }
        } else {
            newBasket = basketRepository.addBasket(basketMapper.basketRequestDTOtoBasket(basketRequestDTO));
        }
        return basketMapper.basketToBasketResponseDTO(newBasket);
    }

    @Override
    public List<BasketResponseDTO> getAllBasketsByOrderId(Long id) {
        List<Basket> baskets = basketRepository.getAllBasketsByOrderId(id);
        return baskets.stream().map(basketMapper::basketToBasketResponseDTO).toList();
    }

    @Override
    public boolean existBasketsByOrderId(Long id) {
        return !basketRepository.getAllBasketsByOrderId(id).isEmpty();
    }
}
