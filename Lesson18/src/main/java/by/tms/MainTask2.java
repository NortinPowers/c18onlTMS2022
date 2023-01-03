package by.tms;

import java.time.LocalDate;

import static by.tms.utils.DateHelper.getNextTuesdayDate;

public class MainTask2 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nextTuesday = getNextTuesdayDate(now);
        System.out.println(nextTuesday.getDayOfWeek());
    }
}