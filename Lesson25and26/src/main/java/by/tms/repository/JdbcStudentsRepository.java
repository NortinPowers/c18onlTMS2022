package by.tms.repository;

import by.tms.model.City;
import by.tms.model.Student;
import by.tms.service.CityService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JdbcStudentsRepository implements StudentRepositoryAware {

    private Connection connection;
    private static final String GET_ALL_STUDENTS_QUERY = "select s.id, s.name, s.surname, s.age, s.course, c.id as city_id, c.name as city_name, c.info from students s left join cities c on s.city_id = c.id order by s.id;";
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO students(name, surname, age, city_id, course) VALUES(?, ?, ?, ?, ?);";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM students WHERE id = ?";

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                Integer age = resultSet.getInt("age");
                String course = resultSet.getString("course");
                Long cityId = resultSet.getLong("city_id");
                String cityName = resultSet.getString("city_name");
                String cityInfo = resultSet.getString("info");
                students.add(new Student(id, name, surname, age, new City(cityId, cityName, cityInfo), course));
            }
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return students;
    }

    @Override
    public void deleteStudent(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_QUERY);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public void addNewStudent(Student student) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT_QUERY);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            CityService cityService = new CityService(connection);
            String cityName = student.getCity().getName();
            if (cityService.findCityByName(cityName) == null) {
                cityService.addNewCity(new City(cityName));
            }
            statement.setLong(4, cityService.getCityIdByName(cityName));
            statement.setString(5, student.getCourse());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}