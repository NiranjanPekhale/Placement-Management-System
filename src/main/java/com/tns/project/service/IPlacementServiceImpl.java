package com.tns.project.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.project.entity.College;
import com.tns.project.entity.Placement;
import com.tns.project.repository.IPlacementRepository;
import com.tns.project.serviceInterface.IPlacementService;

@Service
public class IPlacementServiceImpl implements IPlacementService {
	
	@Autowired
	IPlacementRepository repo;

	public IPlacementServiceImpl() {
		
	}

	@Override
	public Placement addPlacement(Placement placement) {
		return repo.save(placement);
	}

	@Override
	public Placement updatePlacement(Placement placement) {
		try {
			repo.findById(placement.getId()).get();
			return repo.save(placement);
		}catch(NoSuchElementException e)
		{
			return null;
			
		}
	}
	public List<Placement> getAllPlacement()
	{
		try {
			return repo.findAll();				
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public Placement searchPlacement(long id) {
		try {
			return repo.findById(id).get();				
		}
		catch(NoSuchElementException e) {
			return null;
		}		
	}

	@Override
	public boolean cancelPlacement(long id) {
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
