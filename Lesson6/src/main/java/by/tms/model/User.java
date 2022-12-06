package by.tms.model;

public class User {
    private String name;
    private String surname;
    private int age;
    private String sex;

    public String getFullName() {
        return "User full name is " + this.name + " " + this.surname;
    }

    @Deprecated
    public int increaseAge() {
        return ++this.age;
    }

    public String getUserInfo() {
        return getFullName() + " (sex: " + this.sex + " age: " + this.age + ")";
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String surname) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
