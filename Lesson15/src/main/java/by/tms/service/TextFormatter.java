package by.tms.service;

import by.tms.utils.Constants;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static by.tms.utils.Constants.MAX_NUMBER_OF_WORDS_IN_STRING;
import static by.tms.utils.Constants.MIN_NUMBER_OF_WORDS_IN_STRING;

public class TextFormatter {

    public boolean isPalindrome(@NonNull String string) {
        String strIgnoreCase = string.toLowerCase();
        return strIgnoreCase.equals(StringUtils.reverse(strIgnoreCase))
                && strIgnoreCase.matches("[a-zа-я]{2,}");
    }

    public int getNumberOfWordsInString(@NonNull String string) {
        return string.split(" ").length;
    }

    public boolean checkPalindromeWordInString(@NonNull String string) {
        for (String srt : string.split(Constants.REGEX_NOT_LETTERS)) {
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
}
