package by.tms.service.impl;

import by.tms.model.Inject;
import by.tms.model.Order;
import by.tms.model.Product;
import by.tms.repository.JdbcOrderRepository;
import by.tms.service.OrderService;
import java.util.List;
import lombok.Setter;

@Setter
public class OrderServiceImpl implements OrderService {

    @Inject
    private JdbcOrderRepository jdbcOrderRepository;

    @Override
    public void createOrder(String order, Long id) {
        jdbcOrderRepository.createOrder(order, id);
    }

    @Override
    public void saveProductInOrderConfigurations(String order, Product product) {
        jdbcOrderRepository.saveProductInOrderConfigurations(order, product);
    }

    @Override
    public List<Order> getOrdersById(Long id) {
        return jdbcOrderRepository.getOrdersById(id);
    }
}