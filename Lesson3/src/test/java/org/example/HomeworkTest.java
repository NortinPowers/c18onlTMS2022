package org.example;

import junit.framework.TestCase;
import org.junit.Assert;

public class HomeworkTest extends TestCase {

    public void testSumElements() {
        Assert.assertEquals(300, Homework.sum(100, 200));
        Assert.assertEquals(-1, Homework.sum(Integer.MAX_VALUE, 1));
        Assert.assertEquals(-1, Homework.sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Assert.assertEquals(Integer.MAX_VALUE, Homework.sum(Integer.MAX_VALUE - 1, 1));
    }

    public void testMaxElement() {
        Assert.assertEquals(5, Homework.max(4, 5));
        Assert.assertEquals(10, Homework.max(10, 10));
        Assert.assertEquals(349, Homework.max(56, 349));
    }

    public void testAverageArrayValue() {
        Assert.assertEquals(3.0, Homework.average(new int[]{1, 2, 3, 4, 5}), 0.0);
        Assert.assertEquals(1.0, Homework.average(new int[]{0, -2, 3, -1, 5}), 0.0);
        Assert.assertEquals(0.0, Homework.average(new int[]{}), 0.0);
    }

    public void testMaxArrayElement() {
        Assert.assertEquals(10, Homework.max(new int[]{1, 2, 10, 3}));
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                Homework.max(new int[]{})
        );
        Assert.assertEquals(100, Homework.max(new int[]{1, 2, 3, 4, 5, 100, 99}));
    }

    public void testCalculateHypotenuse() {
        Assert.assertEquals(5.0, Homework.calculateHypotenuse(3, 4), 0.0);
        Assert.assertEquals(20.0, Homework.calculateHypotenuse(12, 16), 0.0);
        Assert.assertEquals(4.472, Homework.calculateHypotenuse(4, 2), 0.001);
    }
}