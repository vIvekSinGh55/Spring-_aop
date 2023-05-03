package com.springcoredemo.springbootcrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
	
	
	
	@Before(value = "execution(* com.springcoredemo.springbootcrud.service.EmployeeService.findAll())")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Before method:" + joinPoint.getSignature().toShortString());

		System.out.println("Creating Employee with name - " + " and id - ");
	}
	
//	@Before(value ="execution(* com.springcoredemo.springbootcrud.service.EmployeeService.save(..))")
//	public Employee saveEmployee() {
//		Employee theEmp = new Employee();	
//		System.out.println("Creating Employee..");
//		return employeeDAO.save(theEmp);
//	}

}
