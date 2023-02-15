package by.tms.repository;

import by.tms.model.Product;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.tms.utils.RepositoryJdbsUtils.fillsValues;

@AllArgsConstructor
public class JdbsProductRepository implements JdbsProductRepositoryAware {
    private Connection connection;
    private final static String GET_ALL_PRODUCTS = "select * from products";
    private final static String GET_PRODUCTS_BY_TYPE = "select * from products where type=?";
    private final static String GET_PRODUCT_TYPE = "select type from products where id=?";

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCTS);
            fillsValues(products, statement);
        } catch (SQLException e) {
            System.out.println("SQLException (getProducts()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (getProducts()): " + e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getProductsByType(String type) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCTS_BY_TYPE);
            statement.setString(1, type);
            fillsValues(products, statement);
        } catch (SQLException e) {
            System.out.println("SQLException (getProductsByType()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("IllegalStateException (getProductsByType()): " + e.getMessage());
        }
        return products;
    }

    @Override
    public String getProductTypeValue(Long productId) {
        String type = "";
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCT_TYPE);
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                type = resultSet.getString("type");
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getProductTypeValue): " + e.getMessage());
        }
        return type;
    }
}