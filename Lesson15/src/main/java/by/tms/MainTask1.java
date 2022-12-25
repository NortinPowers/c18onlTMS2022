package by.tms;

import by.tms.service.TextFormatter;

import java.io.*;

import static by.tms.utils.FilePaths.*;

public class MainTask1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_TASK1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_TASK1))) {
            String text;
            TextFormatter textFormatter = new TextFormatter();
            while ((text = reader.readLine()) != null) {
                if (textFormatter.isPalindrome(text)) {
                    writer.write(text + "\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        System.out.println("Palindromes from file \"" + INPUT_TXT_FILE_NAME + "\" were written to file \"" + OUTPUT_TXT_FILE_NAME +
                "\" into the package: " + TASK1_PACKAGE);
    }
}