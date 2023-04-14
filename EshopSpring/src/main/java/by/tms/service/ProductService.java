package by.tms.service;

import by.tms.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {

    List<ProductDto> getProductsByType(String type);

    ProductDto getProduct(Long id);

    String getProductTypeValue(Long productId);

    Set<ProductDto> getFoundProducts(String searchCondition);
//
//    Product getOneProduct(Long id);

    Set<ProductDto> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}
