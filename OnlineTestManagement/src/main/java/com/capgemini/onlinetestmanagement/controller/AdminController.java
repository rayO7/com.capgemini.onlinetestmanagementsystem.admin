package com.capgemini.onlinetestmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagement.bean.AssignTest;
import com.capgemini.onlinetestmanagement.bean.Test;
import com.capgemini.onlinetestmanagement.dao.AdminService;
import com.capgemini.onlinetestmanagement.exception.RecordNotFoundException;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping(path="/addTest" ,consumes = "application/json", produces = "application/json")
	public String addTest(@RequestBody Test test)
	{
		service.saveTest(test).equals("added");
//		System.out.println(test.getId());
		return "ADDED";
		
	}
	
	@RequestMapping("/delete")
	public Optional<Test> deleteTest(@RequestParam("id") int id) throws RecordNotFoundException
	{
		return service.deleteTest(id);
	}
	
	@RequestMapping("/test")
	public Optional<Test> getTest(@RequestParam("id") int id)
	{
		Optional<Test> previousTest=service.getTest(id);
		try {
			service.deleteTest(id);
		} catch (RecordNotFoundException e) {
			
			e.printStackTrace();
		}
		return previousTest;
	}
	
	@RequestMapping("/update")
	public Test updateTest(@RequestBody Test test) throws RecordNotFoundException
	{
		//Test previousTest=service.getTest(id);
		
		if(service.saveTest(test).equals("added"))
			return test;
		else
			return null;
		
	}
	
	@PostMapping(path="/assign" ,consumes = "application/json", produces = "application/json")
	public AssignTest assignTest(@RequestBody AssignTest assign)
	{
		return service.saveAssignTest(assign);
	}

}
