package by.tms.repository.impl;

import static by.tms.utils.RepositoryJdbcUtils.fillsValues;

import by.tms.model.Product;
import by.tms.repository.ConnectionPool;
import by.tms.repository.JdbcProductRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcProductRepositoryImpl implements JdbcProductRepository {

    private ConnectionPool connectionPool;
    private static final String GET_ALL_PRODUCTS = "select * from products";
    private static final String GET_PRODUCTS_BY_TYPE = "select * from products where type=?";
    private static final String GET_PRODUCT_TYPE = "select type from products where id=?";

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCTS);
            fillsValues(products, statement);
        } catch (SQLException e) {
            System.out.println("SQLException (getProducts()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (getProducts()): " + e.getMessage());
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                System.out.println("Exception (getProducts().connectionPool): " + e.getMessage());
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductsByType(String type) {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCTS_BY_TYPE);
            statement.setString(1, type);
            fillsValues(products, statement);
        } catch (SQLException e) {
            System.out.println("SQLException (getProductsByType()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("IllegalStateException (getProductsByType()): " + e.getMessage());
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                System.out.println("Exception (getProductsByType().connectionPool): " + e.getMessage());
            }
        }
        return products;
    }

    @Override
    public String getProductTypeValue(Long productId) {
        String type = "";
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCT_TYPE);
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                type = resultSet.getString("type");
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getProductTypeValue): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (getProductTypeValue().connectionPool.getConnection): " + e.getMessage());
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                System.out.println("Exception (getProductTypeValue().connectionPool): " + e.getMessage());
            }
        }
        return type;
    }
}