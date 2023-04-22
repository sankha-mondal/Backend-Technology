package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("students")	// http://localhost:8383/students/
@CrossOrigin			    // Enable cors policies 
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	//  Retrieve Operation:-
	
	// http://localhost:8383/students/findAll
	@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findAllStudent() {
		return studentService.findAllStudent();
	}
	
	//  Insert Operation:-
	
	// http://localhost:8383/students/storeStudent
	@PostMapping(value = "storeStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeStudent(@RequestBody Student student) {
		return studentService.storeStudent(student);
	}
	
	//  Delete Operation:-
	
	//  http://localhost:8383/students/deleteStudent/{id}
	@DeleteMapping(value = "deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		return studentService.deleteStudent(id);
	}
	
	//  Update Operation:-
	
	//  http://localhost:8383/students/updateStudent
	@PutMapping(value = "updateStudent",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

}
