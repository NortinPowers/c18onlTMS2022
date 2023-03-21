package by.tms.repository;

import by.tms.model.Product;
import java.util.List;

public interface JdbcProductRepository extends BaseRepository {

    List<Product> getProducts();

    List<Product> getProductsByType(String type);

    String getProductTypeValue(Long productId);
}