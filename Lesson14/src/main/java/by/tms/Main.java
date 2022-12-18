package by.tms;

import lombok.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Pattern patternTask2 = Pattern.compile("c+a+b+");
    static Pattern patternTask3 = Pattern.compile("Java\\s+\\d+");
    static Pattern patternTask5 = Pattern.compile("[a-z1-5]{4,20}");

    public static void main(String[] args) {
        System.out.println("Task 2:\n");
        String srtTask2 = "cab, ccab, cccab";
        Matcher matcherTask2 = patternTask2.matcher(srtTask2);
        printMatcher(matcherTask2);
        System.out.println("\nTask 3:\n");
        String srtTask3 = "Versions: Java  5, Java 6, Java   7, Java 8, Java 12.";
        Matcher matcherTask3 = patternTask3.matcher(srtTask3.replaceAll("\\s+", " "));
        printMatcher(matcherTask3);
        System.out.println("\nTask 4:");
        String str = "One two three раз два три one1 two2 123 ";
        System.out.println(str.split("\\w+\\d+|\\W+\\s*").length);
        System.out.println("\nTask 5:\n");
        System.out.println(validate("asd12"));
    }

    public static void printMatcher(@NonNull Matcher matcher) {
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static boolean validate(@NonNull String str) {
        return str.matches(patternTask5.toString());
    }
}