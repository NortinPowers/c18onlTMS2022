package by.tms.service.impl;

import by.tms.model.Inject;
import by.tms.model.Product;
import by.tms.repository.JdbcProductRepository;
import by.tms.service.ProductService;
import java.util.List;
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
}