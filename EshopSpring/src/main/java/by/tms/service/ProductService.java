package by.tms.service;

import by.tms.dto.ProductDto;
import java.util.List;

public interface ProductService {

    List<ProductDto> getProductsByType(String type);

    ProductDto getProduct(Long id);

//    String getProductTypeValue(Long productId);
//
//    Set<Product> getFoundProducts(String searchCondition);
//
//    Product getOneProduct(Long id);
//
//    Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}
