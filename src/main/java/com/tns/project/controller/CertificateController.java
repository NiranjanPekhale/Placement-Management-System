package com.tns.project.controller;

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

import com.tns.project.entity.Certificate;
import com.tns.project.entity.College;
import com.tns.project.entity.Student;
import com.tns.project.serviceInterface.ICertificateService;

@RestController("certificate")
@CrossOrigin("http://localhost:3000")
public class CertificateController {
	
	@Autowired
	ICertificateService service;

	public CertificateController() {
		
	}
	
	@GetMapping("/certificate/{id}")
	public ResponseEntity<Certificate>  searchCertificate(@PathVariable int id)
	{
	
		Certificate c=service.SearchCertificate(id);
		if(c!=null) {
			
			return new ResponseEntity<Certificate>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<Certificate>( HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping("/certificate/{id}")
	public Certificate findByYearAndCollege(@PathVariable int id,@RequestBody College college )
	{
		System.out.println("certificate get");
		Certificate c=service.findByYearAndCollege(id,college);
		System.out.println("certificate obj"+c);
		
			
			return c;
		
		
		
	}
	
	
	@PostMapping("/certificate")
	public ResponseEntity<?> addCertificate( @RequestBody Certificate certificate)
	{
		System.out.println("this is certificate post");
		Certificate c=service.addCertificate(certificate);
		if(c!=null) {
			
			return new ResponseEntity<>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<>("Certificate Not Added", HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/certificate/{id}")
	public ResponseEntity<Certificate> deleteCertificate(@PathVariable("id")int id)
	{
		
		Certificate c=service.deleteCertificate(id);
		if(c!=null) {
			
			return new ResponseEntity<Certificate>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Certificate>( HttpStatus.NO_CONTENT);
		}

	}
	 
	@PutMapping("/certificate/{id}")
	public ResponseEntity<Certificate> updateCertificate(@PathVariable("id")int id,@RequestBody Certificate certificate)
	{
		
		Certificate c=service.updateCertificate(certificate);
		if(c!=null) {
			
			return new ResponseEntity<Certificate>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Certificate>( HttpStatus.NOT_MODIFIED);
		}
		
	}


}
