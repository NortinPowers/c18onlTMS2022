package by.tms.model;

import by.tms.aspect.TestAspectAnnotation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Getter
@ToString
@Setter
public class User {

    private String name;
    private Phone phone;

    public void printName() throws Exception {
        if (name.length() > 3) {
            System.out.println(name);
        } else {
            throw new Exception("the name is shorter than three characters");
        }
    }

    @TestAspectAnnotation
    public void changeName(String name) {
        this.name = name;
        System.out.println("New user name is " + name + "!");
    }
}