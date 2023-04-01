package by.tms.service;

import by.tms.model.Order;
import by.tms.model.Product;
import java.util.List;

public interface OrderService {

    void createOrder(String order, Long id);

    void saveProductInOrderConfigurations(String order, Product product);

    List<Order> getOrdersById(Long id);

    boolean checkOrderNumber(String number);
}