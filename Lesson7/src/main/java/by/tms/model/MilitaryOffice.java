package by.tms.model;

import by.tms.utils.Constants;

import java.util.LinkedList;
import java.util.List;

import static by.tms.utils.Constants.MAXIMUM_CONSCRIPTION_AGE;
import static by.tms.utils.Constants.MINIMUM_CONSCRIPTION_AGE;

public class MilitaryOffice {

    private final PersonRegistry personRegistry;

    public MilitaryOffice(PersonRegistry personRegistry) {
        this.personRegistry = personRegistry;
    }

    /**
     * Method returns List of recruits according to the conditions
     */
    public List<Person> getSufferersName() {
        List<Person> sufferersList = new LinkedList<>();
        for (int i = 0; i < personRegistry.getPeople().size(); i++) {
            Person person = personRegistry.getPeople().get(i);
            if (person.getAge() > MINIMUM_CONSCRIPTION_AGE && person.getAge() < MAXIMUM_CONSCRIPTION_AGE && person.getGender().equals(Constants.MEN)) {
                sufferersList.add(person);
            }
        }
        return sufferersList;
    }

    /**
     * Method outputs information about conscripts from the list
     */
    public void getPeopleInfo(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    /**
     * Method returns List of recruits from Minsk
     */
    public List<Person> getSufferersNameFromMinsk() {
        List<Person> sufferersFromMinskList = getSufferersName();
        for (int i = 0; i < getSufferersName().size(); i++) {
            Person person = getSufferersName().get(i);
            if (!person.getAddress().getCity().equalsIgnoreCase("minsk")) {
                sufferersFromMinskList.remove(person);
            }
        }
        return sufferersFromMinskList;
    }

    /**
     * Method returns List of recruits older than 25 and younger than 28
     */
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

    /**
     * Method returns List of recruits with the name Alexander
     */
    public List<Person> getSufferersAmongAleksandrs() {
        List<Person> sufferersAmongAleksandrs = getSufferersName();
        for (int i = 0; i < getSufferersName().size(); i++) {
            Person person = getSufferersName().get(i);
            if (!person.getName().equalsIgnoreCase("aleksandr")) {
                sufferersAmongAleksandrs.remove(person);
            }
        }
        return sufferersAmongAleksandrs;
    }

}
