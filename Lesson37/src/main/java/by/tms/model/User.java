package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@ToString
public class User {

    private String name;
    private Phone phone;
}