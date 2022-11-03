package org.example;

import java.util.*;

public class HomeworkL4 {
    public static void main(String[] args) {
        System.out.println("Problem 1:");
        System.out.println("Alphabet " + getAlphabet());
        System.out.println("Problem 2:");
        parityCheck();
        System.out.println("Problem 3:");
        absMinValue();
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
     * The method checks the parity of the number
     */
    public static void parityCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer for check parity and press Enter:");
        String stringValue = sc.nextLine();
        ParityDeterminable determinant = new ParityResultValue();
        try {
            parityCheckInfo(determinant.isParityValue(stringValue));
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect data entered");
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three real numbers for check and press Enter:");
        String stringValue = scanner.nextLine();
        ValueReceivable comparator = new MinAbsResultValue();
        try {
            if (isAbsMinValueProblemCondition(comparator.getAbsValue(stringValue))) {
                System.out.println(getMinValue(comparator.getAbsValue(stringValue)));
            } else {
                System.out.println("Comparison method canceled");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Incorrect data entered");
        }
    }

    /**
     * The method allows the absMinValue method you to compare any number of numbers
     */
    public static boolean isAbsMinValueProblemCondition(List<Double> valuesList) {
        if (valuesList.size() > 0) {
            if (valuesList.size() != 3) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("""
                        The number of numbers being compared is not equal to 3\s
                        if you want to continue the comparison, enter Y\s
                        otherwise, enter N""");
                String stringValue = scanner.nextLine();
                return isAgree(stringValue);
            }
            return true;
        } else {
            throw new NullPointerException();
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
        if (values.size() > 0) {
            Collections.sort(values);
            return values.get(0);
        } else {
            throw new NullPointerException();
        }
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
        int checkResult;
        try {
            checkResult = Integer.parseInt(enteredCharacters) % 2;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return checkResult == 0;
    }
}

/**
 * The interface declaring the ability to get the minimum value
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
            try {
                doubleValueList.add(Math.abs(Double.parseDouble(element)));
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        return doubleValueList;
    }


}
