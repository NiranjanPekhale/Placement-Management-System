package com.tns.project.serviceInterface;

import com.tns.project.entity.College;
import com.tns.project.entity.Placement;

public interface ICollegeService {
	
	
	
	College addCollege(College college);
	College updateCollege(int id,College college);
	College searchCollege(long id);
	boolean deleteCollege(long id);
	boolean schedulePlacement(Placement placement);
	
	

}
