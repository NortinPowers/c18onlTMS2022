package by.tms.utils;

import by.tms.model.Inject;
import by.tms.repository.JdbcCartRepository;
import by.tms.repository.JdbcOrderRepository;
import by.tms.repository.JdbcProductRepository;
import by.tms.repository.JdbcUserRepository;
import by.tms.repository.impl.JdbcCartRepositoryImpl;
import by.tms.repository.impl.JdbcOrderRepositoryImpl;
import by.tms.repository.impl.JdbcProductRepositoryImpl;
import by.tms.repository.impl.JdbcUserRepositoryImpl;
import by.tms.service.CartService;
import by.tms.service.OrderService;
import by.tms.service.ProductService;
import by.tms.service.UserService;
import by.tms.service.ValidateService;
import by.tms.service.impl.CartServiceImpl;
import by.tms.service.impl.OrderServiceImpl;
import by.tms.service.impl.ProductServiceImpl;
import by.tms.service.impl.UserServiceImpl;
import by.tms.service.impl.ValidateServiceImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InjectObjectsFactory {

    private static final Map<Class<?>, Object> CLASS_OBJECT_MAP = new ConcurrentHashMap<>();

    public static void createAndInjectInstances(Object controller) throws Exception {
        for (Field field : controller.getClass().getDeclaredFields()) {
            Inject fieldInject = field.getAnnotation(Inject.class);
            if (fieldInject != null) {
                Object service = putInstanceToMapIfAbsent(field.getType());
                Method injectMethod = getInjectMethod(controller, field.getType());
                injectMethod.invoke(controller, service);
                createAndInjectInstances(service);
            }
        }
    }

    private static Method getInjectMethod(Object controller, Class<?> type) {
        for (Method declaredMethod : controller.getClass().getDeclaredMethods()) {
            boolean allMatch = Arrays.stream(declaredMethod.getParameterTypes())
                                     .allMatch(methodParameterTypeClass -> methodParameterTypeClass == type
                                             && declaredMethod.getReturnType() == Void.TYPE
                                             && declaredMethod.getName().startsWith("set"));
            if (allMatch) {
                return declaredMethod;
            }
        }
        throw new IllegalArgumentException("Can not find method with param " + type);
    }

    private static <T> Object putInstanceToMapIfAbsent(Class<T> serviceClass) {
        Object value = CLASS_OBJECT_MAP.get(serviceClass);
        if (value == null) {
            value = createInstance(serviceClass);
            CLASS_OBJECT_MAP.put(serviceClass, value);
        }
        return value;
    }

    private static <T> Object createInstance(Class<T> serviceClass) {
        if (CartService.class == serviceClass) {
            return new CartServiceImpl();
        } else if (JdbcCartRepository.class == serviceClass) {
            return new JdbcCartRepositoryImpl();
        } else if (OrderService.class == serviceClass) {
            return new OrderServiceImpl();
        } else if (JdbcOrderRepository.class == serviceClass) {
            return new JdbcOrderRepositoryImpl();
        } else if (ProductService.class == serviceClass) {
            return new ProductServiceImpl();
        } else if (JdbcProductRepository.class == serviceClass) {
            return new JdbcProductRepositoryImpl();
        } else if (UserService.class == serviceClass) {
            return new UserServiceImpl();
        } else if (JdbcUserRepository.class == serviceClass) {
            return new JdbcUserRepositoryImpl();
        } else if (ValidateService.class == serviceClass) {
            return new ValidateServiceImpl();
        }
        throw new IllegalArgumentException("Can not create instance of class " + serviceClass);
    }
}