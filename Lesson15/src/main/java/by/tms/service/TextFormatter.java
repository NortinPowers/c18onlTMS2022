package by.tms.service;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.tms.utils.Constants.*;

public class TextFormatter {


    public boolean isPalindrome(@NonNull String word) {
        String worldIgnoreCase = word.toLowerCase();
        return worldIgnoreCase.equals(StringUtils.reverse(worldIgnoreCase))
                && worldIgnoreCase.matches("[a-zа-я]{2,}");
    }

    public int getNumberOfWordsInString(@NonNull String string) {
        return string.split(" ").length;
    }

    public boolean checkPalindromeWordInString(@NonNull String string) {
        for (String srt : string.split(REGEX_NOT_LETTERS)) {
            if (isPalindrome(srt)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getStringsListBasedOnText(@NonNull String text) {
        return new ArrayList<>(Arrays.asList(text.split("[.?!]")));
    }

    public boolean checkStringLength(String string) {
        return getNumberOfWordsInString(string) >= MIN_NUMBER_OF_WORDS_IN_STRING
                && getNumberOfWordsInString(string) <= MAX_NUMBER_OF_WORDS_IN_STRING;
    }

    public boolean isCensorNotPass(String string, List<String> censorList) {
        for (String word : string.split(REGEX_NOT_LETTERS)) {
            for (String censorWord : censorList) {
                if (censorWord.equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void createOutputTxtFromList(BufferedWriter bW, List<String> stringsBlackListText) throws IOException {
        for (String string : stringsBlackListText) {
            bW.write(string.trim() + "\n");
            bW.flush();
        }
    }

    public static List<String> getStringsFromInputTxt(BufferedReader bRC) throws IOException {
        String word;
        List<String> wordList = new ArrayList<>();
        while ((word = bRC.readLine()) != null) {
            wordList.add(word);
        }
        return wordList;
    }

    public static StringBuilder getStringBuilderFromInputTxt(BufferedReader bR) throws IOException {
        StringBuilder text = new StringBuilder();
        char[] strBuf = new char[MAX_WORDS_LENGTH];
        int readCount;
        while ((readCount = bR.read(strBuf)) != -1) {
            String readData = String.valueOf(strBuf, 0, readCount);
            text.append(readData);
        }
        return text;
    }
}
