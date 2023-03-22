package by.tms.utils;

import static by.tms.model.Attribute.USER_UUID;
import static by.tms.model.Commands.PRODUCTS_PAGE_COMMAND;
import static by.tms.model.PagesPath.ESHOP_PAGE;
import static by.tms.model.PagesPath.HOME_PAGE;
import static by.tms.model.PagesPath.PHONE_PRODUCTS_PAGE;
import static by.tms.model.PagesPath.TV_PRODUCTS_PAGE;
import static by.tms.model.RequestParameters.COMMAND;

import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import by.tms.model.ProductType;
import by.tms.model.RequestParameters;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ControllerUtils {

//    public static String getHomePagePath() {
//        return HOME_PAGE.getPath();
//    }

    public static PagesPath getHomePagePath() {
        return HOME_PAGE;
    }

    public static String getPathByType(String type) {
        String path;
        path = "/" + ESHOP_PAGE.getPath() + "?" + COMMAND.getValue() + "="
                + PRODUCTS_PAGE_COMMAND.getCommand() + "&" + RequestParameters.TYPE.getValue()
                + "=" + type;
        return path;
    }

    public static PagesPath getPagePathByType(String pathByType) {
        PagesPath pagesPath;
        if (ProductType.TV.getValue().equals(pathByType)) {
            pagesPath = TV_PRODUCTS_PAGE;
        } else if (ProductType.PHONE.getValue().equals(pathByType)) {
            pagesPath = PHONE_PRODUCTS_PAGE;
        } else {
            pagesPath = HOME_PAGE;
        }
        return pagesPath;
    }

    public static <T> void throwCommandException(HttpServletRequest request, Exception e, Class<T> commandController) throws CommandException {
        String errorMessage = "Exception! It is impossible to go to the address from controller: " + commandController.getSimpleName() + ": ";
        HttpSession session = request.getSession(false);
        String userUUID = "[" + session.getAttribute(USER_UUID.getAttribute()) + "] ";
        throw new CommandException(userUUID + errorMessage + e.getMessage());
    }

}