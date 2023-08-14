package by.pvt.onlinestore.core.repository.impl;


import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\clients";

    public UserRepositoryImpl() {
    }

    @Override
    public void addUser(User user) {
        user.setId((idCounter.getAndIncrement()));
        users.add(user);
        serializeObject(users);
    }

    @Override
    public void deleteUserById(Long id) {
        List<User> users = deserializeObject();
        if (users.isEmpty()) return;
        User user = getUserById(id);
        users.remove(user);
        serializeObject(users);
    }

    @Override
    public List<User> getAllUser() {
        return deserializeObject();
    }

    @Override
    public User getUserById(Long id) {
        try {
            return deserializeObject().stream().filter(a -> Objects.equals(a.getId(), id)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("User with given Id does not exist.");
        }
    }

    private void serializeObject(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(UserRepositoryImpl.PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<User> deserializeObject() {
        List<User> users;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(UserRepositoryImpl.PATH))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
