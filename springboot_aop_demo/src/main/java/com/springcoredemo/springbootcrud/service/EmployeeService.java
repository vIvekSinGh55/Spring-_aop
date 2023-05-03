package com.springcoredemo.springbootcrud.service;

import java.util.List;

import com.springcoredemo.springbootcrud.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
}
