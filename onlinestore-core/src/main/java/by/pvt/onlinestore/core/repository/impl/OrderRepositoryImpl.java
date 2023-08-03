package by.pvt.onlinestore.core.repository.impl;

import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.repository.OrderRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderRepositoryImpl implements OrderRepository {
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\orders";

    @Override
    public List<Order> getAllOrders() {
        return deserializeObject();
    }


    private void serializeObject(List<Order> orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(UserRepositoryImpl.PATH))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Order> deserializeObject() {
        List<Order> orders;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(UserRepositoryImpl.PATH))) {
            orders = (List<Order>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
