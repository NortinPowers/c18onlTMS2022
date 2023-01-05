package by.tms;

import by.tms.model.Person;
import by.tms.service.PersonService;
import by.tms.service.PersonServiceAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.utils.Sex.MEN;
import static by.tms.utils.Sex.WOMEN;

public class MainTask5 {
    public static void main(String[] args) {
        List<Person> employees = new ArrayList<>();
        employees.add(new Person("Tom", "Brown", 18, MEN));
        employees.add(new Person("Amanda", "Russell", 22, WOMEN));
        employees.add(new Person("Thomas", "Carter", 20, MEN));
        employees.add(new Person("Christopher", "Clark", 25, MEN));
        employees.add(new Person("Linda", "Obrien", 17, WOMEN));
        PersonServiceAware register = new PersonService(employees);
        Optional<String> selectSurname = register.getSelectedPerson('C');
        if (selectSurname.isPresent()) {
            System.out.println(selectSurname);
        }
        System.out.println();
        System.out.println(register.getEmployeesRostersByFirstLetterOfName());
    }
}