package com.capgemini.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.login.entity.User;

@Repository
public interface UserReposotory extends JpaRepository<User,String>{
	public User findByUserId(String userId);
	//public User findBySecurityQuestion(String securityQuestion);

}
