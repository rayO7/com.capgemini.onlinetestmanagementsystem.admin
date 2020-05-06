package com.capgemini.onlinetestmanagement.dao;

import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetestmanagement.bean.AssignTest;
import com.capgemini.onlinetestmanagement.bean.Test;
import com.capgemini.onlinetestmanagement.exception.RecordNotFoundException;

public interface AdminService  {
	
	public Optional<Test> getTest(int id);
	
	public List<Test> getAllTest();
	
	public Optional<Test> deleteTest(int id) throws RecordNotFoundException;
	
	public String saveTest(Test test);
	
	public AssignTest saveAssignTest(AssignTest assign);

}
