package by.tms.utils;

import static by.tms.utils.InjectObjectsFactory.createAndInjectInstances;

import by.tms.controller.CommandController;
import by.tms.controller.impl.AccountPageCommandControllerImpl;
import by.tms.controller.impl.AddCartPageCommandControllerImpl;
import by.tms.controller.impl.AddFavoritePageCommandControllerImpl;
import by.tms.controller.impl.CreateUserPageCommandControllerImpl;
import by.tms.controller.impl.CreateUserPagePostCommandControllerImpl;
import by.tms.controller.impl.DeleteCartProductPageCommandControllerImpl;
import by.tms.controller.impl.DeleteFavoriteCommandControllerImpl;
import by.tms.controller.impl.FavoritesCommandControllerImpl;
import by.tms.controller.impl.FilterPageCommandControllerImpl;
import by.tms.controller.impl.HomePageCommandControllerImpl;
import by.tms.controller.impl.LoginPageCommandControllerImpl;
import by.tms.controller.impl.LoginPagePostCommandControllerImpl;
import by.tms.controller.impl.LogoutPageCommandControllerImpl;
import by.tms.controller.impl.OneProductPageCommandControllerImpl;
import by.tms.controller.impl.ProductPageCommandControllerImpl;
import by.tms.controller.impl.SearchPageCommandControllerImpl;
import by.tms.controller.impl.SearchPagePostCommandControllerImpl;
import by.tms.controller.impl.ShoppingCartPageCommandControllerImpl;
import by.tms.controller.impl.ShoppingCartPagePostCommandControllerImpl;
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
            case HOME_PAGE_COMMAND -> HomePageCommandControllerImpl::new;
            case PRODUCTS_PAGE_COMMAND -> ProductPageCommandControllerImpl::new;
            case ACCOUNT_PAGE_COMMAND -> AccountPageCommandControllerImpl::new;
            case ADD_CART_PAGE_COMMAND -> AddCartPageCommandControllerImpl::new;
            case ADD_FAVORITE_PAGE_COMMAND -> AddFavoritePageCommandControllerImpl::new;
            case LOGIN_PAGE_COMMAND -> LoginPageCommandControllerImpl::new;
            case LOGIN_PAGE_POST_COMMAND -> LoginPagePostCommandControllerImpl::new;
            case CREATE_USER_PAGE_COMMAND -> CreateUserPageCommandControllerImpl::new;
            case CREATE_USER_PAGE_POST_COMMAND -> CreateUserPagePostCommandControllerImpl::new;
            case DELETE_CART_PRODUCT_PAGE_COMMAND -> DeleteCartProductPageCommandControllerImpl::new;
            case DELETE_FAVORITE_PRODUCT_PAGE_COMMAND -> DeleteFavoriteCommandControllerImpl::new;
            case FAVORITES_PAGE_COMMAND -> FavoritesCommandControllerImpl::new;
            case LOGOUT_PAGE_COMMAND -> LogoutPageCommandControllerImpl::new;
            case SHOPPING_CART_PAGE_COMMAND -> ShoppingCartPageCommandControllerImpl::new;
            case SHOPPING_CART_PAGE_POST_COMMAND -> ShoppingCartPagePostCommandControllerImpl::new;
            case SEARCH_PAGE_COMMAND -> SearchPageCommandControllerImpl::new;
            case SEARCH_PAGE_POST_COMMAND -> SearchPagePostCommandControllerImpl::new;
            case PRODUCT_PAGE_COMMAND -> OneProductPageCommandControllerImpl::new;
            case FILTER_PAGE_COMMAND -> FilterPageCommandControllerImpl::new;
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
