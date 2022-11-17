package by.tms;

import by.tms.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class MainTest {

    @Test
    void isNotEmptyPersonList() {
        List<Person> listNotNull = new LinkedList<>(List.of(new Person()));
        List<Person> listNull = new LinkedList<>();
        Assertions.assertFalse(Main.isNotEmptyPersonList(listNull));
        Assertions.assertTrue(Main.isNotEmptyPersonList(listNotNull));
    }
}