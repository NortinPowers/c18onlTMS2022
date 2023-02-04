package by.tms.service;

import by.tms.model.Student;
import by.tms.repository.StudentRepositoryAware;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentService {
    private StudentRepositoryAware jdbsStudentsRepository;

    public List<Student> getStudents() {
        return jdbsStudentsRepository.getStudents();
    }

    public void deleteStudent(Long id) {
        jdbsStudentsRepository.deleteStudent(id);
    }

    public void addNewStudent(Student student) {
        jdbsStudentsRepository.addNewStudent(student);
    }
}