package com.yash.db.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yash.db.exception.*;
import com.yash.db.model.student;
import com.yash.db.repositry.studentRepo;
import com.yash.db.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private studentRepo studentRepo;
	
	public StudentServiceImpl(studentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public student saveStudent(student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<student> getAllStudent() {
		return studentRepo.findAll();
	}

	@Override
	public student getStudentById(long id) {
//		Optional<student> student = studentRepo.findById(id);
//		if(student.isPresent()) {
//			return student.get();
//		}else {
//			throw new ResourceNotFoundException("student", "Id", id);
//		}
		return studentRepo.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Student", "Id", id));
		
	}

	@Override
	public student updateStudent(student student, long id) {
		
		// we need to check whether student with given id is exist in DB or not
		student existingStudent = studentRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "Id", id)); 
		
        
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setAge(student.getAge());
		existingStudent.setBranch(student.getBranch());
		existingStudent.setCollege(student.getCollege());
		existingStudent.setDOB(student.getDOB());
		existingStudent.setContact(student.getContact());
		
		
		// save existing student to DB
		studentRepo.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(long id) {
		
		// check whether a student exist in a DB or not
		studentRepo.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Student", "Id", id));
		studentRepo.deleteById(id);
	}
	
}