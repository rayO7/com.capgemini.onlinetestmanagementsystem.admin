package com.capgemini.onlinetestmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.bean.AssignTest;

@Repository
public interface AssignTestRepository extends JpaRepository<AssignTest,Integer>{

}
