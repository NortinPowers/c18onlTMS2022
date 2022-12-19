package by.tms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void validate() {
        Assertions.assertTrue(Main.validate("qwerty"));
        Assertions.assertTrue(Main.validate("1235"));
        Assertions.assertTrue(Main.validate("qwvxcbvcxb1235"));
        Assertions.assertFalse(Main.validate(""));
        Assertions.assertFalse(Main.validate("asd6"));
        Assertions.assertFalse(Main.validate("asd"));
        Assertions.assertFalse(Main.validate("qwerQ"));
        Assertions.assertFalse(Main.validate("qwertyuiopasdfghjklxc"));
        Assertions.assertFalse(Main.validate("qwertyю"));
        Assertions.assertFalse(Main.validate("qwerty "));
        Assertions.assertFalse(Main.validate("qwerty,"));
        Assertions.assertFalse(Main.validate("qwerty!"));
        Assertions.assertFalse(Main.validate("Qwerty"));
    }
}