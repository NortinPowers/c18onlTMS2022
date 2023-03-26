package by.tms.service.impl;

import by.tms.model.Inject;
import by.tms.model.Product;
import by.tms.repository.JdbcProductRepository;
import by.tms.service.ProductService;
import java.util.List;
import java.util.Set;
import lombok.Setter;

//@AllArgsConstructor
//@Getter
//@ToString
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
    public void saveFoundedProducts(Set<Product> products, String userUUID) {
        jdbcProductRepository.saveFoundedProducts(products, userUUID);
    }

    @Override
    public Set<Product> getProductsByUserSearchCondition(String userUUID) {
        return jdbcProductRepository.getProductsByUserSearchCondition(userUUID);
    }

    @Override
    public void deleteFoundProducts(String userUUID) {
        jdbcProductRepository.deleteFoundProducts(userUUID);
    }
}