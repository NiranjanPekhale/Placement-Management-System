
package com.tns.project.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.project.entity.Certificate;
import com.tns.project.entity.College;
import com.tns.project.entity.Student;
import com.tns.project.repository.ICertificateRepository;
import com.tns.project.repository.IStudentRepository;
import com.tns.project.serviceInterface.IStudentService;

@Service
public class IStudentServiceImpl implements IStudentService {
	
	@Autowired
	IStudentRepository repo;
	
	
	@Autowired
	ICertificateRepository repoCertificate;

	public IStudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Student addStudent(Student student) {
		
		return repo.save(student);
	}
	public List<Student> getAllStudents()
	{
		try {
			return repo.findAll();				
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Student updateStudent(Student student) {
		try {
			repo.findById(student.getId()).get();
			return repo.save(student);	
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}	

	@Override
	public Student searchStudentById(long id) {
		try {
			return repo.findById(id).get();				
		}
		catch(NoSuchElementException e) {
			return null;
		}

	}

	@Override
	public Student searchStudentByHallticket(long ticketNo) {
		return repo.findByHallTicketNo(ticketNo);
	}

	@Override
	public Boolean addCertificate(Certificate certificate) {
		try {
			repoCertificate.save(certificate);
			return true;				
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateCertificate(Certificate certificate) {
		try {
			repoCertificate.findById(certificate.getId()).get();
			repoCertificate.save(certificate);
			return true;				
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteStudent(long id) {
		try {
			repo.findById(id).get();
			repo.deleteById(id);
			return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
	}

}
