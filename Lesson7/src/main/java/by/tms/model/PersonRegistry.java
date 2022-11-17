package by.tms.model;

import java.util.LinkedList;
import java.util.List;

public final class PersonRegistry {
    private final List<Person> people = new LinkedList<>();

    public List<Person> getPeople() {
        return people;
    }

}
