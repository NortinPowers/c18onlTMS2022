package by.tms.service;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import static by.tms.utils.Constants.MIN_PALINDROME_LENGTH;
import static by.tms.utils.Constants.REGEX_NOT_RUS_LETTERS;

public class TextFormatter {

    public int getNumberOfWordsInString(@NonNull String string) {
        return string.split(" ").length;
    }

    public boolean checkPalindromeWordInString(@NonNull String string) {
        for (String strPalindromeTestValue : string.split(REGEX_NOT_RUS_LETTERS)) {
            if (strPalindromeTestValue.equals(StringUtils.reverse(strPalindromeTestValue))
                    && strPalindromeTestValue.length() > MIN_PALINDROME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    public String getMiddleCharOfWord(@NonNull String string) {
        if (string.length() > 0) {
            int srtLength = string.length();
            if (srtLength % 2 == 0) {
                return string.substring(srtLength / 2 - 1, srtLength / 2 + 1);
            } else {
                return String.valueOf(string.charAt(srtLength / 2));
            }
        } else {
            return "";
        }
    }

    public int getNumberOfLatinAlphabetWords(@NonNull String string) {
        int count = 0;
        for (String str : string.split("[\\s \\W]")) {
            if (str.matches("([A-Za-z])+")) {
                count++;
            }
        }
        return count;
    }
}
