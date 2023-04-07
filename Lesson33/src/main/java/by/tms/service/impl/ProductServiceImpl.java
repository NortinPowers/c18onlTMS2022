package by.tms.service.impl;

import by.tms.model.Inject;
import by.tms.model.Product;
import by.tms.repository.JdbcProductRepository;
import by.tms.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import lombok.Setter;

@Setter
public class ProductServiceImpl implements ProductService {

    @Inject
    private JdbcProductRepository jdbcProductRepository;

    @Override
    public List<Product> getProductsByType(String type) {
        return jdbcProductRepository.getProductsByType(type);
    }

    @Override
    public String getProductTypeValue(Long productId) {
        return jdbcProductRepository.getProductTypeValue(productId);
    }

    @Override
    public Set<Product> getFoundProducts(String searchCondition) {
        return jdbcProductRepository.getFoundProducts(searchCondition);
    }

    @Override
    public Product getOneProduct(Long id) {
        return jdbcProductRepository.getOneProduct(id);
    }

    @Override
    public Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice) {
        return jdbcProductRepository.selectAllProductsByFilter(type, minPrice, maxPrice);
    }
}