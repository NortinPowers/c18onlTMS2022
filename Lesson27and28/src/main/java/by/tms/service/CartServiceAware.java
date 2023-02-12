package by.tms.service;

import by.tms.model.Product;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;

public interface CartServiceAware {
    void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite);

    List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite);

    void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite);

    boolean checkProduct(Long userId, Long productId, boolean cart, boolean favorite);

    Integer getCartProductCount(Long userId, Long productId);

    void deleteCartProductsAfterBuy(Long userId);

    BigDecimal getProductsPrice(List<Pair<Product, Integer>> productWithCount);
}