package by.tms.service;

import by.tms.model.Product;
import by.tms.repository.JdbsProductRepositoryAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@ToString
public class ProductService implements ProductServiceAware {
    private JdbsProductRepositoryAware jdbsProductRepository;
    private List<Product> cartProducts;
    private Set<Product> favoriteProducts;

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
        addProduct(id, cartProducts);
    }

    @Override
    public void addFavoriteProduct(Long id) {
        addProduct(id, favoriteProducts);
    }

    private void addProduct(Long id, Collection<Product> products) {
        products.add(getProducts().stream()
                .filter(product -> Objects.equals(product.getId(), id))
                .findFirst()
                .get());
    }

    @Override
    public void deleteCartProduct(Long id) {
        deleteProduct(id, cartProducts);
    }

    @Override
    public void deleteFavoriteProduct(Long id) {
        deleteProduct(id, favoriteProducts);
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
        cartProducts.clear();
    }

    @Override
    public void clearFavoriteProducts() {
        favoriteProducts.clear();
    }
}