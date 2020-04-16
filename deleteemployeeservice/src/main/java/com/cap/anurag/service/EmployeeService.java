package com.cap.anurag.service;

import java.util.List;
import java.util.Optional;

import com.cap.anurag.entity.Employee;

public interface EmployeeService {

		void deleteEmpById(Integer empId);
	
	public void deleteAllEmployees();
}
