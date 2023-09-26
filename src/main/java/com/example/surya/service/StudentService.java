package com.example.surya.service;

import java.util.List;
import java.util.Optional;

import com.example.surya.entity.Student;

public interface StudentService 
{
    public List<Student> getAllStudents();
    
    Optional<Student> getStudentById(Long id);
    
   // public Student getStudentById(Long id);
    
    public void createStudent(Student student);
    
    public void updateStudent(Long id, Student student);
    
    public void deleteStudent(Long id);
}
