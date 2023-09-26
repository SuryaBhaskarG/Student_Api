package com.example.surya.Exception;

import com.example.surya.Exception.CustomExceptions.StudentNotFoundException;
import com.example.surya.Exception.CustomExceptions.CourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException() 
    {
        ErrorResponse errorResponse = new ErrorResponse("Student_Not_Found", "Student with given id not found!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    
    
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCourseNotFoundException()
    {
        ErrorResponse errorResponse = new ErrorResponse("Course_Not_Found", "Course not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    
}
