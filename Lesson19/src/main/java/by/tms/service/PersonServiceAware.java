package by.tms.service;

import java.util.Optional;

public interface PersonServiceAware {

    Optional<String> getSelectedPerson(Character firstSurnameLetter);

    String getEmployeesRostersByFirstLetterOfName();
}