package com.tns.project.serviceInterface;

import com.tns.project.entity.User;


public interface IUserService {
	User addNewUser(User user);
	User updateUser(User user);
	User login(User user);
	boolean logOut();
	
	
}
