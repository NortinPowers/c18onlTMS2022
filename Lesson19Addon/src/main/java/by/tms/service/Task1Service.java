package by.tms.service;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1Service implements UniqueIntegersListMakeable {

    @Override
    public String getNonRepeatIntegerValue() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String inputStr = scanner.next();
        String[] arrayInputStr = getIntegerModifyStrFromInputStr(inputStr);
        return Arrays.stream(arrayInputStr)
                     .filter(integer -> integer.matches("[0-9]+"))
                     .distinct()
                     .collect(Collectors.joining(", "));
    }

    private String[] getIntegerModifyStrFromInputStr(String str) {
        return str.split("[^0-9]+");
    }
}