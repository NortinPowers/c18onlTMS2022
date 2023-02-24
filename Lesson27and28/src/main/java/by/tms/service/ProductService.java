package by.tms.service;

import by.tms.model.Product;
import by.tms.repository.JdbcProductRepositoryAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString

public class ProductService implements ProductServiceAware {

    private JdbcProductRepositoryAware jdbcProductRepository;

    @Override
    public List<Product> getProductsByType(String type) {
        return jdbcProductRepository.getProductsByType(type);
    }

    @Override
    public String getProductTypeValue(Long productId) {
        return jdbcProductRepository.getProductTypeValue(productId);
    }
}