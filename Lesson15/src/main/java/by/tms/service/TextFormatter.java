package by.tms.service;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

public class TextFormatter {

    public boolean isPalindrome(@NonNull String string) {
        String strIgnoreCase = string.toLowerCase();
        return strIgnoreCase.equals(StringUtils.reverse(strIgnoreCase))
                && strIgnoreCase.matches("[a-zа-я]{2,}");
    }
}
