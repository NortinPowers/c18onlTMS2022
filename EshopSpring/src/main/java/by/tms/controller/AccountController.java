package by.tms.controller;

import by.tms.dto.OrderFullParamDto;
import by.tms.dto.UserDto;
import by.tms.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.tms.utils.Constants.Attributes.USER_ACCESS_PERMISSION;
import static by.tms.utils.Constants.Attributes.USER_DTO;
import static by.tms.utils.Constants.Attributes.USER_ORDER;
import static by.tms.utils.Constants.MappingPath.ACCOUNT;
import static by.tms.utils.ControllerUtils.getOrders;

@Controller
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