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
import com.tns.project.entity.Placement;
import com.tns.project.serviceInterface.IPlacementService;

@RestController("placement")
@CrossOrigin("http://localhost:3000")
public class PlacementController {

	@Autowired
	IPlacementService service;
	
	
	public PlacementController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@GetMapping("/placement")
	public ResponseEntity<?> getAllPlacement()
	{
	
		
		System.out.println("this is placement getAll");
		List<Placement> c=service.getAllPlacement();
		System.out.println("this is placement getAll:"+c);
		if(c!=null) {
			
			return  new ResponseEntity<List<Placement>>(c, HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>("No Placement Available", HttpStatus.OK);
		}
		
		
	}

	
	

	@GetMapping("/placement/{id}")
	public ResponseEntity<Placement>  searchCollege(@PathVariable int id)
	{
	
		Placement c=service.searchPlacement(id);
		if(c!=null) {
			
			return new ResponseEntity<Placement>(c, HttpStatus.OK);
		}
		else {

			return new ResponseEntity<Placement>( HttpStatus.NOT_FOUND);
		}
		
		
	}
	@PostMapping("/placement")
	public ResponseEntity<?> addCollege( @RequestBody Placement placement)
	{
		
		Placement c=service.addPlacement(placement);
		if(c!=null) {
			
			return new ResponseEntity<>("Placement Scheduled", HttpStatus.OK);
		}
		else {

			return new ResponseEntity<>( "Placement Not Scheduled",HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/placement/{id}")
	public ResponseEntity<Placement> deleteCollege(@PathVariable("id")int id)
	{
		
		boolean c=service.cancelPlacement(id);
		if(c) {
			
			return new ResponseEntity<Placement>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Placement>( HttpStatus.NO_CONTENT);
		}

	}
	 
	@PutMapping("/placement/{id}")
	public ResponseEntity<Placement> updateCollege(@PathVariable("id")int id,@RequestBody Placement placement)
	{
		
		Placement c=service.updatePlacement(placement);
		if(c!=null) {
			
			return new ResponseEntity<Placement>( HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<Placement>( HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	
}
