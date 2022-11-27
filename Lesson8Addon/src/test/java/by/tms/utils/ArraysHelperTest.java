package by.tms.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArraysHelperTest {

    @Test
    void getMaxArrayValue() {
        Assertions.assertEquals(5, ArraysHelper.getMaxArrayValue(new int[]{-1, 0, 5}));
        Assertions.assertEquals(0, ArraysHelper.getMaxArrayValue(new int[]{}));
        Assertions.assertEquals(-1, ArraysHelper.getMaxArrayValue(new int[]{-1, -20, -25}));
    }

    @Test
    void getMinArrayValue() {
        Assertions.assertEquals(-1, ArraysHelper.getMinArrayValue(new int[]{-1, 0, 5}));
        Assertions.assertEquals(0, ArraysHelper.getMinArrayValue(new int[]{}));
        Assertions.assertEquals(-25, ArraysHelper.getMinArrayValue(new int[]{-1, -20, -25}));
    }

    @Test
    void getAverageArrayValue() {
        Assertions.assertEquals(1.3, ArraysHelper.getAverageArrayValue(new int[]{-1, 0, 5}), 0.1);
        Assertions.assertEquals(0, ArraysHelper.getAverageArrayValue(new int[]{}));
        Assertions.assertEquals(-15.3, ArraysHelper.getAverageArrayValue(new int[]{-1, -20, -25}), 0.1);
    }
}