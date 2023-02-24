package by.tms;

import static by.tms.utils.FilePaths.INPUT_TASK1;
import static by.tms.utils.FilePaths.INPUT_TXT_FILE_NAME;
import static by.tms.utils.FilePaths.OUTPUT_TASK1;
import static by.tms.utils.FilePaths.OUTPUT_TXT_FILE_NAME;
import static by.tms.utils.FilePaths.TASK1_PACKAGE;

import by.tms.service.TextFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class MainTask1 {

    static TextFormatter textFormatter = new TextFormatter();

    public static void main(String[] args) {
        try {
            List<String> words = Files.readAllLines(Path.of(INPUT_TASK1));
            Files.write(Path.of(OUTPUT_TASK1), Collections.singleton(textFormatter.getPalindrome(words)));
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        System.out.println("Palindromes from file \"" + INPUT_TXT_FILE_NAME + "\" were written to file \"" + OUTPUT_TXT_FILE_NAME +
                                   "\" into the package: " + TASK1_PACKAGE);
    }
}