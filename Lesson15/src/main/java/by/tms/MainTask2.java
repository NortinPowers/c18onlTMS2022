package by.tms;

import by.tms.service.TextFormatter;

import java.io.*;
import java.util.List;

import static by.tms.utils.FilePaths.*;

public class MainTask2 {
    public static void main(String[] args) {
        try (BufferedReader bR = new BufferedReader(new FileReader(INPUT_TASK2));
             BufferedWriter bW = new BufferedWriter(new FileWriter(OUTPUT_TASK2))) {
            StringBuilder text = new StringBuilder();
            TextFormatter textFormatter = new TextFormatter();
            while (bR.read() != -1) {
                text.append(bR.readLine());
            }
            List<String> stringsListBasedOnText = textFormatter.getStringsListBasedOnText(text.toString());
            for (String string : stringsListBasedOnText) {
                if (textFormatter.checkStringLength(string) || textFormatter.checkPalindromeWordInString(string)) {
                    bW.write(string.trim() + "\n");
                    bW.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        System.out.println("The file \"" + OUTPUT_FILE_NAME + "\" into " + TASK2_PACKAGE
                + " contains sentences from the text in which from 3 to 5 words or a palindrome is present");
    }
}
