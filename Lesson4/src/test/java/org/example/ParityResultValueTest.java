package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParityResultValueTest {

    @Test
    void isParityValueTest() {
        ParityResultValue testObject = new ParityResultValue();
        Assertions.assertFalse(testObject.isParityValue("5"));
        Assertions.assertTrue(testObject.isParityValue("4"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testObject.isParityValue(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testObject.isParityValue("s"));
    }

    @Test
    void parserTest() {
        Assertions.assertEquals(5, ParityResultValue.parser("5"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> ParityResultValue.parser("s"));
    }
}