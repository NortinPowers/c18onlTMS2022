package by.tms;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MainTask3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("john", "arya", "sansa");
        List<String> modifyNames = names.stream()
                .map(StringUtils::capitalize)
                .toList();
        System.out.println(modifyNames);
    }
}