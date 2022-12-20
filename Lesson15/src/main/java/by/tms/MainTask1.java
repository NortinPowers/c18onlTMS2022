package by.tms;

import by.tms.service.TextFormatter;

import java.io.*;

import static by.tms.utils.FilePaths.*;

public class MainTask1 {
    public static void main(String[] args) {
        try (BufferedReader bR = new BufferedReader(new FileReader(INPUT_T1));
             BufferedWriter bW = new BufferedWriter(new FileWriter(OUTPUT_T1))) {
            String text;
            TextFormatter textFormatter = new TextFormatter();
            while ((text = bR.readLine()) != null) {
                if (textFormatter.isPalindrome(text)) {
                    bW.write(text + "\n");
                    bW.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        System.out.println("Palindromes from file \"" + INPUT_T1_NAME + "\" were written to file \"" + OUTPUT_T1_NAME +
                "\" into the package: " + TASK1_PACKAGE);
    }
}