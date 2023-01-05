package by.tms;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static by.tms.utils.Constants.SET_SIZE;

public class MainTask2 {
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        Random random = new Random();
        while (integers.size() < SET_SIZE) {
            integers.add(random.nextInt(101) - 50);
        }
        System.out.println(integers);
        Set<Integer> positiveInt = integers.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(positiveInt.size());
    }
}
