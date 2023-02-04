package by.tms.repository;

import by.tms.model.City;
import by.tms.model.Student;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class JDBSStudentsRepository implements StudentRepositoryAware {
    private Connection connection;

    @Override
    public List<Student> getStudents() {
        String query = "select s.id, s.name, s.surname, s.age, s.course, c.id as city_id, c.name as city_name, c.info from students s left join cities c on s.city_id = c.id order by s.id;";
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
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
        String query = "DELETE FROM students WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}