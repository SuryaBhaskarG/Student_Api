package com.example.surya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.surya.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
}