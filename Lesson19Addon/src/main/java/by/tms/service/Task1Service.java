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
                .distinct()
                .collect(Collectors.joining(", "));
    }

    private String[] getIntegerModifyStrFromInputStr(String str) {
        return str
                .replaceAll("[^0-9]+", " ")
                .replaceAll("\\s+", " ").split("\\s");
    }
}