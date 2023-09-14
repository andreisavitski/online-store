package by.pvt.onlinestore.core.repository.impl.db;

import by.pvt.onlinestore.core.config.PostgresConnection;
import by.pvt.onlinestore.core.domain.User;
import by.pvt.onlinestore.core.mapper.UserMapper;
import by.pvt.onlinestore.core.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDbRepository implements UserRepository {
    private final PostgresConnection postgresConnection;
    private final UserMapper userMapper;
    private final String ADD_USER = "insert into shopsch.user (id, name, surname, login, password, role) values (?, ?, ?, ?, ?, ?)";
    private final String DELETE_USER = "delete from shopsch.user u where u.id = ?";
    private final String MAX_ID = "select max(id) from shopsch.user u";
    private final String ALL_USERS = "select * from shopsch.user u";
    private final String USER_BY_LOGIN = "select * from shopsch.user u where u.login = ?";
    private final String USER_BY_ID = "select * from shopsch.user u where u.id = ?";

    public UserDbRepository(PostgresConnection postgresConnection, UserMapper userMapper) {
        this.postgresConnection = postgresConnection;
        this.userMapper = userMapper;
    }

    @Override
    public User addUser(User user) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(MAX_ID);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            long maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
            user.setId(maxId + 1);
            preparedStatement.setLong(1, maxId + 1);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, String.valueOf(user.getRole()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<User> getAllUser() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(ALL_USERS);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User user = userMapper.mapResultSetToUser(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return users;
    }

    @Override
    public User getUserById(Long id) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return new User();
            }
            return userMapper.mapResultSetToUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public User getUserByLogin(String login) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("User with this login does not exist");
            }
            return userMapper.mapResultSetToUser(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean existByLogin(String login) {
        Connection connection;
        connection = postgresConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
