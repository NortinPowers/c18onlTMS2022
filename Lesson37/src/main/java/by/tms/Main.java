package by.tms;

import by.tms.model.User;
import by.tms.spring.SpringConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConf.class)) {
            User user = context.getBean("user", User.class);
            System.out.println(user.getName());
        }
    }
}