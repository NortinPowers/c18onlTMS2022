package by.tms.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitsOfMeasurementTest {

    @Test
    void getPowerInKilowatts() {
        Assertions.assertEquals(74, UnitsOfMeasurement.getPowerInKilowatts(100));
        Assertions.assertEquals(18.5, UnitsOfMeasurement.getPowerInKilowatts(25), 0.01);
    }
}