package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}