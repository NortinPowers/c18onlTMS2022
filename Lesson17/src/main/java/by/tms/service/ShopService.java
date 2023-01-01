package by.tms.service;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.utils.CollectionUtils;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class ShopService {
    private final Shop shop;

    public boolean addProduct(Product product) {
        List<Product> productList = shop.getProducts();
        boolean flag = false;
        for (Product value : productList) {
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

    public ArrayList<Product> getAllProduct() {
        return shop.getProducts();
    }

    public void deleteProduct(long id) {
        List<Product> productList = shop.getProducts();
        if (CollectionUtils.isNotEmpty(productList)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
                    productList.remove(i);
                    break;
                }
            }
        }
    }

    public void changeProduct(long id, String productName, Double productPrice) {
        List<Product> productList = shop.getProducts();
        if (CollectionUtils.isNotEmpty(productList)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
                    Collections.replaceAll(productList, getAllProduct().get(i), new Product(id, productName, productPrice));
                    break;
                }
            }
        }
    }
}