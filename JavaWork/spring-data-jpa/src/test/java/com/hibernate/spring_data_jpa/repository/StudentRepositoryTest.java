package com.hibernate.spring_data_jpa.repository;

import com.hibernate.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    void saveStudent(){
        Student student=new Student();
        student.setFirstName("Avinash");
        student.setLastName("Gaikwad");
        student.setCity("Pune");
        student.setMobileNo("7666029365");

        studentRepository.save(student);
    }
    @Test
    void getStudentById(){
        long id=2L;
        Optional<Student> student=studentRepository.findById(id);
        if(student.isEmpty()){
            System.out.println("Student Is Not Exist!!!");
        }else{
            System.out.println(student);
        }
    }
    @Test
    void getAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        studentList.forEach(System.out::println);
    }
    @Test
    void deleteStudentById(){
        long id=1L;
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else{
            System.out.println("Student is not present");
        }
    }
    @Test
    void findByCityTest(){
        List<Student> studentList=studentRepository.findByCity("pune");
        System.out.println(studentList);
    }

}