package by.tms;

public class Main {
    public static void main(String[] args) {
        User person1 = new User();
        System.out.println(person1.getFullName());
        person1.increaseAge();
        System.out.println(person1.getUserInfo());

        System.out.println();

        User person2 = new User("Petr", "Petrov", 18, "men");
        System.out.println(person2.getUserInfo());
        person2.increaseAge();
        System.out.println(person2);
    }
}