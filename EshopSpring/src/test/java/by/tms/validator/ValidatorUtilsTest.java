package by.tms.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorUtilsTest {

    @Test
    void isPasswordInputVerify() {
        Assertions.assertTrue(ValidatorUtils.isPasswordInputVerify("test12", "test12"));
        Assertions.assertTrue(ValidatorUtils.isPasswordInputVerify("Test", "Test"));
        Assertions.assertFalse(ValidatorUtils.isPasswordInputVerify("test", "notest"));
    }
}