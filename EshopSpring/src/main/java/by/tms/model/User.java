package by.tms.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

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
}