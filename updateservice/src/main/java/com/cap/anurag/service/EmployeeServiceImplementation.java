package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.anurag.dao.EmployeeDao;
import com.cap.anurag.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
@Autowired
EmployeeDao  empDao;
public  Employee updateEmployee(Employee emp){
	return empDao.save(emp);
	
}
}
