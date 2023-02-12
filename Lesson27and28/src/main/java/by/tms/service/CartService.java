package by.tms.service;

import by.tms.model.Product;
import by.tms.repository.JdbsCartRepositoryAware;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class CartService implements CartServiceAware {
    private JdbsCartRepositoryAware jdbsCartRepository;

    @Override
    public void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite) {
        jdbsCartRepository.addProduct(userId, productId, cart, favorite);
    }

    @Override
    public List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite) {
        return jdbsCartRepository.getProductsFromCart(userId, cart, favorite);
    }

    @Override
    public boolean checkFavoritesProduct(Long userId, Long productId) {
        return jdbsCartRepository.checkFavoritesProduct(userId, productId);
    }
}