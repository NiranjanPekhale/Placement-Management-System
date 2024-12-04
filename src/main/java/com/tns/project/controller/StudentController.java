package com.tns.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.project.entity.College;
import com.tns.project.entity.Student;
import com.tns.project.serviceInterface.IStudentService;

@RestController("student")
@CrossOrigin("http://localhost:3000")
public class StudentController {

	@Autowired
	IStudentService service;
	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student>  searchStudent(@PathVariable int id)
	{
	
		Student c=service.searchStudentById(id);
		if(c!=null) {
			
			return new ResponseEntity<Student>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<Student>( HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	
	@GetMapping("/student")
	public ResponseEntity<?> getAllStudents()
	{
	
		
		System.out.println("this is student getAll");
		List<Student> c=service.getAllStudents();
		System.out.println("this is Student getAll:"+c);
		if(c!=null) {
			
			return  new ResponseEntity<List<Student>>(c, HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>("No Student Available", HttpStatus.OK);
		}
		
		
	}
	
	
	
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent( @RequestBody Student student)
	{
		System.out.println("this is student post method");
		
		Student c=service.addStudent(student);
		if(c!=null) {
			
			return new ResponseEntity<>("Student Added", HttpStatus.OK);
		}
		else {

			return new ResponseEntity<>("Student Not Added", HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id")int id)
	{
		
		boolean c=service.deleteStudent(id);
		if(c) {
			
			return new ResponseEntity<Student>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Student>( HttpStatus.NO_CONTENT);
		}

	}
	 
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id")int id,@RequestBody Student student)
	{
		
		Student c=service.updateStudent(student);
		if(c!=null) {
			
			return new ResponseEntity<Student>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Student>( HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	
	

}


