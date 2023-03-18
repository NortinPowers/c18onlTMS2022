package by.tms.utils;

import static by.tms.model.Commands.ACCOUNT_PAGE_COMMAND;
import static by.tms.model.Commands.ADD_CART_PAGE_COMMAND;
import static by.tms.model.Commands.ADD_FAVORITE_PAGE_COMMAND;
import static by.tms.model.Commands.CREATE_USER_PAGE_COMMAND;
import static by.tms.model.Commands.DELETE_CART_PRODUCT_PAGE_COMMAND;
import static by.tms.model.Commands.DELETE_FAVORITE_PRODUCT_PAGE_COMMAND;
import static by.tms.model.Commands.FAVORITES_PAGE_COMMAND;
import static by.tms.model.Commands.HOME_PAGE_COMMAND;
import static by.tms.model.Commands.LOGIN_PAGE_COMMAND;
import static by.tms.model.Commands.LOGOUT_PAGE_COMMAND;
import static by.tms.model.Commands.PRODUCTS_PAGE_COMMAND;
import static by.tms.model.Commands.SHOPPING_CART_PAGE_COMMAND;
import static by.tms.model.RequestParameters.COMMAND;

import by.tms.controller.Command;
import by.tms.controller.impl.AccountPageCommandImpl;
import by.tms.controller.impl.AddCartPageCommandImpl;
import by.tms.controller.impl.AddFavoritePageCommandImpl;
import by.tms.controller.impl.CreateUserPageCommandImpl;
import by.tms.controller.impl.DeleteCartProductPageCommandImpl;
import by.tms.controller.impl.DeleteFavoriteCommandImpl;
import by.tms.controller.impl.FavoritesCommandImpl;
import by.tms.controller.impl.HomePageCommandImpl;
import by.tms.controller.impl.LoginPageCommandImpl;
import by.tms.controller.impl.LogoutPageCommandImpl;
import by.tms.controller.impl.ProductPageCommandImpl;
import by.tms.controller.impl.ShoppingCartPageImpl;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommandFactory {

    public static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {
        COMMAND_MAP.put(HOME_PAGE_COMMAND.getCommand(), new HomePageCommandImpl());
        COMMAND_MAP.put(PRODUCTS_PAGE_COMMAND.getCommand(), new ProductPageCommandImpl());
        COMMAND_MAP.put(ACCOUNT_PAGE_COMMAND.getCommand(), new AccountPageCommandImpl());
        COMMAND_MAP.put(ADD_CART_PAGE_COMMAND.getCommand(), new AddCartPageCommandImpl());
        COMMAND_MAP.put(ADD_FAVORITE_PAGE_COMMAND.getCommand(), new AddFavoritePageCommandImpl());
        COMMAND_MAP.put(CREATE_USER_PAGE_COMMAND.getCommand(), new CreateUserPageCommandImpl());
        COMMAND_MAP.put(DELETE_CART_PRODUCT_PAGE_COMMAND.getCommand(), new DeleteCartProductPageCommandImpl());
        COMMAND_MAP.put(DELETE_FAVORITE_PRODUCT_PAGE_COMMAND.getCommand(), new DeleteFavoriteCommandImpl());
        COMMAND_MAP.put(FAVORITES_PAGE_COMMAND.getCommand(), new FavoritesCommandImpl());
        COMMAND_MAP.put(LOGIN_PAGE_COMMAND.getCommand(), new LoginPageCommandImpl());
        COMMAND_MAP.put(LOGOUT_PAGE_COMMAND.getCommand(), new LogoutPageCommandImpl());
        COMMAND_MAP.put(SHOPPING_CART_PAGE_COMMAND.getCommand(), new ShoppingCartPageImpl());
    }

    public static Command defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = HOME_PAGE_COMMAND.getCommand();
        }
        return COMMAND_MAP.get(commandKey);
    }
}