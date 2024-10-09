package com.springBootApi.SpringBootApi.service;

import com.springBootApi.SpringBootApi.entity.Student;
import com.springBootApi.SpringBootApi.exception.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);

    public List<Student> fetchStudents();

    public Student fetchStudentById(long id) throws StudentNotFoundException;

    public void deleteStudentById(long id) throws StudentNotFoundException;

    public Student updateStudent(long id, Student student) throws StudentNotFoundException;
}
