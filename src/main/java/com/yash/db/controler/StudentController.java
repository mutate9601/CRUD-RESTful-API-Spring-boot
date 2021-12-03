package com.yash.db.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.db.model.student;
import com.yash.db.service.*;
@RestController
@RequestMapping("/api/students")
public class StudentController {
   
	private StudentService studentService;

	public StudentController(StudentService studentSevice) {
		super();
		this.studentService = studentSevice;
	}
	//Build create REST API
	@PostMapping
	public ResponseEntity<student> saveStudent(@RequestBody student student){
		return new ResponseEntity<student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}


  //Build get all student REST API
	@GetMapping
  public List<student> getAllStudent(){
	  return studentService.getAllStudent();
  }
  
  //build get student by ID REST API
 
  @GetMapping("{id}")
  public ResponseEntity<student> getStudentById(@PathVariable("id") long studentId){
	  return new ResponseEntity<student>(studentService.getStudentById(studentId), HttpStatus.OK); 
  }
  
  //build update student REST API
  @PutMapping("{id}")
  public ResponseEntity<student> updateStudent(@PathVariable("id") long id , @RequestBody student student){
	  return new ResponseEntity<student>(studentService.updateStudent(student, id), HttpStatus.OK);
  }
  
  //build delete student REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
	studentService.deleteStudent(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
  }
}