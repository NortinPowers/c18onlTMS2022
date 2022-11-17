package by.tms.model;

import java.util.LinkedList;
import java.util.List;

public class MilitaryOffice {

    private final PersonRegistry personRegistry;

    public MilitaryOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    public List<Person> getSufferersName() {
        List<Person> sufferersList = new LinkedList<>();
        for (int i = 0; i < personRegistry.getPeople().size(); i++) {
            Person person = personRegistry.getPeople().get(i);
            if (person.getAge() > 17 && person.getAge() < 27 && person.getSex().equals("men")) {
                sufferersList.add(person);
            }
        }
        return sufferersList;
    }

    public void getPeopleInfo(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    public List<Person> getSufferersNameFromMinsk() {
        List<Person> sufferersFromMinskList = getSufferersName();
        for (int i = 0; i < getSufferersName().size(); i++) {
            Person person = getSufferersName().get(i);
            if (!person.getAddress().getCity().equals("Minsk")) {
                sufferersFromMinskList.remove(person);
            }
        }
        return sufferersFromMinskList;
    }

    public List<Person> getElderlySufferersName() {
        List<Person> sufferersElderlyList = getSufferersName();
        for (int i = 0; i < getSufferersName().size(); i++) {
            Person person = getSufferersName().get(i);
            if (person.getAge() < 25) {
                sufferersElderlyList.remove(person);
            }
        }
        return sufferersElderlyList;
    }

    public List<Person> getSufferersAmongAleksandrs() {
        List<Person> sufferersAmongAleksandrs = getSufferersName();
        for (int i = 0; i < getSufferersName().size(); i++) {
            Person person = getSufferersName().get(i);
            if (!person.getName().equals("Aleksandr")) {
                sufferersAmongAleksandrs.remove(person);
            }
        }
        return sufferersAmongAleksandrs;
    }


}
