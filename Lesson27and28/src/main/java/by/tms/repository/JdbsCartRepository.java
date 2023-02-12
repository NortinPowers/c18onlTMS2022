package by.tms.repository;

import by.tms.model.Product;
import by.tms.model.ProductType;
import lombok.AllArgsConstructor;
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

import static by.tms.model.ProductType.getProductType;

@AllArgsConstructor
public class JdbsCartRepository implements JdbsCartRepositoryAware {
    private Connection connection;
    private static final String ADD_PRODUCT_TO_CART = "insert into carts (user_id, product_id, cart, favorite) VALUES (?, ?, ?, ?)";
    private static final String GET_CART_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, p.type, p.info, c.count from carts c join products p on p.id = c.product_id where c.user_id=? and c.cart=true";
    private static final String GET_FAVORITE_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, p.type, p.info, c.count from carts c join products p on p.id = c.product_id where c.user_id=? and c.favorite=true";
    private static final String DELETE_FAVORITE_PRODUCT = "delete from carts where user_id=? and product_id=? and favorite=true";
    private static final String DELETE_CART_PRODUCT = "delete from carts where user_id=? and product_id=? and cart=true";
    private static final String GET_CURRENT_PRODUCT_COUNT = "select count from carts where user_id=? and product_id=? and cart=true";
    private static final String UPDATE_CURRENT_PRODUCT_COUNT = "update carts set count=? where user_id=? and product_id=? and cart=true";
    private static final String DELETE_CART_PRODUCT_AFTER_BUY = "delete from carts where user_id=? and cart=true";


    @Override
    public void addProduct(Long userId, Long productId, boolean cart, boolean favorite) {

//        card не нужен?

        if (favorite) {
            if (checkProduct(userId, productId, false, true)) {
                addProductToCart(userId, productId, cart, true);
            }
        } else {
            if (checkProduct(userId, productId, true, false)) {
                addProductToCart(userId, productId, cart, false);
            } else {
                Integer productCount = getCartProductCount(userId, productId);
                try {
                    PreparedStatement statement = connection.prepareStatement(UPDATE_CURRENT_PRODUCT_COUNT);
                    statement.setInt(1, productCount + 1);
                    statement.setLong(2, userId);
                    statement.setLong(3, productId);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("SQLException (deleteProductCartCount): " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        if (favorite) {
            try {
                PreparedStatement statement = connection.prepareStatement(DELETE_FAVORITE_PRODUCT);
                statement.setLong(1, userId);
                statement.setLong(2, productId);
                statement.execute();
            } catch (SQLException e) {
                System.out.println("SQLException (deleteProductFavorite): " + e.getMessage());
            }
        } else {
            Integer productCount = getCartProductCount(userId, productId);
            if (productCount > 1) {
                try {
                    PreparedStatement statement = connection.prepareStatement(UPDATE_CURRENT_PRODUCT_COUNT);
                    statement.setInt(1, productCount - 1);
                    statement.setLong(2, userId);
                    statement.setLong(3, productId);
                    statement.execute();
                } catch (SQLException e) {
                    System.out.println("SQLException (deleteProductCartCount): " + e.getMessage());
                }
            } else {
                try {
                    PreparedStatement statement = connection.prepareStatement(DELETE_CART_PRODUCT);
                    statement.setLong(1, userId);
                    statement.setLong(2, productId);
                    statement.execute();
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
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String type = resultSet.getString("type");
                ProductType productType = getProductType(type);
                String info = resultSet.getString("info");
                Integer count = resultSet.getInt("count");
                products.add(new ImmutablePair<>(new Product(id, name, price, productType, info), count));
            }
        } catch (SQLException e) {
            System.out.println("SQLException (getProductsFromCart): " + e.getMessage());
        }
        return products;
    }

//    @Override
//    public boolean checkFavoritesProduct(Long userId, Long productId) {
//        return getProductsFromCart(userId, false, true).stream()
//                .filter(product -> Objects.equals(product.getLeft().getId(), productId))
//                .findAny()
//                .isEmpty();
//    }
//
//    @Override
//    public boolean checkCartProduct(Long userId, Long productId) {
//        return getProductsFromCart(userId, true, false).stream()
//                .filter(product -> Objects.equals(product.getLeft().getId(), productId))
//                .findAny()
//                .isEmpty();
//    }

    @Override
    public boolean checkProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        List<Product> products = getProductsFromCart(userId, cart, favorite).stream()
                .map(Pair::getLeft)
                .toList();
        return products.stream()
                .filter(product -> Objects.equals(product.getId(), productId))
                .findAny()
                .isEmpty();
//        return getProductsFromCart(userId, cart, favorite).stream()
//                .filter(product -> Objects.equals(product.getLeft().getId(), productId))
//                .findAny()
//                .isEmpty();
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

    @Override
    public void deleteCartProductsAfterBuy(Long userId) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CART_PRODUCT_AFTER_BUY);
            statement.setLong(1, userId);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("SQLException (deleteCartProductsAfterBuy): " + e.getMessage());
        }
    }

//    @Override
//    public String getProductTypeValue(Long productId) {
//        PreparedStatement statement = connection.prepareStatement()
//        return null;
//    }
}