package com.tns.project.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.project.entity.College;
import com.tns.project.entity.Placement;
import com.tns.project.repository.ICollegeRepository;
import com.tns.project.repository.IPlacementRepository;
import com.tns.project.serviceInterface.ICollegeService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ICollegeServiceImpl implements ICollegeService {
	
	
	@Autowired
	ICollegeRepository repo;
	
	@Autowired
	IPlacementRepository repoPlacement;
	

	public ICollegeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public College addCollege(College college) {		
		System.out.println("this is service add method");
		return repo.save(college);
	}

	@Override
	public College updateCollege(int id,College college) {
		try {
			repo.findById((long) id).get();
			return repo.save(college);	
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public College searchCollege(long id) {
		try {
			return repo.findById(id).get();				
		}
		catch(NoSuchElementException e) {
			return null;
		}

	}
	
	public List<College> getAllCollege()
	{
		try {
			return repo.findAll();				
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public boolean deleteCollege(long id) {
		try {
			repo.findById(id).get();
			repo.deleteById(id);
			return true;
		}catch(NoSuchElementException e)
		{
			return false;
		}
		
	}

	@Override
	public boolean schedulePlacement(Placement placement) {
		try {
			repoPlacement.save(placement);
			return true;				
		}
		catch(Exception e) {
			return false;
		}
	}



}
