package by.tms;

import java.time.LocalDate;
import java.util.Scanner;

import static by.tms.utils.DateHelper.*;

public class MainTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean act = true;
        String inputDate;
        System.out.println("Enter the date in the format dd.mm.yyyy or dd.mm.yyyy");
        do {
            if (scanner.hasNext()) {
                inputDate = scanner.nextLine();
                if (inputDate.matches(VALID_DATE_FORMAT)) {
                    String[] dateElement = inputDate.split("\\.");
                    int month = Integer.parseInt(dateElement[1]);
                    if (isMonthNotValid(month)) continue;
                    int year = Integer.parseInt(dateElement[2]);
                    year = getFormattedYear(year);
                    int day = Integer.parseInt(dateElement[0]);
                    if (isDayNotValid(day, month, year)) continue;
                    LocalDate date = LocalDate.of(year, month, day);
                    System.out.println(date.getDayOfWeek());
                    act = false;
                } else {
                    System.out.println(getErrorMessage());
                }
            } else {
                scanner.next();
            }
        } while (act);
    }
}