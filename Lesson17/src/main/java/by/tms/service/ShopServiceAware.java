package by.tms.service;

import by.tms.model.Product;

import java.util.ArrayList;

public interface ShopServiceAware {
    boolean addProduct(Product<Double> product);

    ArrayList<Product<Double>> getAllProduct();

    void deleteProduct(long id);

    void changeProduct(long id, String productName, Double productPrice);
}