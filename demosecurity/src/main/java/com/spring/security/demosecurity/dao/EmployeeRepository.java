package com.spring.security.demosecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.security.demosecurity.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e " +
	           "WHERE e.firstName LIKE %:keyword% OR " +
	           "e.lastName LIKE %:keyword% OR " +
	           "e.email LIKE %:keyword%")
	    List<Employee> search(@Param("keyword") String keyword);
}
