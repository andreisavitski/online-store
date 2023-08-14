package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.repository.ProductRepository;
import by.pvt.onlinestore.core.service.ProductService;
import org.modelmapper.ModelMapper;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
}
