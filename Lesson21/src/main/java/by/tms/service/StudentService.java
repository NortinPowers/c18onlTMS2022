package by.tms.service;

import by.tms.model.City;
import by.tms.model.Student;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.tms.utils.CRUDUtils.deleteById;
import static by.tms.utils.CRUDUtils.updateOneParameterById;
import static by.tms.utils.DBUtils.getConnection;

public class StudentService {
    private static final String GET_ALL_STUDENTS_QUERY = "SELECT * FROM students";
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO students(name, surname, age, city, course) VALUES(?, ?, ?, ?, ?);";
    private static final String UPDATE_STUDENT_QUERY = "UPDATE students SET course = ? WHERE id = ?;";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM students WHERE id = ?";

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Integer age = resultSet.getInt("age");
                String cityName = resultSet.getString("city");
                CityService cityService = new CityService();
                City city = cityService.findCityByName(cityName);
                String course = resultSet.getString("course");
                students.add(new Student(id, name, surname, age, city, course));
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return students;
    }

    public void addNewStudent(@NonNull Student student) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT_QUERY);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            CityService cityService = new CityService();
            Optional<City> optionalCity = cityService.getOptionalCity(student.getCity().getName());
            if (optionalCity.isEmpty()) {
                cityService.addNewCity(new City(student.getCity().getName()));
            }
            statement.setString(4, student.getCity().getName());
            statement.setString(5, student.getCourse());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void updateStudent(Integer id, String course) {
        updateOneParameterById(id, course, UPDATE_STUDENT_QUERY);
    }

    public void deleteStudent(Integer id) {
        deleteById(id, DELETE_STUDENT_QUERY);
    }
}