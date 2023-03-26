package by.tms.repository.impl;

import static by.tms.utils.RepositoryJdbcUtils.fillsCollectionValues;

import by.tms.model.Product;
import by.tms.repository.ConnectionWrapper;
import by.tms.repository.JdbcProductRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    //    private static final String GET_PRODUCT_BY_SEARCH_CONDITION_IN_NAME = "select * from products where lower(name) like lower(?)";
//    private static final String GET_PRODUCT_BY_SEARCH_CONDITION_IN_INFO = "select * from products where lower(info) like lower(?)";
    private static final String ADD_PRODUCT_TO_FOUNDED_PRODUCTS = "insert into founded_products (user_uuid, product_id) VALUES (?, ?)";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME = "select id from products where lower(name) like lower(?)";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO = "select id from products where lower(info) like lower(?)";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_FOR_USER = "select p.id, p.name, p.price, p.type, p.info from founded_products fp join products p on fp.product_id = p.id where user_uuid = ?";
    private static final String DELETE_FOUND_PRODUCTS_BY_USER_UUID = "delete from founded_products where user_uuid = ?";


    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_ALL_PRODUCTS)) {
            fillsCollectionValues(products, statement);
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
            fillsCollectionValues(products, statement);
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
//        Set<Product> products = new LinkedHashSet<>();
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statementByName = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT_BY_SEARCH_CONDITION_IN_NAME);
//                PreparedStatement statementByInfo = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT_BY_SEARCH_CONDITION_IN_INFO)) {
//            statementByName.setString(1, "%" + searchCondition + "%");
//            fillsCollectionValues(products, statementByName);
//            statementByInfo.setString(1, "%" + searchCondition + "%");
//            fillsCollectionValues(products, statementByInfo);
//        } catch (Exception e) {
//            log.error("Exception (getFoundProducts()): ", e);
//        }
//        return products;

        Set<Product> products = new LinkedHashSet<>();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statementByName = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME);
                PreparedStatement statementByInfo = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO)) {
            fillsSet(searchCondition, products, statementByName);
            fillsSet(searchCondition, products, statementByInfo);
        } catch (Exception e) {
            log.error("Exception (getFoundProducts()): ", e);
        }
        return products;
    }

    private void fillsSet(String searchCondition, Set<Product> products, PreparedStatement statement) throws SQLException {
        statement.setString(1, "%" + searchCondition + "%");
        ResultSet resultSetByName = statement.executeQuery();
        while (resultSetByName.next()) {
            Product product = Product.builder()
                                     .id(resultSetByName.getLong("id"))
                                     .build();
            products.add(product);
        }
    }

    @Override
    public void saveFoundedProducts(Set<Product> products, String userUUID) {
        for (Product product : products) {
            addProductToFoundedProducts(userUUID, product);
        }
    }

    @Override
    public Set<Product> getProductsByUserSearchCondition(String userUUID) {
        Set<Product> products = new LinkedHashSet<>();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCTS_BY_SEARCH_CONDITION_FOR_USER)) {
            statement.setString(1, userUUID);
            fillsCollectionValues(products, statement);
        } catch (Exception e) {
            log.error("Exception (getProductsByUserSearchCondition()): ", e);
        }

        //join for search
        return products;
    }

    @Override
    public void deleteFoundProducts(String userUUID) {
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(DELETE_FOUND_PRODUCTS_BY_USER_UUID)) {
            statement.setString(1, userUUID);
            statement.execute();
        } catch (Exception e) {
            log.error("Exception (deleteFoundProducts()): ", e);
        }
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