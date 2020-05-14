package com.capgemini.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.login.entity.User;
import com.capgemini.login.service.UserService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(path="/login" ,consumes = "application/json", produces = "application/json")
	public Boolean login(@RequestBody User user)
	{
		return service.login(user);
		
	}
	
	@PostMapping(path="/register" ,consumes = "application/json", produces = "application/json")
	public Boolean register(@RequestBody User user)
	{	System.out.println("Question :"+user.getSecurityQuestion());
		return service.register(user);
		
	}
	
	@PostMapping("/forget")
	public String forget(@RequestBody User user)
	{
		//System.out.println(securityQuestion);
		return service.forget(user);
		//return "forget";
	}
}
