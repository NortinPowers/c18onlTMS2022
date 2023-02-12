package by.tms.repository;

import by.tms.model.Product;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface JdbsCartRepositoryAware {
    void addProduct(Long userId, Long productId, boolean cart, boolean favorite);

    void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite);

    List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite);

    boolean checkFavoritesProduct(Long userId, Long productId);

    Integer getCartProductCount(Long userId, Long productId);
}
