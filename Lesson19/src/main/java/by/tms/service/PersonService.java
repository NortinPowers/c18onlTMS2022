package by.tms.service;

import by.tms.model.Person;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
            String surnameFirstChar = String.valueOf(item.getKey());
            Long count = item.getValue();
            int modifyCount = modifyCount(Math.toIntExact(count));
            String postfix = getPostfix(modifyCount);
            result.append("\"").append(surnameFirstChar).append("\"").append(" ").append(count)
                    .append(" - сотрудни").append(postfix).append("\n");
        }
        return result.toString();
    }

    /**
     * The method generates the necessary postfix
     *
     * @return String
     */
    private static String getPostfix(int count) {
        return switch (count) {
            case 1 -> "к";
            case 2, 3, 4 -> "ка";
            default -> "ков";
        };
    }

    /**
     * The method modify a given count to provide the method getPostfix
     *
     * @return int
     */
    private static int modifyCount(int count) {
        while (count > 100) {
            count = count % 100;
        }
        return count > 20 ? count % 10 : count;
    }
}