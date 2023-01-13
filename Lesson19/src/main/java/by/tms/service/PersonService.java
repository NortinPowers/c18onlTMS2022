package by.tms.service;

import by.tms.model.Person;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static by.tms.utils.PersonUtils.getPostfix;
import static by.tms.utils.PersonUtils.modifyCount;

@ToString
public class PersonService implements PersonServiceAware {
    private final List<Person> person;

    public PersonService(List<Person> person) {
        if (person == null) {
            person = new ArrayList<>();
        }
        this.person = person;
    }

    /**
     * The method Optimal with surnames that start with the specified character
     *
     * @return Optional<String>
     */
    @Override
    public Optional<String> getSelectedPerson(Character firstSurnameLetter) {
        return person.stream()
                .map(Person::getSurname)
                .filter(surname -> surname.charAt(0) == firstSurnameLetter)
                .reduce((left, right) -> left + " " + right);
    }

    /**
     * The method displays the first letter of the last name in a column and next to it the number of employees
     * whose last name begins with this letter.
     *
     * @return String
     */
    @Override
    public String getEmployeesRostersByFirstLetterOfName() {
        Map<Character, Long> personBySurname = person.stream()
                .collect(Collectors.groupingBy(person1 -> person1.getSurname().charAt(0), Collectors.counting()));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Long> item : personBySurname.entrySet()) {
            Long count = item.getValue();
            String postfix = getPostfix(modifyCount(Math.toIntExact(count)));
            result.append("\"").append(item.getKey()).append("\"").append(" ").append(count)
                    .append(" - сотрудни").append(postfix).append("\n");
        }
        return result.toString();
    }
}