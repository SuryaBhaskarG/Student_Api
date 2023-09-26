package com.example.surya.service;

import org.springframework.stereotype.Service;

import com.example.surya.entity.Student;
import com.example.surya.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService 
{
    private final StudentRepository studentRepository;

    
    
   
    public StudentServiceImpl(StudentRepository studentRepository) 
    {
        this.studentRepository = studentRepository;
    }
    

    
    
    @Override
    public List<Student> getAllStudents() 
    {
        return studentRepository.findAll();
    }
    

//    @Override
//    public Student getStudentById(Long id) 
//    {
//        Optional<Student> optionalStudent = studentRepository.findById(id);
//        return optionalStudent.orElse(null);
//    }
//    
    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void createStudent(Student student) 
    {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student updatedStudent)
    {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Long id) 
    {
        studentRepository.deleteById(id);
    }
   
    
    /*
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class StudentService {
        private final StudentRepository studentRepository;

        @Autowired
        public StudentService(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

        public ResponseEntity<List<Student>> getAllStudents() {
            List<Student> students = studentRepository.findAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        public ResponseEntity<Student> getStudentById(Long id) {
            Optional<Student> studentOptional = studentRepository.findById(id);
            if (studentOptional.isPresent()) {
                return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        public ResponseEntity<Void> createStudent(Student student) {
            studentRepository.save(student);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        public ResponseEntity<Void> updateStudent(Long id, Student student) {
            if (studentRepository.existsById(id)) {
                student.setId(id);
                studentRepository.save(student);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        public ResponseEntity<Void> deleteStudent(Long id) {
            if (studentRepository.existsById(id)) {
                studentRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
*/
    
    
    
}
