package ua.edu.nuos.lecture0411web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.lecture0411web.data.Student;
import ua.edu.nuos.lecture0411web.repository.StudentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void addStudent(String name, Integer age, Double rating) {
        Student student = new Student(name, age, rating);
        studentRepository.save(student);
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    public void updateStudent(int id, String name, Integer age, Double rating) {
        studentRepository.findById(id).ifPresent(student -> {
            student.setName(name);
            student.setAge(age);
            student.setRating(rating);
            studentRepository.save(student);
        });
    }
}
