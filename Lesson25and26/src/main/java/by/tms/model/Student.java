package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private City city;
    private String course;

    public Student(String name, String surname, Integer age, City city, String course) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.course = course;
    }
}