package by.tms.service;

import by.tms.model.Product;
import by.tms.repository.JdbsProductRepositoryAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@Getter

@ToString

public class ProductService implements ProductServiceAware {
    private JdbsProductRepositoryAware jdbsProductRepository;
    private List<Product> cartProducts;
    private Set<Product> favoriteProducts;

    public ProductService(JdbsProductRepositoryAware jdbsProductRepository) {
        this.jdbsProductRepository = jdbsProductRepository;
    }

    public List<Product> getCartProducts() {
        if (cartProducts == null) {
            cartProducts = new ArrayList<>();
        }
        return cartProducts;
//        return nonNull(cartProducts) ? cartProducts : new ArrayList<>();
    }

    public Set<Product> getFavoriteProducts() {
        if (favoriteProducts == null) {
            favoriteProducts = new HashSet<>();
        }
        return favoriteProducts;
//        return nonNull(favoriteProducts) ? favoriteProducts : new HashSet<>();
    }

    @Override
    public List<Product> getProducts() {
        return jdbsProductRepository.getProducts();
    }

    @Override
    public List<Product> getProductsByType(String type) {
        return jdbsProductRepository.getProductsByType(type);
    }

    @Override
    public void addCartProduct(Long id) {
        addProduct(id, getCartProducts());
    }

    @Override
    public void addFavoriteProduct(Long id) {
        addProduct(id, getFavoriteProducts());
    }

    private void addProduct(Long id, Collection<Product> products) {
        products.add(getProducts().stream()
                .filter(product -> Objects.equals(product.getId(), id))
                .findFirst()
                .get());
    }

    @Override
    public void deleteCartProduct(Long id) {
        deleteProduct(id, getCartProducts());
    }

    @Override
    public void deleteFavoriteProduct(Long id) {
        deleteProduct(id, getFavoriteProducts());
    }

    private void deleteProduct(Long id, Collection<Product> products) {
        products.remove(getProducts().stream()
                .filter(product -> Objects.equals(product.getId(), id))
                .findFirst()
                .get());
    }

    @Override
    public BigDecimal getProductsPrice(List<Product> products) {
        BigDecimal fullPrice = BigDecimal.ZERO;
        for (Product product : products) {
            fullPrice = fullPrice.add(product.getPrice());
        }
        return fullPrice;
    }

    @Override
    public void clearProductsCart() {
        getCartProducts().clear();
    }

    @Override
    public void clearFavoriteProducts() {
        getFavoriteProducts().clear();
    }
}