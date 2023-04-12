package by.tms.service.impl;

import by.tms.model.Product;
import by.tms.repository.JdbcOrderRepository;
import by.tms.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Lazy
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

//    @Override
//    public List<Order> getOrdersById(Long id) {
//        return jdbcOrderRepository.getOrdersById(id);
//    }

    @Override
    public boolean checkOrderNumber(String number) {
        return jdbcOrderRepository.checkOrderNumber(number);
    }
}