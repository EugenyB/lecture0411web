package ua.edu.nuos.lecture0411web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.nuos.lecture0411web.data.Student;
import ua.edu.nuos.lecture0411web.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String students(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/add_student")
    public String addStudent(
            @RequestParam(name = "student_name") String name,
            @RequestParam(name = "student_age") Integer age,
            @RequestParam(name = "student_rating") Double rating) {

        studentService.addStudent(name, age, rating);
        return "redirect:/students";
    }

    @GetMapping("/delete_student")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @PostMapping("/update_student")
    public String updateStudent(
            @RequestParam("student_id") int id,
            @RequestParam("student_name") String name,
            @RequestParam("student_age") Integer age,
            @RequestParam("student_rating") Double rating) {
        studentService.updateStudent(id, name, age, rating);
        return "redirect:/students";
    }
}

