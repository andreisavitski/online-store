package by.pvt.onlinestore.core.repository.impl.db;

import by.pvt.onlinestore.core.config.PostgresConnection;
import by.pvt.onlinestore.core.domain.Product;
import by.pvt.onlinestore.core.mapper.ProductMapper;
import by.pvt.onlinestore.core.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDbRepository implements ProductRepository {
    private final PostgresConnection postgresConnection;
    private final ProductMapper productMapper;
    private final String ADD_PRODUCT = "insert into shopsch.product (id, sku, name, type, price, description, quantity) values (?, ?, ?, ?, ?, ?, ?)";
    private final String DELETE_PRODUCT = "delete from shopsch.product p where p.id = ?";
    private final String MAX_ID = "select max(id) from shopsch.product p";
    private final String ALL_PRODUCTS = "select * from shopsch.product p";
    private final String PRODUCT_BY_ID = "select * from shopsch.product u where u.id = ?";
    private final String PRODUCT_BY_SKU = "select * from shopsch.product u where u.sku = ?";
    private final String UPDATE_PRODUCT = "update shopsch.product set sku = ?, name = ?, type = ?, price = ?, description = ?, quantity = ?  where id = ?";

    public ProductDbRepository(PostgresConnection postgresConnection, ProductMapper productMapper) {
        this.postgresConnection = postgresConnection;
        this.productMapper = productMapper;
    }

    @Override
    public void addProduct(Product product) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(MAX_ID);
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            long maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            product.setProductId(maxId + 1);
            preparedStatement.setLong(1, maxId + 1);
            preparedStatement.setString(2, product.getProductSku());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setString(4, String.valueOf(product.getProductType()));
            preparedStatement.setLong(5, product.getPrice());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setInt(7, product.getQuantityInStock());
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

    @Override
    public void updateProduct(Product product) {
        getProductById(product.getProductId());
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getProductSku());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, String.valueOf(product.getProductType()));
            preparedStatement.setLong(4, product.getPrice());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getQuantityInStock());
            preparedStatement.setLong(7, product.getProductId());
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

    @Override
    public void deleteProductById(Long id) {
        getProductById(id);
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setLong(1, id);
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

    @Override
    public void deleteProductWithoutSaving(Long id) {
    }

    @Override
    public List<Product> getAllProducts() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery(ALL_PRODUCTS);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Product product = productMapper.mapResultSerToProduct(resultSet);
                products.add(product);
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
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        Connection connection = null;
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("There is no product with this ID");
            }
            return productMapper.mapResultSerToProduct(resultSet);
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
    public boolean existProductById(Long id) {
        Connection connection;
        connection = postgresConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_BY_ID);
            preparedStatement.setLong(1, id);
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

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public Product getProductBySku(String productSku) {
        return null;
    }

    @Override
    public Product getProductByIdForChange(Long id) {
        return null;
    }

    @Override
    public boolean existBySku(String sku) {
        Connection connection;
        connection = postgresConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_BY_SKU);
            preparedStatement.setString(1, sku);
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

    @Override
    public List<Product> getAllProductsById(List<Long> productsId) {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(PRODUCT_BY_ID);
            for (Long productId : productsId) {
                preparedStatement.setLong(1, productId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Product product = productMapper.mapResultSerToProduct(resultSet);
                    products.add(product);
                }
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
        return products;
    }
}
