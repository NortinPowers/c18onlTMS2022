package by.tms;

import by.tms.model.City;
import by.tms.model.Student;
import by.tms.service.CityCRUD;
import by.tms.service.StudentCRUD;

import static by.tms.utils.DisplayUtils.getEachEntryFromNewLine;

public class Main {
    public static void main(String[] args) {
        CityCRUD cityCRUD = new CityCRUD();
        cityCRUD.addNewCity(new City("Paris", "is the capital and most populous city of France."));
        cityCRUD.addNewCity(new City("Rome"));
        cityCRUD.updateCity(6, "is the capital city of Italy.");
        cityCRUD.deleteCity(4);
        System.out.println(getEachEntryFromNewLine(cityCRUD.getAllCities()));
        System.out.println();
        StudentCRUD studentCRUD = new StudentCRUD();
        studentCRUD.addNewStudent(new Student("Mike", "Turner", 18, new City("Boston"), "20onl"));
        studentCRUD.addNewStudent(new Student("Daniel", "Clark", 26, new City("Lisbon"), "24onl"));
        studentCRUD.updateStudent(3, "19onl");
        studentCRUD.deleteStudent(4);
        System.out.println(getEachEntryFromNewLine(studentCRUD.getAllStudents()));
    }
}