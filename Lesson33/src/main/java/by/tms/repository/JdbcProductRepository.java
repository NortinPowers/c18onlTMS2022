package by.tms.repository;

import by.tms.model.Product;
import java.util.List;

public interface JdbcProductRepository {

    List<Product> getProducts();

    List<Product> getProductsByType(String type);

    String getProductTypeValue(Long productId);
}