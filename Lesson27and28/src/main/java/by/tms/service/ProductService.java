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
    private JdbcProductRepositoryAware jdbsProductRepository;

    @Override
    public List<Product> getProductsByType(String type) {
        return jdbsProductRepository.getProductsByType(type);
    }

    @Override
    public String getProductTypeValue(Long productId) {
        return jdbsProductRepository.getProductTypeValue(productId);
    }
}