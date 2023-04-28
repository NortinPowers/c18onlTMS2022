package by.tms.eshop.controller;

import by.tms.eshop.dto.OrderFullParamDto;
import by.tms.eshop.dto.UserDto;
import by.tms.eshop.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.tms.eshop.utils.Constants.Attributes.*;
import static by.tms.eshop.utils.Constants.MappingPath.ACCOUNT;
import static by.tms.eshop.utils.ControllerUtils.getOrders;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final OrderService orderService;

    @GetMapping("/account")
    public ModelAndView showAccountPage(HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
        List<OrderFullParamDto> orders = orderService.getOrdersById(userDto.getId());
        Map<String, Object> models = new HashMap<>();
        models.put(USER_DTO, userDto);
        if (!orders.isEmpty()) {
            models.put(USER_ORDER, getOrders(orders));
        }
        return new ModelAndView(ACCOUNT, "models", models);
    }
}