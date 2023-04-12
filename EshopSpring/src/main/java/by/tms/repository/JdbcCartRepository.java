package by.tms.repository;

import by.tms.model.Product;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;

public interface JdbcCartRepository extends BaseRepository {

    void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite);

//    void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite);

    List<ImmutablePair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite);

    boolean checkProduct(Long userId, Long productId, boolean cart, boolean favorite);

    Integer getCartProductCount(Long userId, Long productId);

    void deleteCartProductsAfterBuy(Long userId);

    List<Product> getPurchasedProducts(Long userId, boolean cart, boolean favorite);
}