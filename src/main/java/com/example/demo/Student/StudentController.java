package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Student")

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }



    @DeleteMapping("{studentname}")
    public void deleteStudentByName(@PathVariable("studentname") String studentname) {
        studentService.deleteStudent(studentname);
    }

    @PutMapping("{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentid,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        studentService.updateStudent(studentid, name, email);
    }
}
