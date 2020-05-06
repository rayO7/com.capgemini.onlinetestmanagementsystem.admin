package com.capgemini.onlinetestmanagement.bean;

import java.math.BigInteger;
import java.time.LocalDateTime;
//import java.util.Set;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test {
	
	@Id
	@Column(name="TestID")
	private int id;
	
	@Column(name="Topic")
	private String topic;
	
	@Column(name="Total_marks")
	private int marks;
	
	@Column(name="Minimum_marks")
	private int minMarks;
	
	@Column(name="Duration")
	private int duration;
	
	@Column(name="Starting_time")
	private String startTime;
	
	@Column(name="End_time")
	private String endTime;
	
//	Set<Questions> qSet;
//	
//	Questions currentQuestion;
//
//	public Set<Questions> getqSet() {
//		return qSet;
//	}
//
//	public void setqSet(Set<Questions> qSet) {
//		this.qSet = qSet;
//	}
	
	public Test() {}

public Test(int id, String topic, int marks, int minMarks, int duration, String startTime, String endTime) {
	super();
	this.id = id;
	this.topic = topic;
	this.marks = marks;
	this.minMarks = minMarks;
	this.duration = duration;
	this.startTime = startTime;
	this.endTime = endTime;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public int getMarks() {
	return marks;
}

public void setMarks(int marks) {
	this.marks = marks;
}

public int getMinMarks() {
	return minMarks;
}

public void setMinMarks(int minMarks) {
	this.minMarks = minMarks;
}

public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

public String getStartTime() {

	 
	return this.startTime.toString();
}

public void setStartTime(String startTime) {
	
	this.startTime = startTime;
}

public String getEndTime() {
	
	return this.endTime.toString();
}

public void setEndTime(String endTime) {
	
	this.endTime = endTime;
}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
