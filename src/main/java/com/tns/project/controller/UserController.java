package com.tns.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tns.project.entity.College;
import com.tns.project.entity.User;
import com.tns.project.serviceInterface.IUserService;

@RestController("user")
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	IUserService service; 
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser( @RequestBody User user)
	{
		System.out.println("this is add user : "+user);
		User c=service.addNewUser(user);
		if(c!=null) {
			
			return new ResponseEntity<User>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id")int id,@RequestBody User user)
	{
		
		User c=service.updateUser(user);
		if(c!=null) {
			
			return new ResponseEntity<User>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<User>( HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user)
	{
	
		User c=service.login(user);
		if(c!=null) {
			System.out.println("this is college object:"+c);
			
			return new ResponseEntity<User>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<>( "NO USER AVAILABLE",HttpStatus.OK);
		}
		
		
	}
	
	
}
