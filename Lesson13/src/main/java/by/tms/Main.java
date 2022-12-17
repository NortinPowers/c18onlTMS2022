package by.tms;

import by.tms.service.TextFormatter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import static by.tms.utils.Constants.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1:");
        String strTask1 = "Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения символа(B).";
        System.out.println(strTask1.substring(strTask1.indexOf("А"), strTask1.lastIndexOf("B")));
        System.out.println("Task 2:");
        String strTask2 = "Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в позиции 0";
        System.out.println(strTask2.replace(strTask2.charAt(3), strTask2.charAt(0)));
        System.out.println("Task 3:");
        String strTask3 = "В массиве находятся слова. Вывести на экран слова палиндромы\n" +
                " * (т.е которые читаются справа на лево и слева на право одинаково, например: заказ, казак, дед...)";
        ArrayList<String> stringTask3ArrayList = new ArrayList<>();
        for (String strPalindromeTestValue : strTask3.split("[\\s,\\.;:-\\?!\\)\\(]")) {
            if (strPalindromeTestValue.equals(StringUtils.reverse(strPalindromeTestValue))
                    && strPalindromeTestValue.length() > MIN_PALINDROME_LENGTH) {
                stringTask3ArrayList.add(strPalindromeTestValue);
            }
        }
        System.out.println(stringTask3ArrayList);
        System.out.println("Task 4:");
        TextFormatter textFormatter = new TextFormatter();
        String strForTask4 = "Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения символа(B). " +
                "В массиве находятся слова. " +
                "Вывести на экран слова палиндромы. " +
                "Палиндромы - это слова, которые читаются справа на лево и слева на право одинаково, например: заказ, казак, дед.";
        for (String string : strForTask4.split("\\. ")) {
            if (textFormatter.getNumberOfWordsInString(string) > MIN_NUMBER_OF_WORDS_IN_STRING
                    && textFormatter.getNumberOfWordsInString(string) < MAX_NUMBER_OF_WORDS_IN_STRING
                    || textFormatter.checkPalindromeWordInString(string)) {
                System.out.println(string);
            }
        }
        System.out.println("Task 5:");
        String[] strTask5 = {"string", "code", "Practice", "odd", "", "testing"};
        ArrayList<String> stringsOfMiddleChar = new ArrayList<>();
        for (String strMiddleChar : strTask5) {
            stringsOfMiddleChar.add(textFormatter.getMiddleCharOfWord(strMiddleChar));
        }
        System.out.println(stringsOfMiddleChar);
        System.out.println("Task 7:");
        String strTask7 = "Методы доступа называют ещё аксессорами (от англ. access — доступ), " +
                "или по отдельности — геттерами (англ. get — чтение) and сеттерами (англ. set) — запись)";
        System.out.println(textFormatter.getNumberOfLatinAlphabetWords(strTask7));
    }
}


