package by.tms.service;

import by.tms.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductServiceAware {
    List<Product> getProducts();

    List<Product> getProductsByType(String type);

    List<Product> getCartProducts();

    Set<Product> getFavoriteProducts();

    void addCartProduct(Long id);

    void addFavoriteProduct(Long id);

    void deleteCartProduct(Long id);

    void deleteFavoriteProduct(Long id);

    BigDecimal getProductsPrice(List<Product> products);

    void clearProductsCart();

    void clearFavoriteProducts();

    String getProductTypeValue(Long productId);
}