package by.tms.eshop.service;

import by.tms.eshop.dto.OrderFullParamDto;
import by.tms.eshop.model.Product;

import java.util.List;

public interface OrderService {

    void createOrder(String order, Long id);

    void saveProductInOrderConfigurations(String order, Product product);

    List<OrderFullParamDto> getOrdersById(Long id);

    boolean checkOrderNumber(String number);
}