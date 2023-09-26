package com.example.surya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.surya.repository.StudentRepository;

@SpringBootTest
public class studentServiceTest 
{
	@Autowired
    private StudentService studentService;
	
	
	@MockBean
    private StudentRepository studentRepository;
	
	
}