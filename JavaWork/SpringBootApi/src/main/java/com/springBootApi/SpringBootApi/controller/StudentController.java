package com.springBootApi.SpringBootApi.controller;

import com.springBootApi.SpringBootApi.entity.Student;
import com.springBootApi.SpringBootApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @GetMapping("/students")
    public List<Student> fetchStudents(){
        return studentService.fetchStudents();
    }
    @GetMapping("/students/{id}")
    public Student fetchStudentById(@PathVariable("id") long id){
        return studentService.fetchStudentById(id);
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable("id") long id){
        studentService.deleteStudentById(id);
        return "Student Deleted Successfully!!!";
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }


}
