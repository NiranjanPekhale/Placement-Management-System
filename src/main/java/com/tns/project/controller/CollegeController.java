package com.tns.project.controller;

import java.util.List;
import java.util.NoSuchElementException;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.project.entity.College;
import com.tns.project.service.ICollegeServiceImpl;
import com.tns.project.serviceInterface.ICollegeService;

@RestController("college")
@CrossOrigin("http://localhost:3000")
public class CollegeController {
	
	
	@Autowired
	ICollegeServiceImpl service;
	

	@GetMapping("/college/{id}")
	public ResponseEntity<College> searchCollege(@PathVariable("id") int id)
	{
	
		College c=service.searchCollege(id);
		if(c!=null) {
			System.out.println("this is college object:"+c);
			
			return new ResponseEntity<College>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<College>( HttpStatus.OK);
		}
		
		
	}
	
	
	@GetMapping("/college")
	public ResponseEntity<?> getAllCollege()
	{
	
		
		List<College> c=service.getAllCollege();
		if(c!=null) {
			
			return  new ResponseEntity<List<College>>(c, HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>("No College Available", HttpStatus.OK);
		}
		
		
	}
	@PostMapping("/college")
	public ResponseEntity<?> addCollege(@RequestBody College college)
	{
		College c=service.addCollege(college);
		if(c!=null) {
			
			return new ResponseEntity<>("College Added", HttpStatus.OK);
		}
		else {

			return new ResponseEntity<>("College Not Added", HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/college/{id}")
	public ResponseEntity<?> deleteCollege(@PathVariable("id")int id)
	{
		
		boolean c=service.deleteCollege(id);
		if(c) {
			
			return new ResponseEntity<>( "Record Deleted",HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>( "Record Not Deleted ",HttpStatus.OK);
		}

	}
	 
	@PutMapping("/college/{id}")
	public ResponseEntity<?> updateCollege(@PathVariable("id")int id,@RequestBody College college)
	{
		
		College c=service.updateCollege(id, college);
		if(c!=null) {
			
			return new ResponseEntity<>("Collge Updated", HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>( "College Not Found",HttpStatus.OK);
		}
		
	}

	
	
	
	
	

}
