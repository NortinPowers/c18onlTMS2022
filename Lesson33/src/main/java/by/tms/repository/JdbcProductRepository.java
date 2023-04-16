package by.tms.repository;

import by.tms.model.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface JdbcProductRepository extends BaseRepository {

    List<Product> getProducts();

    List<Product> getProductsByType(String type);

    String getProductTypeValue(Long productId);

    Set<Product> getFoundProducts(String searchCondition);

    Product getOneProduct(Long id);

    Set<Product> selectAllProductsByFilter(String type, BigDecimal minPrice, BigDecimal maxPrice);
}