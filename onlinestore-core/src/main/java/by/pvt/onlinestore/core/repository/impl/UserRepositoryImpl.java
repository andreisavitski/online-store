package by.pvt.onlinestore.core.repository.impl;


import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl extends FileWorker implements UserRepository {
    public static final String PATH = "D:\\ITACADEMY\\Projects\\OnlineStore\\onlinestore-core\\src\\main\\resources\\dbfile\\clients.txt";

    public UserRepositoryImpl() {
    }

    @Override
    public User addUser(User user) {
        List<User> userList = getUsers();
        user.setId((long) (userList.size() + 1));
        List<User> users = getUsers();
        users.add(user);
        serializeObject(users, PATH);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        List<User> users = getUsers();
        if (users.isEmpty()) return;
        User user = getUserById(id);
        users.remove(user);
        serializeObject(users, PATH);
    }

    @Override
    public List<User> getAllUser() {
        return getUsers();
    }

    @Override
    public User getUserById(Long id) {
        try {
            return getUsers().stream().filter(a -> Objects.equals(a.getId(), id)).toList().get(0);
        } catch (Exception e) {
            throw new RuntimeException("User with given Id does not exist.");
        }
    }

    @Override
    public User getByLogin(String login) {
        List<User> users = getUsers();
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst().orElse(null);
    }

    @Override
    public boolean existByLogin(String login) {
        return getUsers().stream().anyMatch(user -> login.equals(user.getLogin()));
    }

    private List<User> getUsers() {
        Object o = deserializeObject(PATH);
        List<User> users = new ArrayList<>();
        if (o instanceof List<?>) {
            users = (List<User>) o;
        }
        return users;
    }
}
