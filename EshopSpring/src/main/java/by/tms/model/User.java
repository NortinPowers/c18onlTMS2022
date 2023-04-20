package by.tms.model;

import by.tms.validator.BirthdayConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@SuperBuilder
@Setter
@NoArgsConstructor
@Data
public class User {

    private Long id;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]{4,30}", message = "Incorrect login")
    private String login;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]{4,30}", message = "Incorrect password")
    private String password;
    @NotBlank
    @Pattern(regexp = "[A-Za-z]{3,29}", message = "Incorrect name")
    private String name;
    @NotBlank
    @Pattern(regexp = "[A-Za-z]{3,29}", message = "Incorrect surname")
    private String surname;
    @Email(message = "Incorrect email")
    private String email;
    @BirthdayConstraint
    private LocalDate birthday;
}