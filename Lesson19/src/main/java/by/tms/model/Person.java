package by.tms.model;

import by.tms.utils.Sex;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Person {

    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
}