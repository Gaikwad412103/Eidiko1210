package com.hibernate.spring_data_jpa.service;

import com.hibernate.spring_data_jpa.entity.Student;
import java.util.List;
import java.util.Optional;


public interface StudentService {

    // Create a new student
    public Student createStudent(Student student);

    // Read a student by ID
    public Optional<Student> getStudentById(long id);

    // Read all students
    public List<Student> getAllStudents() ;

    // Delete a student by ID
    public void deleteStudentById(long id) ;

    // Update an existing student by ID
    public Student updateStudentById(long id, Student student);


}
