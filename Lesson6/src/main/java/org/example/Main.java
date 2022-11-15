package org.example;

public class Main {
    public static void main(String[] args) {
        User person1 = new User();
        System.out.println(User.getFullName(person1));
        User.IncreaseAge(person1);
        User.getUserInfo(person1);

        User person2 = new User("Petr", "Petrov", 18, "men");
        User.getUserInfo(person2);
        System.out.println(User.IncreaseAge(person2));
    }
}