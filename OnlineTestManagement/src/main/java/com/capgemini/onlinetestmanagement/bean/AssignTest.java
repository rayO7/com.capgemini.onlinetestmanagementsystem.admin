package com.capgemini.onlinetestmanagement.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AssignTest")
public class AssignTest {
	
	@Id
	@Column(name="TestId")
	private int testId;
	
	@Column(name="UserId")
	private int userId;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public AssignTest(int testId, int userId) {
		this.testId = testId;
		this.userId = userId;
	}
	
	public AssignTest() {}
	
	
		
		

}
