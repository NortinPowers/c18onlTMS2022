package by.tms;

import static by.tms.utils.FilePaths.CENSOR;
import static by.tms.utils.FilePaths.INPUT_TASK3;
import static by.tms.utils.FilePaths.OUTPUT_TASK3;
import static by.tms.utils.FilePaths.OUTPUT_TXT_FILE_NAME;
import static by.tms.utils.FilePaths.TASK3_PACKAGE;

import by.tms.service.TextFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainTask3 {

    static TextFormatter textFormatter = new TextFormatter();

    public static void main(String[] args) {
        String text = textFormatter.getStringFromFileTxt(INPUT_TASK3);
        List<String> strListBasedOnText = textFormatter.getStringsListBasedOnText(text);
        List<String> censorBlackList = textFormatter.getListStrFromFileTxt(CENSOR);
        List<String> textBlackList = new ArrayList<>();
        boolean censorFlag = false;
        for (String string : strListBasedOnText) {
            if (textFormatter.isCensorNotPass(string, censorBlackList)) {
                censorFlag = true;
                textBlackList.add(string);
            }
        }
        if (censorFlag) {
            textBlackList.add(0, textBlackList.size() + " sentences of the text did not pass the censors check:\n");
            textFormatter.createOutputFileTxtFromString(OUTPUT_TASK3, textBlackList);
        }
        System.out.println("The file \"" + OUTPUT_TXT_FILE_NAME + "\" into " + TASK3_PACKAGE
                                   + " contains sentences that have not passed the censorship check");
    }
}
