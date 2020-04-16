package com.cap.anurag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cap.anurag.entity.Employee;
import com.cap.anurag.service.EmployeeService;

@RestController
@RequestMapping("/bank")
@CrossOrigin("http://localhost:4200")
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;
	@Autowired
	RestTemplate rest;
	@PutMapping("/updateEmp")
	public String updateEmp(@RequestBody Employee emp)
	{
		//Employee e1= empService.updateEmployee(emp);
		Employee e1=rest.getForObject("http://localhost:2121/bank/findById/"+emp.getEid(),Employee.class);
		if(e1!=null)
		{
			e1.setEid(emp.getEid());
			e1.setEname(emp.getEname());
			e1.setEsal(emp.getEsal());
			empService.updateEmployee(e1);
			return "updated successfully!"+emp.getEid()+emp.getEname()+emp.getEsal();
		}
		else
		{
			return "employee details not updated";
		}
		
	}
}



