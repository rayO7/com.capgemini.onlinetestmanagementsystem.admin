package com.capgemini.login.service;

import com.capgemini.login.dao.UserReposotory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.login.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    UserReposotory repository;

	@Override
	public boolean login(User user) {
		User u= repository.findByUserId(user.getUserId());
		if(u==null)
			return false;
		else
		{
			if(u.getUserId().equals(user.getUserId()) && u.getPassword().equals(user.getPassword()))
			return true;
			return false;
		}
	}

	@Override
	public boolean register(User user) {
		if(repository.findByUserId(user.getUserId())==null)
		{
		repository.save(user);
		return true;
		}
		else
		return false;
	}

	@Override
	public String forget(User user) {
		User u=repository.findByUserId(user.getUserId());
		
		if(u.getSecurityQuestion().equals(user.getSecurityQuestion()))
		{
			System.out.println("Password :"+u.getPassword());
		return u.getPassword();
		}
		return null;
	}

}
