package by.tms.utils;//package by.tms.utils;
//
//import static by.tms.model.Commands.ACCOUNT_PAGE_COMMAND;
//import static by.tms.model.Commands.ADD_CART_PAGE_COMMAND;
//import static by.tms.model.Commands.ADD_FAVORITE_PAGE_COMMAND;
//import static by.tms.model.Commands.CREATE_USER_PAGE_COMMAND;
//import static by.tms.model.Commands.DELETE_CART_PRODUCT_PAGE_COMMAND;
//import static by.tms.model.Commands.DELETE_FAVORITE_PRODUCT_PAGE_COMMAND;
//import static by.tms.model.Commands.FAVORITES_PAGE_COMMAND;
//import static by.tms.model.Commands.HOME_PAGE_COMMAND;
//import static by.tms.model.Commands.LOGIN_PAGE_COMMAND;
//import static by.tms.model.Commands.LOGOUT_PAGE_COMMAND;
//import static by.tms.model.Commands.PRODUCTS_PAGE_COMMAND;
//import static by.tms.model.Commands.SHOPPING_CART_PAGE_COMMAND;
//import static by.tms.model.RequestParameters.COMMAND;
//
//import by.tms.controller.CommandController;
//import by.tms.controller.impl.AccountPageCommandImplController;
//import by.tms.controller.impl.AddCartPageCommandImplController;
//import by.tms.controller.impl.AddFavoritePageCommandImplController;
//import by.tms.controller.impl.CreateUserPageCommandImplController;
//import by.tms.controller.impl.DeleteCartProductPageCommandImplController;
//import by.tms.controller.impl.DeleteFavoriteCommandImplController;
//import by.tms.controller.impl.FavoritesCommandImplController;
//import by.tms.controller.impl.HomePageCommandImplController;
//import by.tms.controller.impl.LoginPageCommandImplController;
//import by.tms.controller.impl.LogoutPageCommandImplController;
//import by.tms.controller.impl.ProductPageCommandImplController;
//import by.tms.controller.impl.ShoppingCartPageImpl;
//import java.util.HashMap;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import lombok.experimental.UtilityClass;
//
//@UtilityClass
//public class CommandFactory {
//
//    public static final Map<String, CommandController> COMMAND_MAP = new HashMap<>();
//
//    static {
//        COMMAND_MAP.put(HOME_PAGE_COMMAND.getCommand(), new HomePageCommandImplController());
//        COMMAND_MAP.put(PRODUCTS_PAGE_COMMAND.getCommand(), new ProductPageCommandImplController());
//        COMMAND_MAP.put(ACCOUNT_PAGE_COMMAND.getCommand(), new AccountPageCommandImplController());
//        COMMAND_MAP.put(ADD_CART_PAGE_COMMAND.getCommand(), new AddCartPageCommandImplController());
//        COMMAND_MAP.put(ADD_FAVORITE_PAGE_COMMAND.getCommand(), new AddFavoritePageCommandImplController());
//        COMMAND_MAP.put(CREATE_USER_PAGE_COMMAND.getCommand(), new CreateUserPageCommandImplController());
//        COMMAND_MAP.put(DELETE_CART_PRODUCT_PAGE_COMMAND.getCommand(), new DeleteCartProductPageCommandImplController());
//        COMMAND_MAP.put(DELETE_FAVORITE_PRODUCT_PAGE_COMMAND.getCommand(), new DeleteFavoriteCommandImplController());
//        COMMAND_MAP.put(FAVORITES_PAGE_COMMAND.getCommand(), new FavoritesCommandImplController());
//        COMMAND_MAP.put(LOGIN_PAGE_COMMAND.getCommand(), new LoginPageCommandImplController());
//        COMMAND_MAP.put(LOGOUT_PAGE_COMMAND.getCommand(), new LogoutPageCommandImplController());
//        COMMAND_MAP.put(SHOPPING_CART_PAGE_COMMAND.getCommand(), new ShoppingCartPageImpl());
//    }
//
//    public static CommandController defineCommand(HttpServletRequest request) {
//        String commandKey = request.getParameter(COMMAND.getValue());
//        if (commandKey == null || commandKey.isEmpty()) {
//            commandKey = HOME_PAGE_COMMAND.getCommand();
//        }
//        return COMMAND_MAP.get(commandKey);
//    }
//}