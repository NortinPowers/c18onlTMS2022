package org.example;

import java.util.Scanner;

public class Task2 implements NumberOfPositiveNumbers_able {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a some integers (pattern: \"integer + space + integer..\") and press Enter:");
        String st = sc.nextLine();
        Task2 task2 = new Task2();
        int count = task2.parseArgsAndGetCountValue(st);
        if (count > 0) {
            System.out.println("The count of positive integers is " + count);
        } else {
            System.out.println("There are no positive integers among the data");
        }
    }
}

interface NumberOfPositiveNumbers_able {
    default int parseArgsAndGetCountValue(String s) {
        int count = 0;
        String[] sts = s.replace(",", ".").split(" ");
        for (String res : sts) {
            try {
                if (Double.parseDouble(res) > 0) {
                    count++;
                }
            } catch (Exception e) {
            }
        }
        return count;
    }
}