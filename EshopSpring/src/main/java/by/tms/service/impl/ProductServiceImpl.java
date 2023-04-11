package by.tms.service.impl;


import by.tms.dto.ProductDto;
import by.tms.repository.JdbcProductRepository;
import by.tms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final JdbcProductRepository jdbcProductRepository;

//    @Autowired
//    public ProductServiceImpl(JdbcProductRepository jdbcProductRepository) {
//        this.jdbcProductRepository = jdbcProductRepository;
//    }

    @Override
    public List<ProductDto> getProductsByType(String type) {
        return jdbcProductRepository.getProductsByType(type);
    }

    @Override
    public ProductDto getProduct(Long id) {
        return jdbcProductRepository.getProduct(id);
    }

//    public List<ProductDto> getProductsByType(String type) {
//        return List.of(ProductDto.builder()
//                                 .id(1L)
//                                 .name("Test")
//                                 .type("tv")
//                                 .info("some info text")
//                                 .price(new BigDecimal("800"))
//                                 .build());
//    }

//    @Override
//    public ProductDto getProduct(Long id) {
//        return ProductDto.builder()
//                         .id(1L)
//                         .name("Test")
//                         .type("tv")
//                         .info("some info text")
//                         .price(new BigDecimal("800"))
//                         .build();
//    }

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