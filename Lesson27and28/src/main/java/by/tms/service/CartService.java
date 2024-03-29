package by.tms.service;

import by.tms.model.Product;
import by.tms.repository.JdbcCartRepositoryAware;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

@AllArgsConstructor
public class CartService implements CartServiceAware {

    private JdbcCartRepositoryAware jdbcCartRepository;

    @Override
    public void addProductToCart(Long userId, Long productId, boolean cart, boolean favorite) {
        jdbcCartRepository.addProduct(userId, productId, cart, favorite);
    }

    @Override
    public List<Pair<Product, Integer>> getProductsFromCart(Long userId, boolean cart, boolean favorite) {
        return jdbcCartRepository.getProductsFromCart(userId, cart, favorite);
    }

    @Override
    public void deleteProduct(Long userId, Long productId, boolean cart, boolean favorite) {
        jdbcCartRepository.deleteProduct(userId, productId, cart, favorite);
    }

    @Override
    public void deleteCartProductsAfterBuy(Long userId) {
        jdbcCartRepository.deleteCartProductsAfterBuy(userId);
    }

    @Override
    public BigDecimal getProductsPrice(List<Pair<Product, Integer>> productWithCount) {
        BigDecimal fullPrice = BigDecimal.ZERO;
        for (Pair<Product, Integer> product : productWithCount) {
            BigDecimal totalPrice = product.getLeft().getPrice().multiply(new BigDecimal(product.getRight()));
            fullPrice = fullPrice.add(totalPrice);
        }
        return fullPrice;
    }
}