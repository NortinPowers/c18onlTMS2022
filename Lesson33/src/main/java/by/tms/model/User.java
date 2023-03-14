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

    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;

    public User(String login) {
        this.login = login;
    }
}