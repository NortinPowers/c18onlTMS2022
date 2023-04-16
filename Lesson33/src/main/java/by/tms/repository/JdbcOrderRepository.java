package by.tms.repository;

import by.tms.model.Order;
import by.tms.model.Product;
import java.util.List;

public interface JdbcOrderRepository extends BaseRepository {

    void createOrder(String order, Long id);

    void saveProductInOrderConfigurations(String order, Product product);

    List<Order> getOrdersById(Long id);

    boolean checkOrderNumber(String number);
}