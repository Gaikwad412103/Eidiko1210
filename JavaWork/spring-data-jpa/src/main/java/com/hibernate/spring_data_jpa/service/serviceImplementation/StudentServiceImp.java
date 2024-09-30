package com.hibernate.spring_data_jpa.service.serviceImplementation;

import com.hibernate.spring_data_jpa.entity.Student;
import com.hibernate.spring_data_jpa.repository.StudentRepository;
import com.hibernate.spring_data_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Read a student by ID
    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    // Read all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Delete a student by ID
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    // Update an existing student by ID
    public Student updateStudentById(long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update fields with new values
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setCity(student.getCity());
        existingStudent.setMobileNo(student.getMobileNo());

        return studentRepository.save(existingStudent);
    }
}
