package by.tms.service;

import by.tms.model.Product;

import java.util.List;

public interface ProductServiceAware {
    List<Product> getProductsByType(String type);

    String getProductTypeValue(Long productId);
}