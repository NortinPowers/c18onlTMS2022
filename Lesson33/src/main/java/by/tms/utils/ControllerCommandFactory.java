package by.tms.utils;

import static by.tms.utils.InjectObjectsFactory.createAndInjectInstances;

import by.tms.controller.CommandController;
import by.tms.controller.impl.AccountPageCommandImplController;
import by.tms.controller.impl.AddCartPageCommandImplController;
import by.tms.controller.impl.AddFavoritePageCommandImplController;
import by.tms.controller.impl.CreateUserPageCommandImplController;
import by.tms.controller.impl.DeleteCartProductPageCommandImplController;
import by.tms.controller.impl.DeleteFavoriteCommandImplController;
import by.tms.controller.impl.FavoritesCommandImplController;
import by.tms.controller.impl.HomePageCommandImplController;
import by.tms.controller.impl.LoginPageCommandImplController;
import by.tms.controller.impl.LogoutPageCommandImplController;
import by.tms.controller.impl.ProductPageCommandImplController;
import by.tms.controller.impl.ShoppingCartPageImpl;
import by.tms.model.Commands;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ControllerCommandFactory {

    private final static Map<String, CommandController> COMMANDS = new ConcurrentHashMap<>();

    public static CommandController defineCommand(Commands command) throws Exception {
        return putIfAbsent(command.getCommand(), createController(command));
    }

    private static Supplier<CommandController> createController(Commands command) {
        return switch (command) {
            case HOME_PAGE_COMMAND -> HomePageCommandImplController::new;
            case PRODUCTS_PAGE_COMMAND -> ProductPageCommandImplController::new;
            case ACCOUNT_PAGE_COMMAND -> AccountPageCommandImplController::new;
            case ADD_CART_PAGE_COMMAND -> AddCartPageCommandImplController::new;
            case ADD_FAVORITE_PAGE_COMMAND -> AddFavoritePageCommandImplController::new;
            case LOGIN_PAGE_COMMAND -> LoginPageCommandImplController::new;
            case CREATE_USER_PAGE_COMMAND -> CreateUserPageCommandImplController::new;
            case DELETE_CART_PRODUCT_PAGE_COMMAND -> DeleteCartProductPageCommandImplController::new;
            case DELETE_FAVORITE_PRODUCT_PAGE_COMMAND -> DeleteFavoriteCommandImplController::new;
            case FAVORITES_PAGE_COMMAND -> FavoritesCommandImplController::new;
            case LOGOUT_PAGE_COMMAND -> LogoutPageCommandImplController::new;
            case SHOPPING_CART_PAGE_COMMAND -> ShoppingCartPageImpl::new;
        };
    }

    private static CommandController putIfAbsent(String key, Supplier<CommandController> supplier) throws Exception {
        CommandController value = COMMANDS.get(key);
        if (value == null) {
            value = create(supplier);
            COMMANDS.put(key, value);
        }
        return value;
    }

    private static CommandController create(Supplier<CommandController> supplier) throws Exception {
        CommandController baseController = supplier.get();
        createAndInjectInstances(baseController);
        return baseController;
    }

}
