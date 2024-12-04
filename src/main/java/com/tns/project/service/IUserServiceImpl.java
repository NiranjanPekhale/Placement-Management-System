package com.tns.project.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tns.project.entity.User;
import com.tns.project.repository.IUserRepository;
import com.tns.project.serviceInterface.IUserService;


@Service
public class IUserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repo;
	public IUserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User addNewUser(User user) {
		return repo.save(user);
	}

	@Override
	public User updateUser(User user) {
		try {
			repo.findById(user.getId()).get();
			return repo.save(user);	
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public User login(User user) {
		try {
			return repo.findOneByNameAndTypeAndPassword(user.getName(), user.getType(), user.getPassword()).get();	
		}
		catch(NoSuchElementException e) {
			return null;
		}
	}

	@Override
	public boolean logOut() {
		// TODO Auto-generated method stub
		return false;
	}

}
