package com.tns.project.serviceInterface;

import java.util.List;

import com.tns.project.entity.Certificate;
import com.tns.project.entity.Student;

public interface IStudentService {

	Student addStudent(Student student);
	Student updateStudent(Student student );
	Student searchStudentById(long id);
	Student searchStudentByHallticket(long ticketNo);
	Boolean addCertificate(Certificate certificate);
	Boolean updateCertificate(Certificate certificate);
	Boolean deleteStudent(long id);
	List<Student> getAllStudents();

	
	
	
}
