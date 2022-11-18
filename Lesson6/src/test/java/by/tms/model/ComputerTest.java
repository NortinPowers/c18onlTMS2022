package by.tms.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {

    static Computer testComputer = new Computer("test", "test", "test", 2);

    @Test
    void isComputerStillWorking() {
        Assertions.assertTrue(testComputer.isComputerStillWorking());
        testComputer.setFullWorkCycle(0);
        Assertions.assertFalse((testComputer.isComputerStillWorking()));
    }

    @Test
    void getFullWorkCycle() {
        testComputer.setFullWorkCycle(1);
        Assertions.assertEquals(1, testComputer.getFullWorkCycle());
    }

    @Test
    void getValidationEnteredValue() {
        Assertions.assertTrue(testComputer.getValidationEnteredValue(0));
        Assertions.assertTrue(testComputer.getValidationEnteredValue(1));
        Assertions.assertFalse(testComputer.getValidationEnteredValue(2));

    }
}