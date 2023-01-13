package by.tms.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DateHelperTest {

    @Test
    void getNextTuesdayDate() {
        Assertions.assertEquals(LocalDate.of(2023, 1, 10), DateHelper.getNextTuesdayDate(LocalDate.of(2023, 1, 8)));
        Assertions.assertEquals(LocalDate.of(2023, 2, 14), DateHelper.getNextTuesdayDate(LocalDate.of(2023, 2, 9)));
        Assertions.assertEquals(LocalDate.of(2023, 1, 10), DateHelper.getNextTuesdayDate(LocalDate.of(2023, 1, 9)));
        Assertions.assertNotEquals(LocalDate.of(2023, 1, 17), DateHelper.getNextTuesdayDate(LocalDate.of(2023, 1, 9)));
        Assertions.assertNotEquals(LocalDate.of(2023, 1, 11), DateHelper.getNextTuesdayDate(LocalDate.of(2023, 1, 9)));
        Assertions.assertThrows(NullPointerException.class, () -> DateHelper.getNextTuesdayDate(null));
    }
}