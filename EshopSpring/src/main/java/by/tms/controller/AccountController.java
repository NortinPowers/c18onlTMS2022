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

import static by.tms.utils.Constants.Attributes.*;
import static by.tms.utils.Constants.MappingPath.ACCOUNT;
import static by.tms.utils.ControllerUtils.getOrders;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final OrderService orderService;

//    @GetMapping("/account")
//    public String account(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
//        request.getServletContext().setAttribute(USER_DTO, userDto);
//        List<OrderFullParamDto> orders = orderService.getOrdersById(getUserId(request));
//        if (!orders.isEmpty()) {
//            List<OrderWithListDto> userOrder = getOrders(orders);
//            request.getServletContext().setAttribute(USER_ORDER, userOrder);
//        } else {
//            request.removeAttribute(USER_ORDER);
//        }
//        return ACCOUNT;
//    }

    @GetMapping("/account")
    public ModelAndView account(HttpSession session) {
//    public String account(HttpSession session, Model model) {
//        HttpSession session = request.getSession(false);
        UserDto userDto = (UserDto) session.getAttribute(USER_ACCESS_PERMISSION);
//        model.addAttribute(USER_DTO, userDto);
//        request.getServletContext().setAttribute(USER_DTO, userDto);
        List<OrderFullParamDto> orders = orderService.getOrdersById(userDto.getId());
//        List<OrderFullParamDto> orders = orderService.getOrdersById(getUserId(request));
        Map<String, Object> models = new HashMap<>();
        models.put(USER_DTO, userDto);
        if (!orders.isEmpty()) {
//            List<OrderWithListDto> userOrder = getOrders(orders);
//            model.addAttribute(USER_ORDER, userOrder);
            models.put(USER_ORDER, getOrders(orders));
//            models.put(USER_ORDER, userOrder);
//            request.getServletContext().setAttribute(USER_ORDER, userOrder);
        }
//        else {
//            model.addAttribute(USER_ORDER, null);
////            request.removeAttribute(USER_ORDER);
//        }
        return new ModelAndView(ACCOUNT, "models", models);
//        return ACCOUNT;
    }
}