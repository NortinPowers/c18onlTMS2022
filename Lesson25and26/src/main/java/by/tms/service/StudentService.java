package by.tms.service;

import by.tms.model.Student;
import by.tms.repository.StudentRepositoryAware;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentService {

    private StudentRepositoryAware jdbcStudentsRepository;

    public List<Student> getStudents() {
        return jdbcStudentsRepository.getStudents();
    }

    public void deleteStudent(Long id) {
        jdbcStudentsRepository.deleteStudent(id);
    }

    public void addNewStudent(Student student) {
        jdbcStudentsRepository.addNewStudent(student);
    }
}