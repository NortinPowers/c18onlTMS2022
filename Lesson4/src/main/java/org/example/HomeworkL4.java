package org.example;

import java.util.Arrays;

public class HomeworkL4 {
    public static void main(String[] args) {
        System.out.println("Problem 1:");
        System.out.println("Alphabet " + getAlphabet());
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

    public static void getParityCheck(int value) {

    }


}

