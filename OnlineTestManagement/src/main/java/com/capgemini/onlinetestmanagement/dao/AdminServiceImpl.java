package com.capgemini.onlinetestmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetestmanagement.bean.AssignTest;
import com.capgemini.onlinetestmanagement.bean.Test;
import com.capgemini.onlinetestmanagement.exception.RecordNotFoundException;
import com.capgemini.onlinetestmanagement.repository.AdminRepository;
import com.capgemini.onlinetestmanagement.repository.AssignTestRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository repository;
	
	@Autowired
	AssignTestRepository userRepository;

	@Override
	public Optional<Test> getTest(int id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Test> getAllTest() {
		
		List<Test> testList = repository.findAll();
        
        if(testList.size() > 0) {
            return testList;
        } else {
            return new ArrayList<Test>();
        }
		
	}

	@Override
	public Optional<Test> deleteTest(int id) throws RecordNotFoundException{
		
		//Optional<Test> employee = repository.findByTestId(id);
		Optional<Test> test=repository.findById(id);
        
        if(test!=null)
        {
            repository.deleteById(id);
            return test;
        } 
        else 
        {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
		
		
	}

	@Override
	public String saveTest(Test entity) {
		
		Optional<Test> test = repository.findById(entity.getId());

		if(test.isPresent())
		{
            Test newEntity = test.get();
            newEntity.setId(entity.getId());
            newEntity.setTopic(entity.getTopic());
            newEntity.setMarks(entity.getMarks());
            newEntity.setMinMarks(entity.getMinMarks());
            newEntity.setDuration(entity.getDuration());
            newEntity.setStartTime(entity.getStartTime().toString());
            newEntity.setEndTime(entity.getEndTime().toString());
            newEntity.setTopic(entity.getTopic());
 
            newEntity = repository.save(newEntity);
            return "added";
		}
		else
			entity = repository.save(entity);
			return "error";
        
		
	}
	
	@Override
	public AssignTest saveAssignTest(AssignTest assign)
	{
		userRepository.save(assign);
		return assign;
	}

}
