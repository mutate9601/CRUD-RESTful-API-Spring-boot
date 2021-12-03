package com.yash.db.service;

import com.yash.db.model.student;
import java.util.List;
public interface StudentService {
	
 student saveStudent(student student) ;
	List<student> getAllStudent();
student getStudentById(long id);
student updateStudent(student student, long id);
void deleteStudent(long id);

}
