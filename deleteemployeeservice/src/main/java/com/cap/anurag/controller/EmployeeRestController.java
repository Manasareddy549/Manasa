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
@CrossOrigin("http://localhost:4981")
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;
	@Autowired
	RestTemplate rest;
@DeleteMapping("/deleteEmp/{empId}")
public void deleteEmp(@PathVariable ("empId") Integer empId)
{
	Employee e=rest.getForObject("http://localhost:2121/bank/findById/"+empId,Employee.class);
	if(e==null){
		System.out.println("no records to delete"+empId);
	}
	else
	empService.deleteEmpById(empId);
}
@DeleteMapping("/delete")
public void deleteAllEmployees(@PathVariable Employee emp)
{
	empService.deleteAllEmployees();
	System.out.println("deleted ");
}

}



