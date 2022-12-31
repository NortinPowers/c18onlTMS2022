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
        if (CollectionUtils.isNotEmpty(productList)) {
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
        } else {
            List<Product> products = new ArrayList<>();
            Shop shop = new Shop((ArrayList) products);
            return shop.getProducts().add(product);
        }
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> productList = shop.getProducts();
        if (CollectionUtils.isNotEmpty(productList)) {
            return productList;
        } else
            return null;
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

    public void changeProduct(long id, Product product) {
        List<Product> productList = shop.getProducts();
        if (CollectionUtils.isNotEmpty(productList)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == id) {
                    Collections.replaceAll(productList, getAllProduct().get(i), product);
                    break;
                }
            }
        }
    }
}