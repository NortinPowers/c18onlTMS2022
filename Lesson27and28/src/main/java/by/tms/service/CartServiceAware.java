package by.tms.service;

import by.tms.model.Product;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface CartServiceAware {
    void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite);

    List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite);

    boolean checkFavoritesProduct(Long userId, Long productId);
}
