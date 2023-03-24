package by.tms.repository.impl;

import static by.tms.utils.RepositoryJdbcUtils.fillsValues;

import by.tms.model.Product;
import by.tms.repository.ConnectionWrapper;
import by.tms.repository.JdbcProductRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class JdbcProductRepositoryImpl implements JdbcProductRepository {

    //    private ConnectionPool CONNECTION_POOL;
    private static final String GET_ALL_PRODUCTS = "select * from products";
    private static final String GET_PRODUCTS_BY_TYPE = "select * from products where type=?";
    private static final String GET_PRODUCT_TYPE = "select type from products where id=?";
    private static final String GET_PRODUCT_BY_SEARCH_CONDITION_IN_NAME = "select * from products where lower(name) like lower(?)";
    private static final String GET_PRODUCT_BY_SEARCH_CONDITION_IN_INFO = "select * from products where lower(info) like lower(?)";
    private static final String ADD_PRODUCT_TO_FOUNDED_PRODUCTS = "insert into founded_products (user_uuid, product_id) VALUES (?, ?)";

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
            log.error("Exception (getProductTypeValue()): ", e);
        }
        return type;
    }

    @Override
    public Set<Product> getFoundProducts(String searchCondition) {
        Set<Product> products = new LinkedHashSet<>();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statementByName = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT_BY_SEARCH_CONDITION_IN_NAME);
                PreparedStatement statementByInfo = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT_BY_SEARCH_CONDITION_IN_INFO)) {
            statementByName.setString(1, "%" + searchCondition + "%");
            fillsValues(products, statementByName);
            statementByInfo.setString(1, "%" + searchCondition + "%");
            fillsValues(products, statementByInfo);
        } catch (Exception e) {
            log.error("Exception (getFoundProducts()): ", e);
        }
        return products;
    }

    @Override
    public void saveFoundedProducts(Set<Product> products, String userUUID) {
        for (Product product : products) {
            addProductToFoundedProducts(userUUID, product);
        }
    }

    @Override
    public Set<Product> getProductsByUserSearchCondition(String userUUID) {
        //join for search
        return null;
    }

    private void addProductToFoundedProducts(String userUUID, Product product) {
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(ADD_PRODUCT_TO_FOUNDED_PRODUCTS)) {
            statement.setString(1, userUUID);
            statement.setLong(2, product.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            log.error("Exception (addProductToFoundedProducts()): ", e);
        }
    }
}