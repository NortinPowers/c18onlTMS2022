package by.tms.utils;

import by.tms.repository.impl.JdbcCartRepositoryImpl;
import by.tms.repository.impl.JdbcOrderRepositoryImpl;
import by.tms.repository.impl.JdbcProductRepositoryImpl;
import by.tms.repository.impl.JdbcUserRepositoryImpl;
import by.tms.service.impl.CartServiceImpl;
import by.tms.service.impl.OrderServiceImpl;
import by.tms.service.impl.ProductServiceImpl;
import by.tms.service.impl.UserServiceImpl;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceUtils {

    public static ProductServiceImpl getProductService() {
        return new ProductServiceImpl(new JdbcProductRepositoryImpl());
    }

    public static UserServiceImpl getUserService() {
        return new UserServiceImpl(new JdbcUserRepositoryImpl());
    }

    public static OrderServiceImpl getOrderService() {
        return new OrderServiceImpl(new JdbcOrderRepositoryImpl());
    }

    public static CartServiceImpl getCartService() {
        return new CartServiceImpl(new JdbcCartRepositoryImpl());
    }
}