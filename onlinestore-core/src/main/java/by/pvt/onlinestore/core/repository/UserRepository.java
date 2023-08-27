package by.pvt.onlinestore.core.repository;

import by.pvt.onlinestore.core.domain.User;

import java.util.List;

public interface UserRepository {
    User addUser(User user);

    void deleteUserById(Long id);

    List<User> getAllUser();

    User getUserById(Long id);

    User getByLogin(String login);

    boolean existByLogin(String login);
}
