package by.tms.utils;

import java.time.LocalDate;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateHelper {

    private static final int ONE_DAY = 1;
    private static final int NINE_DAYS = 9;

    /**
     * The method returns the date of the following Tuesday
     *
     * @return boolean
     */
    public static LocalDate getNextTuesdayDate(@NonNull LocalDate now) {
        int dayOfWeek = now.getDayOfWeek().getValue();
        LocalDate nextTuesday;
        if (dayOfWeek == 1) {
            nextTuesday = now.plusDays(ONE_DAY);
        } else {
            nextTuesday = now.plusDays(NINE_DAYS - dayOfWeek);
        }
        return nextTuesday;
    }
}