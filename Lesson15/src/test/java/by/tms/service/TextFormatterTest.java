package by.tms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextFormatterTest {

    private final TextFormatter testTextFormatter = new TextFormatter();

    @Test
    void isPalindrome() {
        Assertions.assertTrue(testTextFormatter.isPalindrome("дед"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("казак"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("Мадам"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("комок"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("madam"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("civic"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("tenet"));
        Assertions.assertTrue(testTextFormatter.isPalindrome("Solos"));
        Assertions.assertFalse(testTextFormatter.isPalindrome("иван"));
        Assertions.assertFalse(testTextFormatter.isPalindrome("и"));
        Assertions.assertFalse(testTextFormatter.isPalindrome("шалаши"));
        Assertions.assertFalse(testTextFormatter.isPalindrome(""));
        Assertions.assertFalse(testTextFormatter.isPalindrome("home"));
        Assertions.assertFalse(testTextFormatter.isPalindrome("cup"));
        Assertions.assertFalse(testTextFormatter.isPalindrome("f"));
        Assertions.assertFalse(testTextFormatter.isPalindrome("111"));
        Assertions.assertThrows(Exception.class, () -> testTextFormatter.isPalindrome(null));
    }

    @Test
    void getNumberOfWordsInString() {
        Assertions.assertEquals(3, testTextFormatter.getNumberOfWordsInString("Сегодня я расскажу"));
        Assertions.assertEquals(3, testTextFormatter.getNumberOfWordsInString("Сегодня я расскажу    "));
        Assertions.assertEquals(3, testTextFormatter.getNumberOfWordsInString("Сегодня я расскажу."));
        Assertions.assertEquals(2, testTextFormatter.getNumberOfWordsInString("More than"));
        Assertions.assertEquals(2, testTextFormatter.getNumberOfWordsInString("More than    "));
        Assertions.assertEquals(2, testTextFormatter.getNumberOfWordsInString("More than?"));
        Assertions.assertThrows(Exception.class, () -> testTextFormatter.getNumberOfWordsInString(null));
    }

    @Test
    void checkPalindromeWordInString() {
        Assertions.assertTrue(testTextFormatter.checkPalindromeWordInString("Как тебе такое, Дональд Трамп?"));
        Assertions.assertTrue(testTextFormatter.checkPalindromeWordInString("The longest palindromic word in the Oxford English Dictionary – “tattarrattat“"));
        Assertions.assertFalse(testTextFormatter.checkPalindromeWordInString("Метод принимает строку и возвращает кол-во слов в строке."));
        Assertions.assertFalse(testTextFormatter.checkPalindromeWordInString("The Aztec Empire collapsed"));
        Assertions.assertThrows(Exception.class, () -> testTextFormatter.checkPalindromeWordInString(null));
    }

    @Test
    void checkStringLength() {
        Assertions.assertTrue(testTextFormatter.checkStringLength("Как тебе такое, Дональд Трамп?"));
        Assertions.assertTrue(testTextFormatter.checkStringLength("The Aztec Empire collapsed"));
        Assertions.assertFalse(testTextFormatter.checkStringLength("The Aztec Empire has already collapsed"));
        Assertions.assertFalse(testTextFormatter.checkStringLength("Как тебе такое и сякое, Дональд Трамп?"));
        Assertions.assertThrows(Exception.class, () -> testTextFormatter.checkStringLength(null));
    }
}