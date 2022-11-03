package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParityResultValueTest {

    @Test
    void getParityValueTest() {
        ParityResultValue testObject = new ParityResultValue();
        Assertions.assertFalse(testObject.getParityValue("5"));
        Assertions.assertTrue(testObject.getParityValue("4"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testObject.getParityValue(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testObject.getParityValue("s"));
    }
}