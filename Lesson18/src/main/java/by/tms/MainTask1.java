package by.tms;

import static by.tms.utils.Constants.ERROR_MESSAGE;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTask1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean act = true;
        String inputDate;
        System.out.println("Enter the date in the format dd.mm.yy or dd.mm.yyyy");
        List<DateTimeFormatter> formatters = new ArrayList<>();
        formatters.add(DateTimeFormatter.ofPattern("[dd.MM.yy]"));
        formatters.add(DateTimeFormatter.ofPattern("[dd.MM.yyyy]"));
        LocalDate date;
        String errorMessage = "";
        do {
            if (scanner.hasNext()) {
                inputDate = scanner.nextLine();
                for (DateTimeFormatter formatter : formatters) {
                    try {
                        date = LocalDate.parse(inputDate, formatter);
                        System.out.println(date.getDayOfWeek());
                        act = false;
                        break;
                    } catch (Exception e) {
                        errorMessage = e.getMessage();
                    }
                }
                if (act) {
                    System.out.println(ERROR_MESSAGE + " " + errorMessage);
                }
            } else {
                scanner.next();
            }
        } while (act);
    }
}