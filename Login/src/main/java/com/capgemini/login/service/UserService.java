package com.capgemini.login.service;

import com.capgemini.login.entity.User;

public interface UserService {
	
	public boolean login(User user);
	public boolean register(User user);
	public String forget(User userId);

}
