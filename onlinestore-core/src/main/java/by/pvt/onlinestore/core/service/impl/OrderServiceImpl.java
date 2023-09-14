package by.pvt.onlinestore.core.service.impl;

import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.domain.Status;
import by.pvt.onlinestore.core.dto.basket.BasketResponseDTO;
import by.pvt.onlinestore.core.dto.order.OrderRequestDTO;
import by.pvt.onlinestore.core.dto.order.OrderResponseDTO;
import by.pvt.onlinestore.core.dto.product.ProductResponseDTO;
import by.pvt.onlinestore.core.mapper.BasketMapper;
import by.pvt.onlinestore.core.mapper.OrderMapper;
import by.pvt.onlinestore.core.mapper.ProductMapper;
import by.pvt.onlinestore.core.repository.BasketRepository;
import by.pvt.onlinestore.core.repository.OrderRepository;
import by.pvt.onlinestore.core.repository.ProductRepository;
import by.pvt.onlinestore.core.service.OrderService;

import java.util.List;
import java.util.stream.LongStream;

import static org.apache.commons.lang3.math.NumberUtils.min;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;
    private final BasketMapper basketMapper;
    private final ProductMapper productMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, BasketRepository basketRepository, ProductRepository productRepository, BasketMapper basketMapper, ProductMapper productMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
        this.basketMapper = basketMapper;
        this.productMapper = productMapper;
    }

    @Override
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderRepository.addOrder(orderMapper.mapOrderRequestDTOtoOrder(orderRequestDTO));
        return orderMapper.mapOrderToOrderResponseDTO(order);
    }

    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        List<Basket> baskets = basketRepository.getAllBasketsByOrderId(orderId);
        List<BasketResponseDTO> basketResponseDTOS = baskets.stream().map(basketMapper::mapBasketToBasketResponseDTO).toList();
        List<Long> listProductId = baskets.stream().map(Basket::getProductId).toList();
        List<Product> products = productRepository.getAllProductsById(listProductId);
        List<ProductResponseDTO> productResponseDTOS = products.stream().map(productMapper::mapProductToProductResponseDTO).toList();
        List<Integer> listQuantityOfGoods = baskets.stream().map(Basket::getQuantityOfGoods).toList();
        List<Long> listQuantityOfGoodsLong = listQuantityOfGoods.stream().map(Long::valueOf).toList();
        List<Long> priceList = products.stream().map(Product::getPrice).toList();
        Long totalCost = LongStream.range(0, min(priceList.size(), listQuantityOfGoodsLong.size())).map(i -> priceList.get((int) i) * listQuantityOfGoodsLong.get((int) i)).sum();
        Order order = orderRepository.getOrderById(orderId);
        order.setTotalCost(totalCost);
        orderRepository.updateTotalCost(order);
        OrderResponseDTO orderResponseDTO = orderMapper.mapOrderToOrderResponseDTO(order);
        orderResponseDTO.setBaskets(basketResponseDTOS);
        orderResponseDTO.setProducts(productResponseDTOS);
        orderResponseDTO.setTotalCost(totalCost);
        return orderResponseDTO;
    }

    @Override
    public OrderResponseDTO closeOrderById(Long id) {
        Order order = orderRepository.getOrderById(id);
        order.setStatus(Status.WAITING_FOR_COURIER);
        orderRepository.updateStatus(order);
        return orderMapper.mapOrderToOrderResponseDTO(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);
        basketRepository.deleteBasketByOrderId(id);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.getAllOrders();
        if (orders.isEmpty()) {
            throw new RuntimeException("No orders");
        }
        return orders.stream().map(orderMapper::mapOrderToOrderResponseDTO).toList();
    }

    @Override
    public List<OrderResponseDTO> getOrderByUserId(Long id) {
        List<Order> orders = orderRepository.getOrderByUserId(id);
        if (orders.isEmpty()) {
            throw new RuntimeException("This user has no orders");
        }
        return orders.stream().map(orderMapper::mapOrderToOrderResponseDTO).toList();
    }
}
