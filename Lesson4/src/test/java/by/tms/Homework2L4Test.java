package by.tms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class Homework2L4Test {


    @Test
    void parserIntTest() {
        Assertions.assertEquals(5, Homework2L4.getParserInt(new Scanner("5")));
        Assertions.assertThrows(Exception.class, () -> Homework2L4.getParserInt(new Scanner("")));
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
        Assertions.assertEquals("т", Homework2L4.getPostfix(1));
        Assertions.assertEquals("та", Homework2L4.getPostfix(2));
        Assertions.assertEquals("та", Homework2L4.getPostfix(3));
        Assertions.assertEquals("та", Homework2L4.getPostfix(4));
        Assertions.assertEquals("тов", Homework2L4.getPostfix(5));
        Assertions.assertEquals("тов", Homework2L4.getPostfix(15));
    }

    @Test
    void processingModifyCountTest() {
        Assertions.assertEquals(11, Homework2L4.processingModifyCount(111));
        Assertions.assertEquals(11, Homework2L4.processingModifyCount(-111));
        Assertions.assertEquals(19, Homework2L4.processingModifyCount(319));
        Assertions.assertEquals(1, Homework2L4.processingModifyCount(1121));
    }

    @Test
    void isPrimeTest() {
        Assertions.assertTrue(Homework2L4.isPrime(853));
        Assertions.assertTrue(Homework2L4.isPrime(19));
        Assertions.assertFalse(Homework2L4.isPrime(4));
        Assertions.assertFalse(Homework2L4.isPrime(11 * 19));
        Assertions.assertFalse(Homework2L4.isPrime(11 * 11));
    }

}