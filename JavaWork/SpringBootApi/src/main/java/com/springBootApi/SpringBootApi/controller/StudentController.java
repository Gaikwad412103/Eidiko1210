package com.springBootApi.SpringBootApi.controller;

import com.springBootApi.SpringBootApi.entity.Student;
import com.springBootApi.SpringBootApi.exception.StudentNotFoundException;
import com.springBootApi.SpringBootApi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
        Student createdStudent=studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Student>> fetchStudents(){
        List<Student> studentList=studentService.fetchStudents();
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> fetchStudentById(@PathVariable("id") long id) throws StudentNotFoundException {
        Student student=studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id) throws StudentNotFoundException {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student Deleted Successfully!!!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @Valid @RequestBody Student student) throws StudentNotFoundException {
        Student updatedStudent=studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }


}
