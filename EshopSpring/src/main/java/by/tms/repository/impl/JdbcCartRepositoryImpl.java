package by.tms.repository.impl;

import by.tms.model.Cart;
import by.tms.model.Product;
import by.tms.repository.JdbcCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static by.tms.utils.RepositoryJdbcUtils.*;

@Slf4j
@Repository
@RequiredArgsConstructor
@Lazy
public class JdbcCartRepositoryImpl implements JdbcCartRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String ADD_PRODUCT_TO_CART = "insert into carts (user_id, product_id, cart, favorite) VALUES (?, ?, ?, ?)";
    private static final String GET_CART_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, pt.type, p.info, c.count from carts c join products p on p.id = c.product_id join product_type pt on pt.id = p.product_type_id where c.user_id=? and c.cart=true";
    //    private static final String GET_CART_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, p.type, p.info, c.count from carts c join products p on p.id = c.product_id where c.user_id=? and c.cart=true";
    private static final String GET_FAVORITE_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, pt.type, p.info, c.count from carts c join products p on p.id = c.product_id join product_type pt on pt.id = p.product_type_id where c.user_id=? and c.favorite=true";
    //    private static final String GET_FAVORITE_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, p.type, p.info, c.count from carts c join products p on p.id = c.product_id where c.user_id=? and c.favorite=true";
//    private static final String DELETE_FAVORITE_PRODUCT = "delete from carts where user_id=? and product_id=? and favorite=true";
//    private static final String DELETE_CART_PRODUCT = "delete from carts where user_id=? and product_id=? and cart=true";
    private static final String GET_CURRENT_PRODUCT_COUNT = "select count from carts where user_id=? and product_id=? and cart=true";
    private static final String UPDATE_CURRENT_PRODUCT_COUNT = "update carts set count=? where user_id=? and product_id=? and cart=true";
    private static final String DELETE_CART_PRODUCT_AFTER_BUY = "delete from carts where user_id=? and cart=true";

    @Override
    public void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite) {
        if (favorite) {
            if (checkProduct(userId, productId, false, true)) {
                addProduct(userId, productId, cart, true);
            }
        } else {
            if (checkProduct(userId, productId, true, false)) {
                addProduct(userId, productId, cart, false);
            } else {
                modifyProductCount(userId, productId, true);
            }
        }
    }

//    @Override
//    public void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite) {
//        if (favorite) {
//            deleteProductByMark(userId, productId, DELETE_FAVORITE_PRODUCT);
//        } else {
//            Integer productCount = getCartProductCount(userId, productId);
//            if (productCount > 1) {
//                modifyProductCount(userId, productId, false);
//            } else {
//                deleteProductByMark(userId, productId, DELETE_CART_PRODUCT);
//            }
//        }
//    }

    @Override
//    public List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite) {
    public List<ImmutablePair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite) {
//        List<Pair<Product, Integer>> products = new ArrayList<>();
        String query = cart ? GET_CART_PRODUCTS_BY_USER_ID : GET_FAVORITE_PRODUCTS_BY_USER_ID;
        //        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(query)) {
//            statement.setLong(1, userId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Product product = getProduct(resultSet);
//                Integer count = resultSet.getInt("count");
//                products.add(new ImmutablePair<>(product, count));
//            }
//        } catch (Exception e) {
//            log.error("Exception (getProductsFromCart()): ", e);
//        }
        return jdbcTemplate.query(query, (rs, i) -> new ImmutablePair<>(getProduct(rs), rs.getInt("count")));
    }

    @Override
    public boolean checkProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        List<Product> products = getProducts(userId, cart, favorite);
        return isProductNotIncluded(productId, products);
    }

    @Override
    public Integer getCartProductCount(Long userId, Long productId) {
        return jdbcTemplate.query(GET_CURRENT_PRODUCT_COUNT, new BeanPropertyRowMapper<>(Cart.class),
                        userId, productId).stream()
                .findAny()
                .map(Cart::getCount)
                .orElse(null);

//        int count = 0;
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(GET_CURRENT_PRODUCT_COUNT)) {
//            statement.setLong(1, userId);
//            statement.setLong(2, productId);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                count = resultSet.getInt("count");
//            }
//        } catch (Exception e) {
//            log.error("Exception (getCartProductCount()): ", e);
//        }
//        return count;
    }

    @Override
    public void deleteCartProductsAfterBuy(Long userId) {
        jdbcTemplate.update(DELETE_CART_PRODUCT_AFTER_BUY, userId);
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(DELETE_CART_PRODUCT_AFTER_BUY)) {
//            statement.setLong(1, userId);
//            statement.execute();
//        } catch (Exception e) {
//            log.error("Exception (deleteCartProductsAfterBuy()): ", e);
//        }
    }

    @Override
    public List<Product> getPurchasedProducts(Long userId, boolean cart, boolean favorite) {
        List<Product> products = new ArrayList<>();
        List<ImmutablePair<Product, Integer>> productWithCount = getProductsFromCart(userId, cart, favorite);
        for (Pair<Product, Integer> productIntegerPair : productWithCount) {
            Integer count = productIntegerPair.getRight();
            while (count > 0) {
                products.add(productIntegerPair.getLeft());
                count--;
            }
        }
        return products;
    }

    private void addProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        jdbcTemplate.update(ADD_PRODUCT_TO_CART, userId, productId, cart, favorite);
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(ADD_PRODUCT_TO_CART)) {
//            statement.setLong(1, userId);
//            statement.setLong(2, productId);
//            statement.setBoolean(3, cart);
//            statement.setBoolean(4, favorite);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            log.error("Exception (addProductToCart()): ", e);
//        }
    }

    private void modifyProductCount(Long userId, Long productId, boolean up) {
        Integer productCount = getCartProductCount(userId, productId);
        productCount = getModifyCount(up, productCount);
        jdbcTemplate.update(UPDATE_CURRENT_PRODUCT_COUNT, productCount, userId, productId);
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//             PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(UPDATE_CURRENT_PRODUCT_COUNT)) {
//            statement.setInt(1, productCount);
//            statement.setLong(2, userId);
//            statement.setLong(3, productId);
//            statement.executeUpdate();
//        } catch (Exception e) {
//            log.error("Exception (deleteProductCartCount()): ", e);
//        }
    }

    private List<Product> getProducts(Long userId, boolean cart, boolean favorite) {
        return getProductsFromCart(userId, cart, favorite).stream()
                .map(Pair::getLeft)
                .collect(Collectors.toList());
    }
//
//    private void deleteProductByMark(Long userId, Long productId, String query) {
//        try (ConnectionWrapper connectionWrapper = CONNECTION_POOL.getConnectionWrapper();
//                PreparedStatement statement = connectionWrapper.getConnection().prepareStatement(query)) {
//            statement.setLong(1, userId);
//            statement.setLong(2, productId);
//            statement.execute();
//        } catch (Exception e) {
//            log.error("Exception (deleteProductByMark()): ", e);
//        }
//    }
}