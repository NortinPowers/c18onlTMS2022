package by.tms.service;

import by.tms.model.Product;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite);

    List<ImmutablePair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite);

    //
//    void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite);
//
    void deleteCartProductsAfterBuy(Long userId);

    //
    BigDecimal getProductsPrice(List<ImmutablePair<Product, Integer>> productWithCount);

    //
    List<Product> getPurchasedProducts(Long userId, boolean cart, boolean favorite);
}