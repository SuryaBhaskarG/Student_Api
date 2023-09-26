

package com.example.surya.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.surya.Exception.CustomExceptions;
import com.example.surya.entity.Student;
import com.example.surya.service.StudentService;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/students")
public class StudentController
{
	private final StudentService studentService;

	public StudentController(StudentService studentService) 
	{
		this.studentService = studentService;
	}
     
	@GetMapping("/welcome")
	public String welcomeMessage()
	{
	    return "<h1 style=\"color: red;\">Welcome to Spring boot Security</h1>";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/all")
	public List<Student> getAllStudents() 
	{
		return studentService.getAllStudents();
	}

	
//	@GetMapping("/{id}")
//	public Student getStudentById(@PathVariable Long id) 
//	{
//		return studentService.getStudentById(id);
//	}
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	    Optional<Student> student = studentService.getStudentById(id);

	    if (student.isPresent()) {
	        return ResponseEntity.ok(student.get());
	    } else {
	        throw new CustomExceptions.StudentNotFoundException("Student with given id not found!"); // Throw the custom exception with a message
	    }
	}

	
	@PostMapping("/post")
	public void createStudent(@RequestBody Student student)
	{
		studentService.createStudent(student);
	}
	

	@PutMapping("/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student student)
	{
		studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) 
	{
		studentService.deleteStudent(id);
	}
	
	
	
	/*
	 * 
	 * 


@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
}
