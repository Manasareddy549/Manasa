package com.cap.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/CreateAccount")
	public String createAccount(@RequestBody Employee emp)
	{
		//RestTemplate restOne=new RestTemplate();
		//Employee e=rest.getForObject("http://localhost:4981/CreateAccount",Employee.class);
		String e1=empService.createEmployee(emp);
		if(e1==null)
		{
			return "Unable to insert";
		}
		else
		{
			return "Employee was inserted successfully";
		}
		
	}
	
}



