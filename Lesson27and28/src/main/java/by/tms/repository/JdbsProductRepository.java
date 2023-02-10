package by.tms.repository;

import by.tms.model.Product;
import by.tms.model.ProductType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class JdbsProductRepository implements JdbsProductRepositoryAware {
    private Connection connection;
    public final static String GET_ALL_PRODUCTS = "select * from products";
    public final static String GET_PRODUCTS_BY_TYPE = "select * from products where type=?";

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String type = resultSet.getString("type");
                ProductType productType = getProductType(type);
                String info = resultSet.getString("info");
                products.add(new Product(id, name, price, productType, info));
            }
        } catch (SQLException e) {
            System.out.println("SQLException (.getProducts()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception (.getProducts()): " + e.getMessage());
        }
        return products;
    }

    private static ProductType getProductType(String type) {
        return switch (type) {
            case "tv" -> ProductType.TV;
            case "phone" -> ProductType.PHONE;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    @Override
    public List<Product> getProductsByType(String type) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_PRODUCTS_BY_TYPE);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                ProductType productType = getProductType(type);
                String info = resultSet.getString("info");
                products.add(new Product(id, name, price, productType, info));
            }
        } catch (SQLException e) {
            System.out.println("SQLException (.getProducts()): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("IllegalStateException (productType): " + e.getMessage());
        }
        return products;
    }
}