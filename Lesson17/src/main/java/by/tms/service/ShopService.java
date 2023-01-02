package by.tms.service;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.utils.CollectionUtils;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ShopService implements ShopServiceAware {
    private final Shop shop;

    @Override
    public boolean addProduct(Product<Double> product) {
        List<Product<Double>> productList = getAllProduct();
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
        return (ArrayList<Product<Double>>) shop.getProducts();
    }

    @Override
    public void deleteProduct(long id) {
        List<Product<Double>> productList = getAllProduct();
        productList.removeIf(product -> product.getId() == id);
    }

    @Override
    public void changeProduct(long id, String productName, Double productPrice) {
        List<Product<Double>> productList = getAllProduct();
        if (CollectionUtils.isNotEmpty(productList)) {
            for (Product<Double> product : productList) {
                if (product.getId() == id) {
                    product.setName(productName);
                    product.setPrice(productPrice);
                    break;
                }
            }
        }
    }
}