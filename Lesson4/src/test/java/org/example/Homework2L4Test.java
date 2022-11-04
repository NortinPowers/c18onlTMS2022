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
    void operationTest() {
        Assertions.assertEquals(2, Homework2L4.operation(1));
        Assertions.assertEquals(-4, Homework2L4.operation(-2));
        Assertions.assertEquals(10, Homework2L4.operation(0));
    }

    @Test
    void calculateCountOfOddElementsInMatrixTest() {
        Assertions.assertEquals(2, Homework2L4.calculateCountOfOddElementsInMatrix(new int[]{-1, 0, 3, 4}));
        Assertions.assertEquals(0, Homework2L4.calculateCountOfOddElementsInMatrix(new int[]{}));
    }

    @Test
    void getPostfixTest() {
        Assertions.assertEquals("", Homework2L4.getPostfix(1));
        Assertions.assertEquals("а", Homework2L4.getPostfix(2));
        Assertions.assertEquals("а", Homework2L4.getPostfix(3));
        Assertions.assertEquals("а", Homework2L4.getPostfix(4));
        Assertions.assertEquals("ов", Homework2L4.getPostfix(5));
        Assertions.assertEquals("ов", Homework2L4.getPostfix(15));
    }

    @Test
    void processingModifyCountTest() {
        Assertions.assertEquals(11, Homework2L4.processingModifyCount(111));
        Assertions.assertEquals(11, Homework2L4.processingModifyCount(-111));
        Assertions.assertEquals(19, Homework2L4.processingModifyCount(319));
        Assertions.assertEquals(1, Homework2L4.processingModifyCount(1121));
    }

    @Test
    void isPrimeNumber() {
        Assertions.assertTrue(Homework2L4.isPrimeNumber(851));
        Assertions.assertTrue(Homework2L4.isPrimeNumber(19));
        Assertions.assertFalse(Homework2L4.isPrimeNumber(4));
    }
}