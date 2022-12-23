package by.tms;

import by.tms.service.TextFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.tms.utils.FilePaths.*;

public class MainTask3 {
    static TextFormatter textFormatter = new TextFormatter();
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_TASK3));
             BufferedReader readerCensor = new BufferedReader(new FileReader(CENSOR));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_TASK3))) {
            StringBuilder text = textFormatter.getStringBuilderFromInputTxt(reader);
            List<String> censorBlackList = textFormatter.getStringsFromInputTxt(readerCensor);
            List<String> stringsListBasedOnText = textFormatter.getStringsListBasedOnText(text.toString());
            List<String> textBlackList = new ArrayList<>();
            boolean censorFlag = false;
            for (String string : stringsListBasedOnText) {
                if (textFormatter.isCensorNotPass(string, censorBlackList)) {
                    censorFlag = true;
                    textBlackList.add(string);
                }
            }
            if (censorFlag) {
                writer.write(textBlackList.size() + " sentences of the text did not pass the censors check:\n");
                writer.flush();
                textFormatter.createOutputTxtFromList(writer, textBlackList);
            }
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        System.out.println("The file \"" + OUTPUT_TXT_FILE_NAME + "\" into " + TASK3_PACKAGE
                + " contains sentences that have not passed the censorship check");
    }
}
