package by.tms.utils;

import static by.tms.model.Commands.PRODUCTS_PAGE_COMMAND;
import static by.tms.model.PagesPath.ESHOP_PAGE;
import static by.tms.model.PagesPath.HOME_PAGE;
import static by.tms.model.RequestParameters.COMMAND;
import static by.tms.model.RequestParameters.TYPE;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ControllerUtils {

    public static String getHomePagePath() {
        return HOME_PAGE.getPath();
    }

    public static String getPathByType(String type) {
        String path;
        path = "/" + ESHOP_PAGE.getPath() + "?" + COMMAND.getValue() + "="
                + PRODUCTS_PAGE_COMMAND.getCommand() + "&" + TYPE.getValue()
                + "=" + type;
        return path;
    }
}