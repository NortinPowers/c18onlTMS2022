package by.tms;

import java.util.Arrays;
import java.util.List;

public class MainTask1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> modifyInt = integers.stream()
                .map(integer -> integer * 2)
                .toList();
        System.out.println(modifyInt);
    }
}