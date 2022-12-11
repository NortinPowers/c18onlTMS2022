package by.tms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTask2Test {

    @Test
    void checkAuthorization() {
        Assertions.assertFalse(MainTask2.checkAuthorization("Б", "1", "1"));
        Assertions.assertFalse(MainTask2.checkAuthorization("+", "1", "1"));
        Assertions.assertFalse(MainTask2.checkAuthorization("G", "+", "+"));
        Assertions.assertFalse(MainTask2.checkAuthorization("G", "A", "B"));
        Assertions.assertTrue(MainTask2.checkAuthorization("G", "A1", "A1"));
        Assertions.assertTrue(MainTask2.checkAuthorization("G", "A", "A"));
        Assertions.assertTrue(MainTask2.checkAuthorization("G_1", "A", "A"));
        Assertions.assertTrue(MainTask2.checkAuthorization("g_1", "A", "A"));
        Assertions.assertTrue(MainTask2.checkAuthorization("gg_1", "A", "A"));
        Assertions.assertTrue(MainTask2.checkAuthorization("gg_1", "aa", "aa"));
    }
}