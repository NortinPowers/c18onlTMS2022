package by.tms.repository;

import by.tms.model.Student;

import java.util.List;

public interface StudentRepositoryAware {
    List<Student> getStudents();

    void deleteStudent(Long id);

    void addNewStudent(Student student);
}