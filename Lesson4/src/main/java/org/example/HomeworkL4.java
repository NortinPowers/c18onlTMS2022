package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkL4 {
    public static void main(String[] args) {
        System.out.println("Problem 1:");
        System.out.println("Alphabet " + getAlphabet());
        System.out.println("Problem 2:");
        parityCheck();
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
        System.out.println("Enter the integer for check and press Enter:");
        String stringValue = sc.nextLine();
        ParityDeterminable determinant = new ParityResultValue();
        try {
            parityCheckInfo(determinant.getParityValue(stringValue));
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
}

/**
 * The interface declaring the ability to determine parity
 */
interface ParityDeterminable {
    boolean getParityValue(String enteredCharacters);
}

/**
 * Class that implements the interface parityDeterminable
 */
class ParityResultValue implements ParityDeterminable {

    @Override
    public boolean getParityValue(String enteredCharacters) {
        int checkResult;
        try {
            checkResult = Integer.parseInt(enteredCharacters) % 2;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return checkResult == 0;
    }
}

