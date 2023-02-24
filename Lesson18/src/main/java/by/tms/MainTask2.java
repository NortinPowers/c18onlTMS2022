package by.tms;

import static by.tms.utils.DateHelper.getNextTuesdayDate;

import java.time.LocalDate;

public class MainTask2 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nextTuesday = getNextTuesdayDate(now);
        System.out.println(nextTuesday.getDayOfWeek());
    }
}