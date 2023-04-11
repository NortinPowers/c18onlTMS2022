package by.tms.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

//@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Builder
//@ToString
@Scope("session")
public class UserDto {

    private Long id;
    private String login;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
}