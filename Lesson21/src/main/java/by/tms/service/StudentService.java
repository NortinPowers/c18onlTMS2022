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

import static by.tms.utils.CRUDUtils.deleteById;
import static by.tms.utils.CRUDUtils.updateOneParameterById;
import static by.tms.utils.DBUtils.getConnection;

public class StudentService {
    private static final String GET_ALL_STUDENTS_QUERY = "select s.id, s.name, s.surname, s.age, s.course, c.name as city_name, c.info from students s left join cities c on s.city_id = c.id;";
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO students(name, surname, age, city_id, course) VALUES(?, ?, ?, ?, ?);";
    private static final String UPDATE_STUDENT_QUERY = "UPDATE students SET course = ? WHERE id = ?;";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM students WHERE id = ?";

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Integer age = resultSet.getInt("age");
                String course = resultSet.getString("course");
                String cityName = resultSet.getString("city_name");
                String cityInfo = resultSet.getString("info");
                CityService cityService = new CityService();
                City city = new City(cityService.getCityId(cityName), cityName, cityInfo);
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
            String cityName = student.getCity().getName();
            if (cityService.findCityByName(cityName) == null) {
                cityService.addNewCity(new City(cityName));
            }
            statement.setLong(4, cityService.getCityId(cityName));
            statement.setString(5, student.getCourse());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void updateStudent(Long id, String course) {
        updateOneParameterById(id, course, UPDATE_STUDENT_QUERY);
    }

    public void deleteStudent(Long id) {
        deleteById(id, DELETE_STUDENT_QUERY);
    }
}