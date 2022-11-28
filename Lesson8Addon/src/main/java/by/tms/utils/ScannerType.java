package by.tms.utils;

import java.util.Scanner;

import static by.tms.utils.Constants.NO_CONTAINS;
import static by.tms.utils.Constants.SOME_CONTAINS;

public final class ScannerType {

    private ScannerType() {
    }

    /**
     * The method returns an integer corresponding to the specified limits from the console
     */
    public static int getInputIntValueAccordingConditions(Scanner scanner, int minLimit, int maxLimit) {
        int value = 0;
        boolean compliance = false;
        System.out.println("Input integer with conditions: min limit \" " + minLimit + " \" , max limit \" " + maxLimit + " \"");
        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < minLimit || value > maxLimit) {
                    getIntConditionsInfo(SOME_CONTAINS);
                    scanner.nextLine();
                } else {
                    compliance = true;
                }
            } else {
                getIntConditionsInfo(SOME_CONTAINS);
                scanner.nextLine();
            }
        } while (!compliance);
        return value;
    }

    /**
     * The method notifies the requirements for the entered value
     */
    private static void getIntConditionsInfo(String conditions) {
        System.out.println("Need integer" + conditions + "!\nRepeat input");
    }

    /**
     * The method returns an integer from the console
     */
    public static int getInputIntValueAllIntRange(Scanner scanner) {
        int value;
        System.out.println("Input integer:");
        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                break;
            } else {
                getIntConditionsInfo(NO_CONTAINS);
                scanner.nextLine();
            }
        } while (true);
        return value;
    }
}
