package by.tms.model;

import by.tms.utils.Constants;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String gender;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + gender + '\'' +
                ", address=" + address +
                '}';
    }

    /**
     * Method the method creates a new person from console
     */
    public Person createNewPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter persons name:");
        String name = scanner.nextLine();
        System.out.println("Enter persons age:");
        int age = getAgeFromScanner(scanner);
        scanner = new Scanner(System.in);
        System.out.println("Enter persons gender:");
        String gender = scanner.nextLine().toLowerCase();
        if (!gender.equals(Constants.MEN) && !gender.equals(Constants.WOMEN)) {
            System.out.println("You need to enter the gender of the person correctly (men / women)");
            scanner.nextLine();
        }
        System.out.println("Enter the person's country of residence:");
        String country = scanner.next();
        System.out.println("enter the person's city of residence");
        String city = scanner.next();
        return new Person(name, age, gender, new Address(country, city));
    }

    /**
     * Method checks the entered value of the person's age and returns the age of the person from the console
     */
    public static int getAgeFromScanner(Scanner scanner) {
        int age = -1;
        do {
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
            } else {
                System.out.println("You need to enter the age of the person correctly (0+)");
                scanner.nextLine();
            }
        } while (age < 0);
        return age;
    }
}
