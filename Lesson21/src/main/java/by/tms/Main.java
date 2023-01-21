package by.tms;

import by.tms.model.City;
import by.tms.model.Student;
import by.tms.service.CityService;
import by.tms.service.StudentService;

import static by.tms.utils.DisplayUtils.getEachEntryFromNewLine;

public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityService();
        cityService.addNewCity(new City("Paris", "is the capital and most populous city of France."));
        cityService.addNewCity(new City("Rome"));
        cityService.updateCity(6, "is the capital city of Italy.");
        cityService.deleteCity(4);
        System.out.println(getEachEntryFromNewLine(cityService.getAllCities()));
        System.out.println();
        StudentService studentService = new StudentService();
        studentService.addNewStudent(new Student("Mike", "Turner", 18, new City("Boston"), "20onl"));
        studentService.addNewStudent(new Student("Daniel", "Clark", 26, new City("Lisbon"), "24onl"));
        studentService.updateStudent(3, "19onl");
        studentService.deleteStudent(4);
        System.out.println(getEachEntryFromNewLine(studentService.getAllStudents()));
    }
}