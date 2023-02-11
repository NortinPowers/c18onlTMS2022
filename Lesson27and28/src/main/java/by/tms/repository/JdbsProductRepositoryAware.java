package by.tms.repository;

import by.tms.model.Product;

import java.util.List;

public interface JdbsProductRepositoryAware {
    List<Product> getProducts();

    List<Product> getProductsByType(String type);
}