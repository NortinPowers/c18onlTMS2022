package org.example;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a some integers (sample: \"integer + space + integer..\") and press Enter:");
        String st = sc.nextLine();
        Solution solution = new Solution();
        if (solution.numberOfInt(st) == 0) {
            System.out.println("There are no positive integers among the data");
        }
        if (solution.numberOfInt(st) > 0) {
            System.out.println("The count of positive integers is " + solution.numberOfInt(st));
        }
    }
    static class Solution {
        public int numberOfInt(String s) {
            int count = 0;
            try {
                String[] sts = s.split(" ");
                for (String res : sts) {
                    if (Integer.parseInt(res) > 0) {
                        count++;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Check the entered data");
                return -1;
            }
            return count;
        }
    }
}