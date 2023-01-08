package by.tms.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonUtils {
    /**
     * The method generates the necessary postfix
     *
     * @return String
     */
    public static String getPostfix(int count) {
        return switch (count) {
            case 1 -> "к";
            case 2, 3, 4 -> "ка";
            default -> "ков";
        };
    }

    /**
     * The method modify a given count to provide the method getPostfix
     *
     * @return int
     */
    public static int modifyCount(int count) {
        while (count > 100) {
            count = count % 100;
        }
        return count > 20 ? count % 10 : count;
    }
}
