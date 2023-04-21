package by.tms.utils;

import by.tms.dto.OrderFullParamDto;
import by.tms.dto.OrderWithListDto;
import by.tms.dto.ProductDto;
import by.tms.dto.UserDto;
import by.tms.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static by.tms.utils.Constants.ALL;
import static by.tms.utils.Constants.Attributes.*;
import static by.tms.utils.Constants.CONVERSATION;
import static by.tms.utils.Constants.MappingPath.*;
import static by.tms.utils.Constants.RequestParameters.PRODUCT_PAGE;
import static by.tms.utils.Constants.RequestParameters.SEARCH;
import static java.util.UUID.randomUUID;

@Slf4j
@UtilityClass
public class ControllerUtils {


    public static boolean isVerifyUser(User user, String password) {
        return user.getPassword().equals(password);
    }

    public static void saveUserSession(HttpServletRequest req, UserDto userDto) {
        HttpSession session = req.getSession();
        session.setAttribute(USER_ACCESS_PERMISSION, userDto);
        log.info("The user with a login " + userDto.getLogin() + " is logged in");
        String userUUID = randomUUID().toString();
        MDC.put(CONVERSATION, userUUID);
        session.setAttribute(USER_UUID, userUUID);
        log.info("User with the login " + userDto.getLogin() + " has been assigned a UUID");
    }

    public static String getLogin(HttpServletRequest req) {
        if (req.getSession().getAttribute(USER_NAME) != null) {
            return req.getSession().getAttribute(USER_NAME).toString();
        } else {
            return null;
        }
    }

    public static List<OrderWithListDto> getOrders(List<OrderFullParamDto> orders) {
        List<OrderWithListDto> orderings = new ArrayList<>();
        OrderFullParamDto singleOrder = orders.get(0);
        List<ProductDto> singleOrderList = new ArrayList<>();
        addOrdering(orderings, singleOrder, singleOrderList);
        separateOrders(orders, orderings, singleOrder, singleOrderList);
        return orderings;
    }

    private void addOrdering(List<OrderWithListDto> order, OrderFullParamDto singleOrder, List<ProductDto> singleOrderList) {
        order.add(new OrderWithListDto(singleOrder.getId(), singleOrder.getDate(), singleOrderList));
        singleOrderList.add(singleOrder.getProductDto());
    }

    private void separateOrders(List<OrderFullParamDto> orders, List<OrderWithListDto> orderings, OrderFullParamDto singleOrder, List<ProductDto> singleOrderList) {
        for (int i = 1; i < orders.size(); i++) {
            OrderFullParamDto order = orders.get(i);
            if (singleOrder.getId().equals(order.getId())) {
                singleOrderList.add(order.getProductDto());
            } else {
                singleOrder = order;
                singleOrderList = new ArrayList<>();
                addOrdering(orderings, singleOrder, singleOrderList);
            }
        }
    }

    public static String createOrderNumber(Long id) {
        String uuid = randomUUID().toString();
        return "#" + id + "-" + uuid;
    }

//    public static Long getUserId(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        return ((UserDto) session.getAttribute(USER_ACCESS_PERMISSION)).getId();
//    }

    public static Long getUserId(HttpSession session) {
        return ((UserDto) session.getAttribute(USER_ACCESS_PERMISSION)).getId();
    }


    public static BigDecimal getPrice(HttpServletRequest request, String param, BigDecimal defaultValue) {
        String value = request.getParameter(param);
        return StringUtils.isNotBlank(value) ? new BigDecimal(value) : defaultValue;
    }

    public static Set<ProductDto> applyPriceFilterOnProducts(BigDecimal minPrice, BigDecimal maxPrice, Set<ProductDto> products) {
        products = products.stream()
                .filter(product -> product.getPrice().compareTo(minPrice) > 0 && product.getPrice().compareTo(maxPrice) < 0)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return products;
    }

    public static Set<ProductDto> applyTypeFilterOnProducts(String type, Set<ProductDto> products) {
        if (!ALL.equals(type)) {
            products = products.stream()
                    .filter(product -> product.getType().equals(type))
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        }
        return products;
    }

    public static String getPathFromAddFavoriteByParameters(Long productId, String location, String productType) {
        String path;
        if (Objects.equals(location, SEARCH)) {
            path = REDIRECT_TO_SEARCH_RESULT_SAVE;
        } else if (Objects.equals(location, PRODUCT_PAGE)) {
            path = REDIRECT_TO_PRODUCT_WITH_PARAM + productId;
        } else {
            path = REDIRECT_TO_PRODUCTS_PAGE_TYPE_WITH_PARAM + productType;
        }
        return path;
    }

    public static void fillError(String field, ModelAndView modelAndView, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors(field)) {
            modelAndView.addObject(field + "Error", Objects.requireNonNull(bindingResult.getFieldError(field))
                    .getDefaultMessage());
        }
    }
}