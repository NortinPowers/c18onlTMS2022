package by.tms.eshop.service.impl;

import by.tms.eshop.dto.OrderFullParamDto;
import by.tms.eshop.model.Product;
import by.tms.eshop.repository.JdbcOrderRepository;
import by.tms.eshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final JdbcOrderRepository jdbcOrderRepository;

    @Override
    public void createOrder(String order, Long id) {
        jdbcOrderRepository.createOrder(order, id);
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        jdbcOrderRepository.saveProductInOrderConfigurations(order, product);
    }

    @Override
    public List<OrderFullParamDto> getOrdersById(Long id) {
        return jdbcOrderRepository.getOrdersById(id);
    }

    @Override
    public boolean checkOrderNumber(String number) {
        return jdbcOrderRepository.checkOrderNumber(number);
    }
}