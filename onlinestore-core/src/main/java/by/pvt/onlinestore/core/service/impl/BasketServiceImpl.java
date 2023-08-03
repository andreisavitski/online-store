package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.repository.BasketRepository;
import org.modelmapper.ModelMapper;

public class BasketServiceImpl {
    private final BasketRepository basketRepository;
    private final ModelMapper modelMapper;

    public BasketServiceImpl(BasketRepository basketRepository, ModelMapper modelMapper) {
        this.basketRepository = basketRepository;
        this.modelMapper = modelMapper;
    }
}
