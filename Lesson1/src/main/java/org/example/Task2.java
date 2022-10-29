package org.example;

import java.util.Scanner;

public class Task2 implements NumberAware {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a some integers (pattern: \"integer + space + integer..\") and press Enter:");
        String stringValue = sc.nextLine();
        NumberAware task2 = new Task2();
        int count = task2.getPositiveNumbers(stringValue);
        if (count > 0) {
            System.out.println("The count of positive integers is " + count);
        } else {
            System.out.println("There are no positive integers among the data");
        }
    }

    @Override
    public int getPositiveNumbers(String charactersEntered) {
        int count = 0;
        String[] processedEnteredCharacters = charactersEntered.replace(",", ".").split(" ");
        for (String element : processedEnteredCharacters) {
            try {
                if (Double.parseDouble(element) > 0) {
                    count++;
                }
            } catch (Exception e) {
            }
        }
        return count;
    }
}

interface NumberAware {
    int getPositiveNumbers(String charactersEntered);
}