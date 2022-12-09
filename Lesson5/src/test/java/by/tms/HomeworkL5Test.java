package by.tms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

class HomeworkL5Test {

    @Test
    void giveAmoebasQuantityTest() {
        Assertions.assertEquals(1, HomeworkL5.giveAmoebasQuantity(2));
        Assertions.assertEquals(16, HomeworkL5.giveAmoebasQuantity(13));
        Assertions.assertEquals(32, HomeworkL5.giveAmoebasQuantity(15));

    }

    @Test
    void getParserIntTest() {
        Assertions.assertEquals(5, HomeworkL5.getParserInt(new Scanner("5")));
        Assertions.assertThrows(Exception.class, () -> HomeworkL5.getParserInt(new Scanner("")));
    }

    @Test
    void getInputIntValueTest() {
        Assertions.assertEquals(5, HomeworkL5.getInputIntValue(new Scanner("5")));
        Assertions.assertThrows(Exception.class, () -> HomeworkL5.getInputIntValue(new Scanner("")));
    }

    @Test
    void getStringQualifier() {
        Assertions.assertEquals("positive", HomeworkL5.getStringQualifier(2));
        Assertions.assertEquals("negative", HomeworkL5.getStringQualifier(-2));
        Assertions.assertEquals("a boundary value", HomeworkL5.getStringQualifier(0));

    }

    @Test
    void getDigitCount() {
        Assertions.assertEquals(2, HomeworkL5.getDigitCount(20));
        Assertions.assertEquals(4, HomeworkL5.getDigitCount(1120));
        Assertions.assertEquals(1, HomeworkL5.getDigitCount(-2));
    }

    @Test
    void getDigitCountSecond() {
        Assertions.assertEquals(2, HomeworkL5.getDigitCountSecond(20));
        Assertions.assertEquals(4, HomeworkL5.getDigitCountSecond(1120));
        Assertions.assertEquals(1, HomeworkL5.getDigitCountSecond(-2));
    }

    @Test
    void getStringZodiacSign() {
        Assertions.assertEquals("Sagittarius", HomeworkL5.getStringZodiacSign(new int[]{18, 1}));
        Assertions.assertEquals("Pisces", HomeworkL5.getStringZodiacSign(new int[]{17, 4}));
        Assertions.assertEquals("Taurus", HomeworkL5.getStringZodiacSign(new int[]{15, 5}));
        Assertions.assertEquals("Scorpio", HomeworkL5.getStringZodiacSign(new int[]{24, 11}));
    }

    @Test
    void getIntsDateArray() {
        Assertions.assertArrayEquals(new int[]{5, 10}, HomeworkL5.getIntsDateArray(new Scanner("5.10")));
        Assertions.assertThrows(Exception.class, () -> HomeworkL5.getIntsDateArray(new Scanner("")));
    }

    @Test
    void performAncientMultiplication() {
        Assertions.assertEquals(40, HomeworkL5.performAncientMultiplication(20, 2));
        Assertions.assertEquals(-2, HomeworkL5.performAncientMultiplication(-1, 2));
        Assertions.assertEquals(0, HomeworkL5.performAncientMultiplication(20, 0));
        Assertions.assertEquals(-5, HomeworkL5.performAncientMultiplication(5, -1));
    }

    @Test
    void getMultiplicationResult() {
        Assertions.assertEquals(40, HomeworkL5.getMultiplicationResult(20, 2));
        Assertions.assertEquals(-2, HomeworkL5.getMultiplicationResult(-1, 2));
        Assertions.assertEquals(0, HomeworkL5.getMultiplicationResult(20, 0));
        Assertions.assertEquals(-5, HomeworkL5.getMultiplicationResult(5, -1));
    }

    @Test
    void hasNoRealization() {
        Assertions.assertTrue(HomeworkL5.hasNoRealization("a"));
        Assertions.assertTrue(HomeworkL5.hasNoRealization("b"));
        Assertions.assertTrue(HomeworkL5.hasNoRealization("c"));
        Assertions.assertTrue(HomeworkL5.hasNoRealization("d"));
        Assertions.assertFalse(HomeworkL5.hasNoRealization("y"));
        Assertions.assertFalse(HomeworkL5.hasNoRealization(""));
    }

    @Test
    void convertsToString() {
        Assertions.assertEquals(" *  * ", Utils.convertsToString(new String[]{"*", "*"}));
        Assertions.assertEquals(" 2  2 ", Utils.convertsToString(Arrays.stream(new int[]{2, 2}).boxed().toArray(Integer[]::new)));
    }

    @Test
    void getRequiredInts() {
        Assertions.assertArrayEquals(new int[]{5, 4}, HomeworkL5.getArrayLastMaxElementValueIndex(new int[]{5, 4, 3, 2, 5, 3}));
        Assertions.assertArrayEquals(new int[]{62, 9}, HomeworkL5.getArrayLastMaxElementValueIndex(new int[]{3, 4, 5, 62, 7, 8, 4, -5, 7, 62, 5, 1}));
    }

    @Test
    void getFilledMatrix() {
        Assertions.assertArrayEquals(new int[5][5], HomeworkL5.getFilledMatrix(5, 1));
    }

    @Test
    void getParserInteger() {
        Assertions.assertEquals(5, HomeworkL5.getParserInteger(new Scanner("5")));
        Assertions.assertThrows(Exception.class, () -> HomeworkL5.getParserInteger(new Scanner("")));
    }

    @Test
    void getDiagonalMatrixSum() {
        Assertions.assertEquals(5, HomeworkL5.getDiagonalMatrixSum(new int[][]{{1, 0, 3}, {1, 3, 3}, {1, 0, 1}}));
        Assertions.assertEquals(0, HomeworkL5.getDiagonalMatrixSum(new int[][]{{0, 2}, {1, 0}}));
    }

    @Test
    void isDateValidTest() {
        Assertions.assertTrue(HomeworkL5.isDateValid(new int[]{31, 1}));
        Assertions.assertTrue(HomeworkL5.isDateValid(new int[]{12, 5}));
        Assertions.assertFalse(HomeworkL5.isDateValid(new int[]{30, 0}));
    }
}