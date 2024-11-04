package ua.edu.nuos.lecture0411web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.lecture0411web.data.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}