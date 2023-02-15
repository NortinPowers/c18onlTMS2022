package by.tms.service;

import by.tms.model.Product;
import by.tms.repository.JdbsProductRepositoryAware;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString

public class ProductService implements ProductServiceAware {
    private JdbsProductRepositoryAware jdbsProductRepository;

    @Override
    public List<Product> getProductsByType(String type) {
        return jdbsProductRepository.getProductsByType(type);
    }

    @Override
    public String getProductTypeValue(Long productId) {
        return jdbsProductRepository.getProductTypeValue(productId);
    }
}