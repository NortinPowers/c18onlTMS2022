package by.tms.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
public class User {

    Long id;
    String login;
    String password;
    String name;
    String surname;
    String email;
    LocalDate birthday;

    public User(String login, String password, String name, String surname, String email, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
    }

    public User(String login) {
        this.login = login;
    }
}