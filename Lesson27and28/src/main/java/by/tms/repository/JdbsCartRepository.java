package by.tms.repository;

import by.tms.model.Product;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbsCartRepository implements JdbsCartRepositoryAware {
    private Connection connection;
    private static final String ADD_PRODUCT_TO_CART = "insert into carts (user_id, product_id, cart, favorite) VALUES (?, ?, ?, ?)";
    private static final String GET_CART_PRODUCTS_BY_USER_ID = "select (p.name, p.price, c.count) from carts c join products p on p.id = c.product_id where c.user_id=? and c.cart=true";
    private static final String GET_FAVORITE_PRODUCTS_BY_USER_ID = "select (p.name, p.price, c.count) from carts c join products p on p.id = c.product_id where c.user_id=? and c.favorite=true";
    public static final String DELETE_FAVORITE_PRODUCT = "delete from carts where user_id=? and product_id=? and favorite=true";
    public static final String DELETE_CART_PRODUCT = "delete from carts where user_id=? and product_id=? and favorite=true";
    public static final String GET_CURRENT_PRODUCT_COUNT = "select count from carts where user_id=? and product_id=? and cart=true";
    public static final String UPDATE_CURRENT_PRODUCT_COUNT = "update carts set count=? where user_id=? and product_id=? and cart=true";

    @Override
    public void addProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        if (favorite) {
            if (checkFavoritesProduct(userId, productId)) {
                addProductToCart(userId, productId, cart, true);
            }
        } else {
            addProductToCart(userId, productId, cart, false);
        }
    }

    @Override
    public void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        if (favorite) {
            try {
                PreparedStatement statement = connection.prepareStatement(DELETE_FAVORITE_PRODUCT);
                statement.setLong(1, userId);
                statement.setLong(2, productId);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("SQLException (deleteProductFavorite): " + e.getMessage());
            }
        } else {
            Integer productCount = getCartProductCount(userId, productId);
            if (productCount > 1) {
                try {
                    PreparedStatement statement = connection.prepareStatement(UPDATE_CURRENT_PRODUCT_COUNT);
                    statement.setInt(1, productCount - 1);
                    statement.setLong(1, userId);
                    statement.setLong(2, productId);

                } catch (SQLException e) {
                    System.out.println("SQLException (deleteProductCartCount): " + e.getMessage());
                    ;
                }
            } else {
                try {
                    PreparedStatement statement = connection.prepareStatement(DELETE_CART_PRODUCT);
                    statement.setLong(1, userId);
                    statement.setLong(2, productId);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("SQLException (deleteProductCart): " + e.getMessage());
                }
            }

        }

    }

    private void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT_TO_CART);
            statement.setLong(1, userId);
            statement.setLong(2, productId);
            statement.setBoolean(3, cart);
            statement.setBoolean(4, favorite);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException (addProductToCart): " + e.getMessage());
        }
    }

    @Override
    public List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite) {
        List<Pair<Product, Integer>> products = new ArrayList<>();
        String query = cart ? GET_CART_PRODUCTS_BY_USER_ID : GET_FAVORITE_PRODUCTS_BY_USER_ID;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                Integer count = resultSet.getInt("count");
                products.add(new ImmutablePair<>(new Product(name, price), count));
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getProductsFromCart): " + e.getMessage());
        }
        return products;
    }

    @Override
    public boolean checkFavoritesProduct(Long userId, Long productId) {
        return getProductsFromCart(userId, false, true).stream()
                .filter(product -> Objects.equals(product.getLeft().getId(), productId))
                .findAny()
                .isEmpty();
    }

    @Override
    public Integer getCartProductCount(Long userId, Long productId) {
        int count = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(GET_CURRENT_PRODUCT_COUNT);
            statement.setLong(1, userId);
            statement.setLong(2, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getCartProductCount): " + e.getMessage());
        }

        return count;
    }
}