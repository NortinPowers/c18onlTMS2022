package org.example;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a some integers (sample: \"integer + space + integer..\") and press Enter:");
        String st = sc.nextLine();
        Solution solution = new Solution();
        try {
            int count = solution.parseArgsAndGetCountValue(st);
            if (count > 0) {
                System.out.println("The count of positive integers is " + count);
            } else {
                System.out.println("There are no positive integers among the data");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Check the entered data");
        }
    }

    static class Solution {
        public int parseArgsAndGetCountValue(String s) {
            int count = 0;
            try {
                String[] sts = s.split(" ");
                for (String res : sts) {
                    if (Integer.parseInt(res) > 0) {
                        count++;
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            return count;
        }
    }
}