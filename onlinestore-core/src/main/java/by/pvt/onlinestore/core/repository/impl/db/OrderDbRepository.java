package by.pvt.onlinestore.core.repository.impl.db;

import by.pvt.onlinestore.core.config.PostgresConnection;
import by.pvt.onlinestore.core.domain.Order;
import by.pvt.onlinestore.core.mapper.OrderMapper;
import by.pvt.onlinestore.core.repository.OrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDbRepository implements OrderRepository {
    private final PostgresConnection postgresConnection;
    private final OrderMapper orderMapper;

    private final String ADD_ORDERS = "insert into shopsch.order (id, user_id, total_cost, status) values (?, ?, ?, ?)";
    private final String DELETE_ORDER = "delete from shopsch.order o where o.id = ?";
    private final String MAX_ID = "select max(id) from shopsch.order o";
    private final String ALL_ORDER = "select * from shopsch.order o";
    private final String ALL_ORDER_BY_USER_ID = "select * from shopsch.order o where o.user_id = ?";
    private final String ORDER_BY_ID = "select * from shopsch.order o where o.id = ?";
    private final String UPDATE_TOTAL_COST = "update shopsch.order set total_cost = ? where id = ?";
    private final String UPDATE_STATUS = "update shopsch.order set status = ? where id = ?";

    public OrderDbRepository(PostgresConnection postgresConnection, OrderMapper orderMapper) {
        this.postgresConnection = postgresConnection;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> getAllOrders() {
        Connection connection = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(ALL_ORDER);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Order order = orderMapper.mapResultSetToOrder(resultSet);
                orders.add(order);
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
        return orders;
    }

    @Override
    public Order addOrder(Order order) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(MAX_ID);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            long maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDERS);
            order.setId(maxId + 1);
            preparedStatement.setLong(1, maxId + 1);
            preparedStatement.setLong(2, order.getUserId());
            preparedStatement.setLong(3, 0L);
            preparedStatement.setString(4, String.valueOf(order.getStatus()));
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
        return order;
    }

    @Override
    public void deleteOrderById(Long id) {

    }

    @Override
    public Order getOrderById(Long id) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ORDER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return new Order();
            }
            return orderMapper.mapResultSetToOrder(resultSet);
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
    public Order updateTotalCost(Order order) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOTAL_COST);
            preparedStatement.setLong(1, order.getTotalCost());
            preparedStatement.setLong(2, order.getId());
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
        return order;
    }

    @Override
    public Order updateStatus(Order order) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS);
            preparedStatement.setString(1, String.valueOf(order.getStatus()));
            preparedStatement.setLong(2, order.getId());
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
        return order;
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        Connection connection = null;
        List<Order> orders = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ALL_ORDER_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Order order = orderMapper.mapResultSetToOrder(resultSet);
                orders.add(order);
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
        return orders;
    }
}
