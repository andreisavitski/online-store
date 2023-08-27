package by.pvt.onlinestore.core.config;

import by.pvt.onlinestore.core.mapper.BasketMapper;
import by.pvt.onlinestore.core.mapper.OrderMapper;
import by.pvt.onlinestore.core.mapper.ProductMapper;
import by.pvt.onlinestore.core.mapper.UserMapper;
import by.pvt.onlinestore.core.mapper.impl.BasketMapperImpl;
import by.pvt.onlinestore.core.mapper.impl.OrderMapperImpl;
import by.pvt.onlinestore.core.mapper.impl.ProductMapperImpl;
import by.pvt.onlinestore.core.mapper.impl.UserMapperImpl;
import by.pvt.onlinestore.core.repository.BasketRepository;
import by.pvt.onlinestore.core.repository.OrderRepository;
import by.pvt.onlinestore.core.repository.ProductRepository;
import by.pvt.onlinestore.core.repository.UserRepository;
import by.pvt.onlinestore.core.repository.impl.BasketRepositoryImpl;
import by.pvt.onlinestore.core.repository.impl.OrderRepositoryImpl;
import by.pvt.onlinestore.core.repository.impl.ProductRepositoryImpl;
import by.pvt.onlinestore.core.repository.impl.UserRepositoryImpl;
import by.pvt.onlinestore.core.service.BasketService;
import by.pvt.onlinestore.core.service.OrderService;
import by.pvt.onlinestore.core.service.ProductService;
import by.pvt.onlinestore.core.service.UserService;
import by.pvt.onlinestore.core.service.impl.BasketServiceImpl;
import by.pvt.onlinestore.core.service.impl.OrderServiceImpl;
import by.pvt.onlinestore.core.service.impl.ProductServiceImpl;
import by.pvt.onlinestore.core.service.impl.UserServiceImpl;


public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final BasketMapper basketMapper;
    private final BasketRepository basketRepository;
    private final BasketService basketService;

    public ApplicationContext() {
        userMapper = new UserMapperImpl();
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl(userRepository, userMapper);
        productMapper = new ProductMapperImpl();
        productRepository = new ProductRepositoryImpl();
        productService = new ProductServiceImpl(productRepository, productMapper);
        basketMapper = new BasketMapperImpl();
        basketRepository = new BasketRepositoryImpl();
        basketService = new BasketServiceImpl(basketRepository, basketMapper, userRepository);
        orderMapper = new OrderMapperImpl();
        orderRepository = new OrderRepositoryImpl();
        orderService = new OrderServiceImpl(orderRepository, orderMapper, basketRepository, productRepository, basketMapper, productMapper);
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContext.applicationContext = applicationContext;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public ProductService getProductService() {
        return productService;
    }

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public BasketMapper getBasketMapper() {
        return basketMapper;
    }

    public BasketRepository getBasketRepository() {
        return basketRepository;
    }

    public BasketService getBasketService() {
        return basketService;
    }
}
