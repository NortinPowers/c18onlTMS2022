package by.tms;

import by.tms.model.Address;
import by.tms.model.MilitaryOffice;
import by.tms.model.Person;
import by.tms.model.PersonRegistry;
import by.tms.utils.Constants;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonRegistry personRegistry = new PersonRegistry();

        personRegistry.getPeople().add(new Person("Ivan", 18, Constants.MEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Sam", 22, Constants.MEN, new Address("Belarus", "Grodno")));
        personRegistry.getPeople().add(new Person("Jack", 27, Constants.MEN, new Address("Belarus", "Grodno")));
        personRegistry.getPeople().add(new Person("Tom", 25, Constants.MEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Liza", 18, Constants.WOMEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Petr", 17, Constants.MEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Aleksandr", 19, Constants.MEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Fedor", 28, Constants.MEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Alex", 26, Constants.MEN, new Address("Belarus", "Minsk")));
        personRegistry.getPeople().add(new Person("Aleksandra", 21, Constants.WOMEN, new Address("Belarus", "Minsk")));

        MilitaryOffice militaryOffice = new MilitaryOffice(personRegistry);

        if (isNotEmptyPersonList(militaryOffice.getSufferersName())) {
            System.out.println("Suitable for military service:");
            militaryOffice.getPeopleInfo(militaryOffice.getSufferersName());
        } else {
            System.out.println("There are no suitable people for military service.");
        }

        System.out.println();

        if (isNotEmptyPersonList(militaryOffice.getSufferersNameFromMinsk())) {
            System.out.println("Suitable for military service from Minsk:");
            militaryOffice.getPeopleInfo(militaryOffice.getSufferersNameFromMinsk());
        } else {
            System.out.println("There are no suitable people for military service from Minsk.");
        }

        System.out.println();

        if (isNotEmptyPersonList(militaryOffice.getElderlySufferersName())) {
            System.out.println("Suitable for military service at the age of 25 to 28 years:");
            militaryOffice.getPeopleInfo(militaryOffice.getElderlySufferersName());
        } else {
            System.out.println("There are no suitable people for military service at the age of 25 to 28 years.");
        }

        System.out.println();

        if (isNotEmptyPersonList(militaryOffice.getSufferersAmongAleksandrs())) {
            System.out.println("Aleksandrs suitable for military service :");
            militaryOffice.getPeopleInfo(militaryOffice.getSufferersAmongAleksandrs());
        } else {
            System.out.println("There are no Aleksandrs suitable for military service.");
        }
    }

    /**
     * Method returns TRUE if the list is not empty
     */
    public static boolean isNotEmptyPersonList(List<Person> list) {
        return list.size() > 0;
    }
}