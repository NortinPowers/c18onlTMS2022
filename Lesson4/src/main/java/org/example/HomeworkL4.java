package org.example;

import java.util.*;

public class HomeworkL4 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Task 1:");
        System.out.println("Alphabet " + getAlphabet());
        System.out.println("Alphabet " + getAlphabetSecond());
        System.out.println("Alphabet " + getAlphabetThird());
        System.out.println("Task 2:");
        parityCheck();
        System.out.println("Task 3:");
        absMinValue();
        System.out.println("Task 4:");
        workTimeInfo();
        System.out.println();
        System.out.println("Task 5:");
        typeConversionInfo();
    }

    /**
     * The method returns all the letters
     * <p>
     * &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
     * of the English alphabet
     */
    public static String getAlphabet() {
        char symbol = 'A';
        char[] alphabetArray = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabetArray[i] = (char) (i + symbol);
        }
        return Arrays.toString(alphabetArray);
    }

    /**
     * The method returns all the letters
     * <p>
     * of the English alphabet
     */
    public static String getAlphabetSecond() {
        char symbolCount = 'Z' - 'A' + 1;
        char[] alphabetArray = new char[symbolCount];
        for (int i = 0; i < symbolCount; i++) {
            alphabetArray[i] = (char) (i + 'A');
        }
        return Arrays.toString(alphabetArray);
    }

    /**
     * The method returns all the letters
     * <p>
     * of the English alphabet
     */
    public static String getAlphabetThird() {
        char[] alphabetArray = new char['Z' - 'A' + 1];
        for (char i = 'A'; i < 'Z' + 1; i++) {
            alphabetArray[i - 'A'] = i;
        }
        return Arrays.toString(alphabetArray);
    }

    /**
     * The method checks the parity of the number
     */
    public static void parityCheck() {
        System.out.println("Enter the integer for check parity and press Enter:");
        String stringValue = scanner.nextLine();
        ParityDeterminable determinant = new ParityResultValue();
        try {
            parityCheckInfo(determinant.isParityValue(stringValue));
        } catch (Exception e) {
            System.out.println("Incorrect data entered " + "( " + e.getMessage() + " )");
        }
    }

    /**
     * The method outputs information about the parity of a number
     */
    public static void parityCheckInfo(boolean checkParity) {
        if (checkParity) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }
    }

    /**
     * The method return the smallest absolute value of the three numbers
     */
    public static void absMinValue() {
        System.out.println("Enter three real numbers for check and press Enter:");
        String stringValue = scanner.nextLine();
        ValueReceivable comparator = new MinAbsResultValue();
        try {
            System.out.println(getMinValue(comparator.getAbsValue(stringValue)));
        } catch (Exception e) {
            System.out.println("Incorrect data entered " + "( " + e.getMessage() + " )");
        }
    }

    /**
     * The method return the user selection
     */
    public static boolean isAgree(String enteredCharacter) {
        String userSelection = enteredCharacter.toLowerCase();
        return userSelection.equals("y");
    }

    /**
     * The method return the smallest value of double List
     */
    public static double getMinValue(List<Double> values) {
        Collections.sort(values);
        return values.get(0);
    }

    public static void workTimeInfo() {
        int taskCurrentTime = (int) (Math.random() * 28801);
        System.out.println("Current time is " + taskCurrentTime);
        System.out.println("Times for Petrov is " + taskCurrentTime);
        System.out.printf("Times for Employee - remained %d full hours", taskCurrentTime / 3600);
    }

    /**
     * The method return type conversion table
     */
    public static void typeConversionInfo() {
        System.out.println("              byte\tshort\tchar\tint \tlong\tfloat\tdouble\tboolean\n" +
                "    byte       т      ня      я      ня      ня       ня      ня       х\n" +
                "    short      я       т      я      ня      ня       ня      ня       х\n" +
                "    char       я       я      т      ня      ня       ня      ня       х\n" +
                "    int        я       я      я       т      ня       ня      ня       х\n" +
                "    long       я       я      я       я       т       ня      ня       х\n" +
                "    float      я       я      я       я       я        т      ня       х\n" +
                "    double     я       я      я       я       я        я       т       х\n" +
                "    boolean    х       х      х       х       х        х       х       т");

    }
}

/**
 * The interface declaring the ability to determine parity
 */
interface ParityDeterminable {
    boolean isParityValue(String enteredCharacters);
}

/**
 * Class that implements the interface ParityDeterminable
 */
class ParityResultValue implements ParityDeterminable {

    @Override
    public boolean isParityValue(String enteredCharacters) {
        int checkResult = parser(enteredCharacters) % 2;
        return checkResult == 0;
    }

    public static int parser(String enteredCharacters) {
        return Integer.parseInt(enteredCharacters);
    }
}

/**
 * The interface declaring the ability
 * <p>
 * to get list of abs value
 */
interface ValueReceivable {
    List<Double> getAbsValue(String enteredCharacters);
}

/**
 * Class that implements the interface MinValueReceivable
 */
class MinAbsResultValue implements ValueReceivable {

    @Override
    public List<Double> getAbsValue(String enteredCharacters) {
        List<Double> doubleValueList = new ArrayList<>();
        String[] processedEnteredCharacters = enteredCharacters.replace(",", ".").split(" ");
        for (String element : processedEnteredCharacters) {
            if (doubleValueList.size() < 3) {
                doubleValueList.add(Math.abs(Double.parseDouble(element)));
            }
        }
        return doubleValueList;
    }
}
