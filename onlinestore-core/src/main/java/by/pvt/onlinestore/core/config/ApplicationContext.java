package by.pvt.onlinestore.core.config;

import by.pvt.onlinestore.core.repository.OrderRepository;
import by.pvt.onlinestore.core.repository.ProductRepository;
import by.pvt.onlinestore.core.repository.UserRepository;
import by.pvt.onlinestore.core.repository.impl.OrderRepositoryImpl;
import by.pvt.onlinestore.core.repository.impl.ProductRepositoryImpl;
import by.pvt.onlinestore.core.repository.impl.UserRepositoryImpl;
import by.pvt.onlinestore.core.service.OrderService;
import by.pvt.onlinestore.core.service.ProductService;
import by.pvt.onlinestore.core.service.UserService;
import by.pvt.onlinestore.core.service.impl.OrderServiceImpl;
import by.pvt.onlinestore.core.service.impl.ProductServiceImpl;
import by.pvt.onlinestore.core.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final ModelMapper modelMapper;
    private UserRepository userRepository;
    private UserService userService;
    private ProductRepository productRepository;
    private ProductService productService;
    private OrderRepository orderRepository;
    private OrderService orderService;

    public ApplicationContext() {
        modelMapper = new ModelMapper();
        userRepository = new UserRepositoryImpl();
        userService = new UserServiceImpl((UserRepositoryImpl) userRepository, modelMapper);
        productRepository = new ProductRepositoryImpl();
        productService = new ProductServiceImpl((ProductRepositoryImpl) productRepository, modelMapper);
        orderRepository = new OrderRepositoryImpl();
        orderService = new OrderServiceImpl((OrderRepositoryImpl) orderRepository, modelMapper);
    }
}
