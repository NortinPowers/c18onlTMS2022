package by.tms.service;

import by.tms.dto.OrderFullParamDto;
import by.tms.model.Product;

import java.util.List;

public interface OrderService {

    void createOrder(String order, Long id);

    void saveProductInOrderConfigurations(String order, Product product);

    List<OrderFullParamDto> getOrdersById(Long id);

    boolean checkOrderNumber(String number);
}