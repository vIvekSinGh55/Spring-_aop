package com.springcoredemo.springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcoredemo.springbootcrud.dao.EmployeeDAO;
import com.springcoredemo.springbootcrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
	{
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() 
	{
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		Employee emp = new Employee();
		emp.setFirstName(theEmployee.getFirstName());
		emp.setLastName(theEmployee.getLastName());
		emp.setEmail(theEmployee.getEmail());
		employeeDAO.save(emp);
		System.out.println("Created employee using AOP");
	}

	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
