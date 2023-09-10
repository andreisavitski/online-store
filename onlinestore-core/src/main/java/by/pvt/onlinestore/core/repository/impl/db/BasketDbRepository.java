package by.pvt.onlinestore.core.repository.impl.db;

import by.pvt.onlinestore.core.config.PostgresConnection;
import by.pvt.onlinestore.core.domain.Basket;
import by.pvt.onlinestore.core.mapper.BasketMapper;
import by.pvt.onlinestore.core.repository.BasketRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketDbRepository implements BasketRepository {
    private final PostgresConnection postgresConnection;
    private final BasketMapper basketMapper;
    private final String ADD_BASKET = "insert into shopsch.basket (id, product_id, order_id, quantity_of_goods) values (?, ?, ?, ?)";
    private final String DELETE_BASKET = "delete from shopsch.basket b where b.order_id = ? and b.product_id = ?";
    private final String EXIST_BASKET = "select from shopsch.basket b where b.order_id = ? and b.product_id = ?";
    private final String MAX_ID = "select max(id) from shopsch.basket b";
    private final String ALL_BASKET = "select * from shopsch.basket b";
    private final String ALL_BASKET_BY_ID = "select * from shopsch.basket b where b.order_id = ?";
    private final String BASKET_BY_ID = "select * from shopsch.basket b where b.id = ?";
    private final String UPDATE_QUANTITY_OF_GOODS = "update shopsch.basket set quantity_of_goods = ? where id = ?";

    public BasketDbRepository(PostgresConnection postgresConnection, BasketMapper basketMapper) {
        this.postgresConnection = postgresConnection;
        this.basketMapper = basketMapper;
    }

    @Override
    public List<Basket> getAllBaskets() {
        Connection connection = null;
        List<Basket> baskets = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(ALL_BASKET);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Basket basket = basketMapper.mapResultSetToBasket(resultSet);
                baskets.add(basket);
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
        return baskets;
    }

    @Override
    public Basket addBasket(Basket basket) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(MAX_ID);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            long maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BASKET);
            basket.setBasketId(maxId + 1);
            preparedStatement.setLong(1, maxId + 1);
            preparedStatement.setLong(2, basket.getProductId());
            preparedStatement.setLong(3, basket.getOrderId());
            preparedStatement.setInt(4, basket.getQuantityOfGoods());
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
        return basket;
    }

    @Override
    public void deleteBasketById(Long id) {
    }

    @Override
    public Basket getBasketById(Long id) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BASKET_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return new Basket();
            }
            return basketMapper.mapResultSetToBasket(resultSet);
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
    public List<Basket> getAllBasketsByOrderId(Long orderId) {
        Connection connection = null;
        List<Basket> baskets = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ALL_BASKET_BY_ID);
            preparedStatement.setLong(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Basket basket = basketMapper.mapResultSetToBasket(resultSet);
                baskets.add(basket);
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
        return baskets;
    }

    @Override
    public Basket updateBasket(Basket basket) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUANTITY_OF_GOODS);
            preparedStatement.setLong(1, basket.getQuantityOfGoods());
            preparedStatement.setLong(2, basket.getBasketId());
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
        return basket;
    }

    @Override
    public void deleteBasketByOrderId(Long id) {
    }

    @Override
    public void deleteBasketByOrderIdAndProductId(Basket basket) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EXIST_BASKET);
            preparedStatement.setLong(1, basket.getOrderId());
            preparedStatement.setLong(2, basket.getProductId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("This product is not in the basket");
            }
            preparedStatement = connection.prepareStatement(DELETE_BASKET);
            preparedStatement.setLong(1, basket.getOrderId());
            preparedStatement.setLong(2, basket.getProductId());
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
    }
}
