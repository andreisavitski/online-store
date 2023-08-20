package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.mapper.BasketMapper;
import by.pvt.onlinestore.core.repository.BasketRepository;

public class BasketServiceImpl {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;

    public BasketServiceImpl(BasketRepository basketRepository, BasketMapper basketMapper) {
        this.basketRepository = basketRepository;
        this.basketMapper = basketMapper;
    }
}
