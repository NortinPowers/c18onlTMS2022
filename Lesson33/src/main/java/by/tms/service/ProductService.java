package by.tms.service;

import by.tms.model.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> getProductsByType(String type);

    String getProductTypeValue(Long productId);

    Set<Product> getFoundProducts(String searchCondition);

    void saveFoundedProducts(Set<Product> products, String userUUID);

    Set<Product> getProductsByUserSearchCondition(String userUUID);

    void deleteFoundProducts(String userUUID);

    Product getOneProduct(Long id);

    Set<Product> selectFoundedProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice, String userUUID);

    Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}
