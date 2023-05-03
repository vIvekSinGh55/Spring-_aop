package com.springcoredemo.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcoredemo.springbootcrud.entity.Employee;
import com.springcoredemo.springbootcrud.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService)
	{
		employeeService = theEmployeeService;
	}
	
//	@GetMapping("/fndAll")
	 @RequestMapping(value = "/fndAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public List<Employee> findAllEmployess()
	{
		return employeeService.findAll();
	}
	
	@DeleteMapping("/emp/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId)
	{
		Employee tempEmployee = employeeService.findById(employeeId);
		
		if(tempEmployee == null)
		{
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	@PostMapping("crt")
	public void createEmp(@RequestBody Employee theEmployee)
	{
		
		this.employeeService.save(theEmployee);
		
	}
	
	
}
