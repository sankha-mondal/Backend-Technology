package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	//  Retrieve Operation:-
	
	public List<Student> findAllStudent() {
		return studentRepository.findAll();
	}
	
	//  Insert Operation:-
	
	public String storeStudent(Student student) {
		boolean result = studentRepository.existsById(student.getId());
			if(result) {
				return "Student didn't store. id must be unique";
			} else {
				studentRepository.save(student);
				return "Student stored successfully";
			}
	}
	
	//  Delete Operation:-
	
	public String deleteStudent(int id) {
		Optional<Student> op =  studentRepository.findById(id);
			if(op.isPresent()) {
					Student s = op.get();
					studentRepository.delete(s);
					return "Student deleted successfully";
			} else {
				return "Student not present";
			}
	}
	
	
	//  Update Operation:-
	
	public String updateStudent(Student student) {
		Optional<Student> op =  studentRepository.findById(student.getId());
			if(op.isPresent()) {
				Student s = op.get();
					s.setName(student.getName());
					studentRepository.saveAndFlush(s);
					return "Student updated successfully";
			} else {
				return "Student not present";
			}
	}
	
	

}
