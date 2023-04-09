package by.tms.service.impl;


import by.tms.dto.ProductDto;
import by.tms.repository.JdbcProductRepository;
import by.tms.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JdbcProductRepository jdbcProductRepository;


    //Статическая инициализация pool-?????
    @Override
//    public List<ProductDto> getProductsByType(String type) {
//        return jdbcProductRepository.getProductsByType(type);
//    }
    public List<ProductDto> getProductsByType(String type) {
        return List.of(ProductDto.builder().name("Test").build());
    }

//    @Override
//    public String getProductTypeValue(Long productId) {
//        return jdbcProductRepository.getProductTypeValue(productId);
//    }
//
//    @Override
//    public Set<Product> getFoundProducts(String searchCondition) {
//        return jdbcProductRepository.getFoundProducts(searchCondition);
//    }
//
//    @Override
//    public Product getOneProduct(Long id) {
//        return jdbcProductRepository.getOneProduct(id);
//    }
//
//    @Override
//    public Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice) {
//        return jdbcProductRepository.selectAllProductsByFilter(type, minPrice, maxPrice);
//    }
}