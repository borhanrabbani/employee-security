package com.spring.security.demosecurity.service;

import java.util.List;

import com.spring.security.demosecurity.entity.Employee;


public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee theEmployee);

	void deleteById(int id);
	
	public List<Employee> searchEmployees(String keyword);

}
