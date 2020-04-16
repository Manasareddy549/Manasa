package com.cap.anurag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cap.anurag.entity.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer>{
		
	}
