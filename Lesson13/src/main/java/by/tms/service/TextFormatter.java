package by.tms.service;

import by.tms.utils.Constants;
import org.apache.commons.lang3.StringUtils;

public class TextFormatter {
    public int getNumberOfWordsInString(String string) {
        return string.split(" ").length;
    }

    public boolean checkPalindromeWordInString(String string) {
        for (String strPalindromeTestValue : string.split("[\\s,\\.;:-\\?!]")) {
            if (strPalindromeTestValue.equals(StringUtils.reverse(strPalindromeTestValue))
                    && strPalindromeTestValue.length() > Constants.MIN_PALINDROME_LENGTH) {
                return true;
            }
        }
        return false;
    }

    public String getMiddleCharOfWord(String string) {
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
}
