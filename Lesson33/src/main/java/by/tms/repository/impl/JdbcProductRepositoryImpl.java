package by.tms.repository.impl;

import static by.tms.utils.RepositoryJdbcUtils.fillsValues;

import by.tms.model.Product;
import by.tms.repository.ConnectionWrapper;
import by.tms.repository.JdbcProductRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class JdbcProductRepositoryImpl implements JdbcProductRepository {

    //    private ConnectionPool CONNECTION_POOL;
    private static final String GET_ALL_PRODUCTS = "select * from products";
    private static final String GET_PRODUCTS_BY_TYPE = "select * from products where type=?";
    private static final String GET_PRODUCT_TYPE = "select type from products where id=?";

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_ALL_PRODUCTS)) {
            fillsValues(products, statement);
        } catch (Exception e) {
            log.error("Exception (getProducts()): ", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductsByType(String type) {
        List<Product> products = new ArrayList<>();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_TYPE)) {
            statement.setString(1, type);
            fillsValues(products, statement);
        } catch (Exception e) {
            log.error("Exception (getProductsByType()): ", e);
        }
        return products;
    }

    @Override
    public String getProductTypeValue(Long productId) {
        String type = "";
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT_TYPE)) {
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                type = resultSet.getString("type");
            }
        } catch (Exception e) {
            log.error("Exception (getProductTypeValue): ", e);
        }
        return type;
    }
}