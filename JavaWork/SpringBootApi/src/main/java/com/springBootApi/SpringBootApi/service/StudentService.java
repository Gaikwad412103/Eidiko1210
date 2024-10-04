package com.springBootApi.SpringBootApi.service;

import com.springBootApi.SpringBootApi.entity.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);

    public List<Student> fetchStudents();

    public Student fetchStudentById(long id);

    public void deleteStudentById(long id);

    public Student updateStudent(long id, Student student);
}
