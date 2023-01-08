package by.tms.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonUtilsTest {

    @Test
    void getPostfix() {
        Assertions.assertEquals("к", PersonUtils.getPostfix(1));
        Assertions.assertEquals("ка", PersonUtils.getPostfix(2));
        Assertions.assertEquals("ка", PersonUtils.getPostfix(3));
        Assertions.assertEquals("ка", PersonUtils.getPostfix(4));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(5));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(6));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(7));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(8));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(9));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(9));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(10));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(11));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(12));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(13));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(14));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(15));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(16));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(17));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(18));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(19));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(20));
        Assertions.assertEquals("ков", PersonUtils.getPostfix(0));
    }

    @Test
    void modifyCount() {
        Assertions.assertEquals(1, PersonUtils.modifyCount(21));
        Assertions.assertEquals(1, PersonUtils.modifyCount(121));
        Assertions.assertEquals(1, PersonUtils.modifyCount(1234561));
        Assertions.assertEquals(2, PersonUtils.modifyCount(82));
        Assertions.assertEquals(2, PersonUtils.modifyCount(45454542));
        Assertions.assertEquals(12, PersonUtils.modifyCount(45454512));
        Assertions.assertEquals(16, PersonUtils.modifyCount(87816));
        Assertions.assertEquals(0, PersonUtils.modifyCount(0));
    }
}