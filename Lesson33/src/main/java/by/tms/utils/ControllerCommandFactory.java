package by.tms.utils;

import static by.tms.utils.InjectObjectsFactory.createAndInjectInstances;

import by.tms.controller.CommandController;
import by.tms.controller.impl.AccountPageCommandController;
import by.tms.controller.impl.AddCartPageCommandController;
import by.tms.controller.impl.AddFavoritePageCommandController;
import by.tms.controller.impl.CreateUserInputPageCommandController;
import by.tms.controller.impl.CreateUserPageCommandController;
import by.tms.controller.impl.DeleteCartProductPageCommandController;
import by.tms.controller.impl.DeleteFavoriteCommandController;
import by.tms.controller.impl.FavoritesCommandController;
import by.tms.controller.impl.HomePageCommandController;
import by.tms.controller.impl.LoginPageCommandController;
import by.tms.controller.impl.LoginVerifyPageCommandController;
import by.tms.controller.impl.LogoutPageCommandController;
import by.tms.controller.impl.OneProductPageCommandController;
import by.tms.controller.impl.ProductPageCommandController;
import by.tms.controller.impl.SearchFilterPageCommandController;
import by.tms.controller.impl.SearchPageCommandController;
import by.tms.controller.impl.SearchQueryPageCommandController;
import by.tms.controller.impl.ShoppingCartPageCommandController;
import by.tms.controller.impl.ShoppingCartProcessingPageCommandController;
import by.tms.model.Commands;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ControllerCommandFactory {

    private static final Map<String, CommandController> COMMANDS = new ConcurrentHashMap<>();

    public static CommandController defineCommand(Commands command) throws Exception {
        return putIfAbsent(command.getCommand(), createController(command));
    }

    private static Supplier<CommandController> createController(Commands command) {
        return switch (command) {
            case HOME_PAGE_COMMAND -> HomePageCommandController::new;
            case PRODUCTS_PAGE_COMMAND -> ProductPageCommandController::new;
            case ACCOUNT_PAGE_COMMAND -> AccountPageCommandController::new;
            case ADD_CART_PAGE_COMMAND -> AddCartPageCommandController::new;
            case ADD_FAVORITE_PAGE_COMMAND -> AddFavoritePageCommandController::new;
            case LOGIN_PAGE_COMMAND -> LoginPageCommandController::new;
            case LOGIN_PAGE_POST_COMMAND -> LoginVerifyPageCommandController::new;
            case CREATE_USER_PAGE_COMMAND -> CreateUserPageCommandController::new;
            case CREATE_USER_PAGE_POST_COMMAND -> CreateUserInputPageCommandController::new;
            case DELETE_CART_PRODUCT_PAGE_COMMAND -> DeleteCartProductPageCommandController::new;
            case DELETE_FAVORITE_PRODUCT_PAGE_COMMAND -> DeleteFavoriteCommandController::new;
            case FAVORITES_PAGE_COMMAND -> FavoritesCommandController::new;
            case LOGOUT_PAGE_COMMAND -> LogoutPageCommandController::new;
            case SHOPPING_CART_PAGE_COMMAND -> ShoppingCartPageCommandController::new;
            case SHOPPING_CART_PAGE_POST_COMMAND -> ShoppingCartProcessingPageCommandController::new;
            case SEARCH_PAGE_COMMAND -> SearchPageCommandController::new;
            case SEARCH_PAGE_POST_COMMAND -> SearchQueryPageCommandController::new;
            case PRODUCT_PAGE_COMMAND -> OneProductPageCommandController::new;
            case FILTER_PAGE_COMMAND -> SearchFilterPageCommandController::new;
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