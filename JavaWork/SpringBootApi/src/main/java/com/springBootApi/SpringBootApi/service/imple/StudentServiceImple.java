package com.springBootApi.SpringBootApi.service.imple;

import com.springBootApi.SpringBootApi.entity.Student;
import com.springBootApi.SpringBootApi.exception.StudentNotFoundException;
import com.springBootApi.SpringBootApi.repository.StudentRepository;
import com.springBootApi.SpringBootApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImple implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImple(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(long id) throws StudentNotFoundException {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException(id);
        }
        return student.get();
    }

    @Override
    public void deleteStudentById(long id) throws StudentNotFoundException {
        Optional<Student> student=studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(long id, Student student) throws StudentNotFoundException {
        Optional<Student> stud=studentRepository.findById(id);

        if(stud.isEmpty()){
            throw new StudentNotFoundException(id);
        }
        Student student1=stud.get();
        if(Objects.nonNull(student.getFirstName()) && !"".equalsIgnoreCase(student.getFirstName())){
            student1.setFirstName(student.getFirstName());
        }
        if(Objects.nonNull(student.getLastName()) && !"".equalsIgnoreCase(student.getLastName())){
            student1.setLastName(student.getLastName());
        }
        if(Objects.nonNull(student.getCity()) && !"".equalsIgnoreCase(student.getCity())){
            student1.setCity(student.getCity());
        }
        if(Objects.nonNull(student.getMobileNo()) && !"".equalsIgnoreCase(student.getMobileNo())){
            student1.setMobileNo(student.getMobileNo());
        }

        return studentRepository.save(student1);
    }
}
