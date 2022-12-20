package by.tms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TextFormatterTest {

    @Test
    void isPalindrome() {
        TextFormatter testTextFormatter = new TextFormatter();
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
    }
}