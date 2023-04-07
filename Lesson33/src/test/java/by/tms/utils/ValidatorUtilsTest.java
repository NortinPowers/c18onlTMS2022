package by.tms.utils;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorUtilsTest {

    @Test
    void isAgeVerify() {
        Assertions.assertTrue(ValidatorUtils.isAgeVerify(LocalDate.of(2000, 12, 12)));
        Assertions.assertFalse(ValidatorUtils.isAgeVerify(LocalDate.of(2015, 12, 12)));
    }

    @Test
    void isEmailVerify() {
        Assertions.assertTrue(ValidatorUtils.isEmailVerify("test@gmail.com"));
        Assertions.assertTrue(ValidatorUtils.isEmailVerify("test@yandex.ru"));
        Assertions.assertTrue(ValidatorUtils.isEmailVerify("test11@gmail.com"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify("test@gmail"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify("t est@gmail.com"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify(">test@gmail.com"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify("test-gmail.com"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify("test@ma.com"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify("test@gmail.comcomcom"));
        Assertions.assertFalse(ValidatorUtils.isEmailVerify("testesttesttesttesttest@gmail.com"));
    }

    @Test
    void isNameSurnameVerify() {
        Assertions.assertTrue(ValidatorUtils.isNameSurnameVerify("Jack", "London"));
        Assertions.assertTrue(ValidatorUtils.isNameSurnameVerify("rick", "sanchez"));
        Assertions.assertFalse(ValidatorUtils.isNameSurnameVerify("rick1", "sanchez"));
        Assertions.assertFalse(ValidatorUtils.isNameSurnameVerify("De", "Q"));
        Assertions.assertFalse(ValidatorUtils.isNameSurnameVerify("Deqwertyuiopasdfghjklzxcvbnmqw", "Ken"));
        Assertions.assertFalse(ValidatorUtils.isNameSurnameVerify("Den", "Kenkenkenkenkenkenkenkenkenken"));
    }

    @Test
    void isLoginPasswordVerify() {
        Assertions.assertTrue(ValidatorUtils.isLoginPasswordVerify("Test", "test"));
        Assertions.assertTrue(ValidatorUtils.isLoginPasswordVerify("Test12", "test12"));
        Assertions.assertTrue(ValidatorUtils.isLoginPasswordVerify("1TeSt1", "TEST"));
        Assertions.assertFalse(ValidatorUtils.isLoginPasswordVerify("te", "test"));
        Assertions.assertFalse(ValidatorUtils.isLoginPasswordVerify("test", "te"));
        Assertions.assertFalse(ValidatorUtils.isLoginPasswordVerify("tes t", "test"));
        Assertions.assertFalse(ValidatorUtils.isLoginPasswordVerify("test", "te st"));
        Assertions.assertFalse(ValidatorUtils.isLoginPasswordVerify("test", "testtesttesttesttesttesttesttest"));
        Assertions.assertFalse(ValidatorUtils.isLoginPasswordVerify("testtesttesttesttesttesttesttest", "test"));
    }
}