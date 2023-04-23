package by.tms.model;

import by.tms.validator.BirthdayConstraint;
import by.tms.validator.ExcludeLogValidation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@NoArgsConstructor
@Data
public class User {

    private Long id;
    //    @NotBlank(groups = {Default.class,ExcludeLogValidation.class}, message = "Enter password")
    @NotBlank(groups = Default.class, message = "Enter password")
//    @Pattern(groups = {Default.class,ExcludeLogValidation.class}, regexp = "[a-zA-Z0-9]{4,30}", message = "Incorrect password")
    @Pattern(groups = Default.class, regexp = "[a-zA-Z0-9]{4,30}", message = "Incorrect password")
    private String password;
    //    @NotBlank(groups = {Default.class,ExcludeLogValidation.class}, message = "Enter login")
    @NotBlank(groups = Default.class, message = "Enter login")
//    @Pattern(groups = {Default.class,ExcludeLogValidation.class}, regexp = "[a-zA-Z0-9]{4,30}", message = "Incorrect login")
    @Pattern(groups = Default.class, regexp = "[a-zA-Z0-9]{4,30}", message = "Incorrect login")
    private String login;
    @NotBlank(groups = ExcludeLogValidation.class, message = "Enter name")
    @Pattern(groups = ExcludeLogValidation.class, regexp = "[A-Za-z]{3,29}", message = "Incorrect name")
    private String name;
    @NotBlank(groups = ExcludeLogValidation.class, message = "Enter surname")
    @Pattern(groups = ExcludeLogValidation.class, regexp = "[A-Za-z]{3,29}", message = "Incorrect surname")
    private String surname;
    @Email(groups = ExcludeLogValidation.class, message = "Incorrect email")
    private String email;
    @BirthdayConstraint(groups = ExcludeLogValidation.class)
    private LocalDate birthday;
}