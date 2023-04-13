package by.tms.controller;

import by.tms.dto.OrderFullParamDto;
import by.tms.dto.OrderWithListDto;
import by.tms.dto.UserDto;
import by.tms.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static by.tms.utils.Constants.Attributes.*;
import static by.tms.utils.ControllerUtils.getOrders;
import static by.tms.utils.ControllerUtils.getUserId;

@Controller
@RequiredArgsConstructor
@Lazy
public class AccountController {

    private final OrderService orderService;

    @GetMapping("/account")
    public String account(HttpServletRequest request) {
//        String login = getLogin(request);
        HttpSession session = request.getSession(false);
        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
        request.getServletContext().setAttribute(USER_DTO, userDto);
//        Long userId = userService.getUserId(login);
        List<OrderFullParamDto> orders = orderService.getOrdersById(getUserId(request));
        if (!orders.isEmpty()) {
            List<OrderWithListDto> userOrder = getOrders(orders);
            request.getServletContext().setAttribute(USER_ORDER, userOrder);
        } else {
            request.removeAttribute(USER_ORDER);
        }
        return "account/account";
    }
}
