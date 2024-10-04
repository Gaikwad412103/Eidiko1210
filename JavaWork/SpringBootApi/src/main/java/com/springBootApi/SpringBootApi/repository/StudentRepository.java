package com.springBootApi.SpringBootApi.repository;

import com.springBootApi.SpringBootApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
