package by.tms.repository.impl;

import static by.tms.utils.RepositoryJdbcUtils.fillsCollectionValues;
import static by.tms.utils.RepositoryJdbcUtils.fillsSet;
import static by.tms.utils.RepositoryJdbcUtils.getQueryDependType;

import by.tms.model.Product;
import by.tms.repository.ConnectionWrapper;
import by.tms.repository.JdbcProductRepository;
import by.tms.utils.RepositoryJdbcUtils;
import java.math.BigDecimal;
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

    private static final String GET_ALL_PRODUCTS = "select * from products";
    private static final String GET_PRODUCTS_BY_TYPE = "select * from products where type=?";
    private static final String GET_PRODUCT_TYPE = "select type from products where id=?";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_NAME = "select * from products where lower(name) like lower(?)";
    private static final String GET_PRODUCTS_BY_SEARCH_CONDITION_IN_INFO = "select * from products where lower(info) like lower(?)";
    private static final String GET_PRODUCT = "select * from products where id=?";
    private static final String SELECT_ALL_PRODUCTS_BY_FILTER = "select * from products p where p.price>=? and p.price<=?";

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

    @Override
    public Product getOneProduct(Long id) {
        Product product = Product.builder().build();
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_PRODUCT)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                product = RepositoryJdbcUtils.getProduct(resultSet);
            }
        } catch (Exception e) {
            log.error("Exception (getOneProduct()): ", e);
        }
        return product;
    }

    @Override
    public Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice) {
        Set<Product> products = new LinkedHashSet<>();
        String query = getQueryDependType(type, SELECT_ALL_PRODUCTS_BY_FILTER);
        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(query)) {
            statement.setBigDecimal(1, minPrice);
            statement.setBigDecimal(2, maxPrice);
            fillsCollectionValues(products, statement);
        } catch (Exception e) {
            log.error("Exception (selectAllProductsByFilter()): ", e);
        }
        return products;
    }
}