package by.tms;

import static by.tms.utils.FilePaths.INPUT_TASK2;
import static by.tms.utils.FilePaths.OUTPUT_TASK2;
import static by.tms.utils.FilePaths.OUTPUT_TXT_FILE_NAME;
import static by.tms.utils.FilePaths.TASK2_PACKAGE;

import by.tms.service.TextFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainTask2 {

    static TextFormatter textFormatter = new TextFormatter();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_TASK2));
                BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_TASK2))) {
            StringBuilder text = textFormatter.getStringBuilderFromFileTxt(reader);
            List<String> stringsListBasedOnText = textFormatter.getStringsListBasedOnText(text.toString());
            for (String string : stringsListBasedOnText) {
                if (textFormatter.checkStringLength(string) || textFormatter.checkPalindromeWordInString(string)) {
                    writer.write(string.trim() + "\n");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error " + e.getMessage());
        }
        System.out.println("The file \"" + OUTPUT_TXT_FILE_NAME + "\" into " + TASK2_PACKAGE
                                   + " contains sentences from the text in which from 3 to 5 words or a palindrome is present");
    }
}
