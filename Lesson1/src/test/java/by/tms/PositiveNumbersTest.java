package by.tms;

import org.junit.jupiter.api.Assertions;

class PositiveNumbersTest {

    @org.junit.jupiter.api.Test
    void getPositiveNumbers() {
        PositiveNumbers testClass = new PositiveNumbers();
        Assertions.assertEquals(2, testClass.getPositiveNumbers("5 6 -3 e"));
        Assertions.assertEquals(0, testClass.getPositiveNumbers(""));
        Assertions.assertEquals(4, testClass.getPositiveNumbers("1.1 6 2 5,5"));
    }
}