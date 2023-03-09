package by.tms.service.impl;

import by.tms.model.Product;
import by.tms.repository.JdbcProductRepository;
import by.tms.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

public class ProductServiceImpl implements ProductService {

    private JdbcProductRepository jdbcProductRepository;

    @Override
    public List<Product> getProductsByType(String type) {
        return jdbcProductRepository.getProductsByType(type);
    }

    @Override
    public String getProductTypeValue(Long productId) {
        return jdbcProductRepository.getProductTypeValue(productId);
    }
}