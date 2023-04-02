package by.tms.utils;

import static by.tms.model.PagesPath.HOME_PAGE;
import static by.tms.model.PagesPath.PHONE_PRODUCTS_PAGE;
import static by.tms.model.PagesPath.TV_PRODUCTS_PAGE;
import static by.tms.utils.Constants.Attributes.USER_UUID;
import static by.tms.utils.Constants.CONVERSATION;
import static by.tms.utils.Constants.PATH_TO_PRODUCT_TYPE;
import static by.tms.utils.Constants.RequestParameters.BIRTHDAY;
import static by.tms.utils.Constants.RequestParameters.EMAIL;
import static by.tms.utils.Constants.RequestParameters.NAME;
import static by.tms.utils.Constants.RequestParameters.PASSWORD;
import static by.tms.utils.Constants.RequestParameters.SURNAME;

import by.tms.exception.CommandException;
import by.tms.model.PagesPath;
import by.tms.model.ProductType;
import by.tms.model.User;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

@UtilityClass
@Slf4j
public class ControllerUtils {

    public static PagesPath getHomePagePath() {
        return HOME_PAGE;
    }

    public static String getPathByType(String type) {
        return PATH_TO_PRODUCT_TYPE + type;
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
        String userUUID = "[" + session.getAttribute(USER_UUID) + "] ";
        throw new CommandException(userUUID + errorMessage + e.getMessage());
    }

    public static String checkAndGetUserUUID(HttpServletRequest request, HttpSession session) {
        String userUUID;
        if (session == null) {
            session = request.getSession();
        }
        if (session.getAttribute(USER_UUID) != null) {
            userUUID = (String) session.getAttribute(USER_UUID);
        } else {
            userUUID = UUID.randomUUID().toString();
            MDC.put(CONVERSATION, userUUID);
            request.getSession().setAttribute(USER_UUID, userUUID);
            log.info("Not logged in user with UUID " + userUUID + " searches for products");
        }
        return userUUID;
    }

    public static User getUser(HttpServletRequest request, String login) {
        return User.builder()
                   .login(login)
                   .password(request.getParameter(PASSWORD))
                   .name(request.getParameter(NAME))
                   .surname(request.getParameter(SURNAME))
                   .email(request.getParameter(EMAIL))
                   .birthday(LocalDate.parse(request.getParameter(BIRTHDAY)))
                   .build();
    }

    public static BigDecimal getPrice(HttpServletRequest request, String param, BigDecimal defaultValue) {
        String value = request.getParameter(param);
        return StringUtils.isNotBlank(value) ? new BigDecimal(value) : defaultValue;
    }
}