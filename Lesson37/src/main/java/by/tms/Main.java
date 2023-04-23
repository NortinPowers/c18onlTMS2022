package by.tms;

import by.tms.model.User;
import by.tms.spring.SpringConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConf.class)) {
            User user = context.getBean("user", User.class);
            System.out.println(user);
            try {
                user.printName();
                System.out.println("Set value for Exception");
                user.setName("EX");
                user.printName();
            } catch (Exception e) {
                System.out.println("Exception in main");
            }
            System.out.println("______________TestAspectAnnotation_____________");
            user.changeName("Virgil");
        }
    }
}