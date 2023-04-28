package by.tms.eshop.repository.impl;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.mapper.CartCountMapper;
import by.tms.eshop.model.Cart;
import by.tms.eshop.repository.JdbcCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static by.tms.eshop.utils.RepositoryJdbcUtils.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcCartRepositoryImpl implements JdbcCartRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String ADD_PRODUCT_TO_CART = "insert into carts (user_id, product_id, cart, favorite) VALUES (?, ?, ?, ?)";
    private static final String GET_CART_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, pt.type, p.info, c.count from carts c join products p on p.id = c.product_id join product_type pt on pt.id = p.product_type_id where c.user_id=? and c.cart=true";
    private static final String GET_FAVORITE_PRODUCTS_BY_USER_ID = "select p.id, p.name, p.price, pt.type, p.info, c.count from carts c join products p on p.id = c.product_id join product_type pt on pt.id = p.product_type_id where c.user_id=? and c.favorite=true";
    private static final String DELETE_FAVORITE_PRODUCT = "delete from carts where user_id=? and product_id=? and favorite=true";
    private static final String DELETE_CART_PRODUCT = "delete from carts where user_id=? and product_id=? and cart=true";
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

    @Override
    public void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        if (favorite) {
            deleteProductByMark(userId, productId, DELETE_FAVORITE_PRODUCT);
        } else {
            Integer productCount = getCartProductCount(userId, productId);
            if (productCount > 1) {
                modifyProductCount(userId, productId, false);
            } else {
                deleteProductByMark(userId, productId, DELETE_CART_PRODUCT);
            }
        }
    }

    @Override
    public List<ImmutablePair<ProductDto, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite) {
        String query = cart ? GET_CART_PRODUCTS_BY_USER_ID : GET_FAVORITE_PRODUCTS_BY_USER_ID;
        return jdbcTemplate.query(query, (rs, i) -> new ImmutablePair<>(getProductDto(rs), rs.getInt("count")), userId);
    }

    @Override
    public boolean checkProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        List<ProductDto> productsDto = getProducts(userId, cart, favorite);
        return isProductNotIncluded(productId, productsDto);
    }

    @Override
    public Integer getCartProductCount(Long userId, Long productId) {
        return jdbcTemplate.query(GET_CURRENT_PRODUCT_COUNT, new CartCountMapper(),
                        userId, productId).stream()
                .findAny()
                .map(Cart::getCount)
                .orElse(0);
    }

    @Override
    public void deleteCartProductsAfterBuy(Long userId) {
        jdbcTemplate.update(DELETE_CART_PRODUCT_AFTER_BUY, userId);
    }

    @Override
    public List<ProductDto> getPurchasedProducts(Long userId, boolean cart, boolean favorite) {
        List<ProductDto> products = new ArrayList<>();
        List<ImmutablePair<ProductDto, Integer>> productWithCount = getProductsFromCart(userId, cart, favorite);
        for (Pair<ProductDto, Integer> productIntegerPair : productWithCount) {
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
    }

    private void modifyProductCount(Long userId, Long productId, boolean up) {
        Integer productCount = getCartProductCount(userId, productId);
        productCount = getModifyCount(up, productCount);
        jdbcTemplate.update(UPDATE_CURRENT_PRODUCT_COUNT, productCount, userId, productId);
    }

    private List<ProductDto> getProducts(Long userId, boolean cart, boolean favorite) {
        return getProductsFromCart(userId, cart, favorite).stream()
                .map(Pair::getLeft)
                .collect(Collectors.toList());
    }

    private void deleteProductByMark(Long userId, Long productId, String query) {
        jdbcTemplate.update(query, userId, productId);
    }
}