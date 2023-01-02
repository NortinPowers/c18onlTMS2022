package by.tms.service;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.utils.CollectionUtils;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class ShopService implements ShopServiceAware {
    private final Shop shop;

    @Override
    public boolean addProduct(Product<Double> product) {
        List<Product<Double>> productList = shop.getProducts();
        boolean flag = false;
        for (Product<Double> value : productList) {
            if (value.equals(product)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return false;
        } else {
            return productList.add(product);
        }
    }

    @Override
    public ArrayList<Product<Double>> getAllProduct() {
        return shop.getProducts();
    }

    @Override
    public void deleteProduct(long id) {
        List<Product<Double>> productList = shop.getProducts();
        if (CollectionUtils.isNotEmpty(productList)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
                    productList.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public void changeProduct(long id, String productName, Double productPrice) {
        List<Product<Double>> productList = shop.getProducts();
        if (CollectionUtils.isNotEmpty(productList)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
                    Collections.replaceAll(productList, getAllProduct().get(i), new Product<>(id, productName, productPrice));
                    break;
                }
            }
        }
    }
}