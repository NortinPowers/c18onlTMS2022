package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a some integers (pattern: \"integer + space + integer..\") and press Enter:");
        String stringValue = sc.nextLine();
        NumberAware calculation = new PositiveNumbers();
        countInfo(calculation.getPositiveNumbers(stringValue));
    }

    public static void countInfo(int count) {
        if (count > 0) {
            System.out.println("The count of positive integers is " + count);
        } else {
            System.out.println("There are no positive integers among the data");
        }
    }

}

interface NumberAware {
    int getPositiveNumbers(String enteredCharacters);
}

class PositiveNumbers implements NumberAware {
    @Override
    public int getPositiveNumbers(String enteredCharacters) {
        double currentStringValue;
        List<Double> positiveValueList = new ArrayList<>();
        String[] processedEnteredCharacters = enteredCharacters.replace(",", ".").split(" ");
        for (String element : processedEnteredCharacters) {
            try {
                currentStringValue = Double.parseDouble(element);
            } catch (Exception e) {
                currentStringValue = 0;
            }
            if (currentStringValue > 0) {
                positiveValueList.add(currentStringValue);
            }
        }
        return positiveValueList.size();
    }
}