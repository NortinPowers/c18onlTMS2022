package org.example;

public class User {
    String name;
    String surname;
    int age;
    String sex;

    public static String getFullName(User user) {
        return "User full name is " + user.name + " " + user.surname;
    }

    @Deprecated
    public static int IncreaseAge(User user) {
        return ++user.age;
    }

    public static void getUserInfo(User user) {
        System.out.println(getFullName(user) + " (sex: " + user.sex + " age: " + user.age + ")");
    }

    private User(String name) {
        this.name = name;
    }

    private User(String name, String surname) {
        this(name);
        this.surname = surname;
    }

    public User() {
    }

    public User(String name, String surname, int age, String sex) {
        this(name, surname);
        this.age = age;
        this.sex = sex;
    }
}
