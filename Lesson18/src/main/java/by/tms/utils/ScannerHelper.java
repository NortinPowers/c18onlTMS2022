package by.tms.utils;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

@UtilityClass
public class ScannerHelper {

    /**
     * The method returns an integer (1 or 2) from the console
     */
    public static int getConditionalInputIntValue(Scanner scanner) {
        int value;
        System.out.println("Input integer 1 (to reverse string) or 2 (to get the factorial of a number):");
        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value == 1 || value == 2) {
                    return value;
                }
            }
            System.out.println("Need integer 1 or 2!\nRepeat input");
            scanner.nextLine();
        } while (true);
    }

    /**
     * The method returns a positive integer from the console
     */
    public static int getInputIntPositiveValue(Scanner scanner) {
        int value;
        System.out.println("Input integer to get the factorial:");
        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 0) {
                    return value;
                }
            } else {
                System.out.println("Need positive integer or 0!\nRepeat input");
                scanner.nextLine();
            }
        } while (true);
    }
}