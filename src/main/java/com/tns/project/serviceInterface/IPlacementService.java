package com.tns.project.serviceInterface;

import java.util.List;

import com.tns.project.entity.Placement;

public interface IPlacementService {

	Placement addPlacement(Placement placement);
	Placement updatePlacement(Placement placement);
	Placement searchPlacement(long id);
	boolean cancelPlacement(long id);
	List<Placement> getAllPlacement();
	
}
