package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class Homework2L4Test {


    @Test
    void isPositiveTest() {
        Assertions.assertTrue(Homework2L4.isPositive(2));
        Assertions.assertFalse(Homework2L4.isPositive(0));
    }


    @Test
    void parserIntTest() {
        Assertions.assertEquals(5, Homework2L4.parserInt(new Scanner("5")));
        Assertions.assertThrows(Exception.class, () -> Homework2L4.parserInt(new Scanner("")));
    }

    @Test
    void getIntsArrayTest() {
        Assertions.assertEquals(new int[3].length, Homework2L4.getIntsArray(3).length);
        Assertions.assertThrows(Exception.class, () -> Homework2L4.getIntsArray(-1));
    }

    @Test
    void operation() {
        Assertions.assertEquals(2, Homework2L4.operation(1));
        Assertions.assertEquals(-4, Homework2L4.operation(-2));
        Assertions.assertEquals(10, Homework2L4.operation(0));
    }

    @Test
    void calculateCountOfOddElementsInMatrix() {
        Assertions.assertEquals(2, Homework2L4.calculateCountOfOddElementsInMatrix(new int[]{-1, 0, 3, 4}));
        Assertions.assertEquals(0, Homework2L4.calculateCountOfOddElementsInMatrix(new int[]{}));
    }
}