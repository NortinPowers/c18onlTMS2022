package by.tms.eshop.repository;

import by.tms.eshop.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface JdbcProductRepository {

    List<ProductDto> getProductsByType(String type);

    String getProductTypeValue(Long id);

    Set<ProductDto> getFoundProducts(String searchCondition);

    ProductDto getProduct(Long id);

    Set<ProductDto> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}