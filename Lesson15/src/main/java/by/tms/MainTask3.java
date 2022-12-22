package by.tms;

import by.tms.service.TextFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.tms.service.TextFormatter.*;
import static by.tms.utils.FilePaths.*;

public class MainTask3 {
    public static void main(String[] args) {
        try (BufferedReader bR = new BufferedReader(new FileReader(INPUT_TASK3));
             BufferedReader bRC = new BufferedReader(new FileReader(CENSOR));
             BufferedWriter bW = new BufferedWriter(new FileWriter(OUTPUT_TASK3))) {
            TextFormatter textFormatter = new TextFormatter();
            StringBuilder text = getStringBuilderFromInputTxt(bR);
            List<String> censorBlackList = getStringsFromInputTxt(bRC);
            List<String> stringsListBasedOnText = textFormatter.getStringsListBasedOnText(text.toString());
            List<String> stringsBlackListText = new ArrayList<>();
            boolean censorFlag = false;
            for (String string : stringsListBasedOnText) {
                if (textFormatter.isCensorNotPass(string, censorBlackList)) {
                    censorFlag = true;
                    stringsBlackListText.add(string);
                }
            }
            if (censorFlag) {
                bW.write(stringsBlackListText.size() + " sentences of the text did not pass the censors check:\n");
                bW.flush();
                createOutputTxtFromList(bW, stringsBlackListText);
            }
        } catch (IOException e) {
            System.out.println("Unexpected error " + e);
        }
        System.out.println("The file \"" + OUTPUT_FILE_NAME + "\" into " + TASK3_PACKAGE
                + " contains sentences that have not passed the censorship check");
    }
}
