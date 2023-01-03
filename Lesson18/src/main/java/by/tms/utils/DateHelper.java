package by.tms.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@UtilityClass
public class DateHelper {
    private final int TWO_DIGIT_YEAR_LIMIT = 100;
    private final int OUR_TIME_PREFIX = 2000;
    private final int NUMBER_OF_MONTHS = 12;
    private final int ZERO = 0;
    private final int BETWEEN_MON_AND_TUE = 1;
    private final int WEEK_PLUS_TUE = 9;
    public static final String VALID_DATE_FORMAT = "\\d{1,2}\\.\\d{1,2}\\.\\d{1,4}";

    /**
     * The method returns a message that the entered data is incorrect
     *
     * @return String
     */
    public static String getErrorMessage() {
        return "invalid date format, re-enter the date (date format dd.mm.yyyy or dd.mm.yyyy)";
    }

    /**
     * The method returns the year value converted from YY format to YYYY format
     *
     * @return int
     */
    public static int getFormattedYear(int year) {
        if (year < TWO_DIGIT_YEAR_LIMIT) {
            year = OUR_TIME_PREFIX + year;
        }
        return year;
    }

    /**
     * The method checks the entered month value and displays a message to the console if the check fails
     *
     * @return boolean
     */
    public static boolean isMonthNotValid(int month) {
        if (month > NUMBER_OF_MONTHS || month <= ZERO) {
            System.out.println(getErrorMessage());
            return true;
        }
        return false;
    }

    /**
     * The method checks the entered day value and displays a message to the console if the check fails
     *
     * @return boolean
     */
    public static boolean isDayNotValid(int day, int month, int year) {
        int dayOnMonth = Month.of(month).length(Year.isLeap(year));
        if (day > dayOnMonth || day <= ZERO) {
            System.out.println(getErrorMessage());
            return true;
        }
        return false;
    }

    /**
     * The method returns the date of the following Tuesday
     *
     * @return boolean
     */
    public static LocalDate getNextTuesdayDate(@NonNull LocalDate now) {
        int dayOfWeek = now.getDayOfWeek().getValue();
        LocalDate nextTuesday;
        if (dayOfWeek == 1) {
            nextTuesday = now.plusDays(BETWEEN_MON_AND_TUE);
        } else {
            nextTuesday = now.plusDays(WEEK_PLUS_TUE - dayOfWeek);
        }
        return nextTuesday;
    }
}