package by.tms.repository;

import by.tms.dto.ProductDto;
import java.util.List;

public interface JdbcProductRepository extends BaseRepository {

//    List<Product> getProducts();

    List<ProductDto> getProductsByType(String type);
//
//    String getProductTypeValue(Long productId);
//
//    Set<Product> getFoundProducts(String searchCondition);
//
//    Product getOneProduct(Long id);
//
//    Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}