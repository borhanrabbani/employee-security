package com.spring.security.demosecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.security.demosecurity.entity.Employee;
import com.spring.security.demosecurity.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String searchEmployees(@RequestParam("keyword") String keyword, Model theModel) {
	    List<Employee> theEmployees = employeeService.searchEmployees(keyword);
	    theModel.addAttribute("employees", theEmployees);
	    return "employees/list-employees";
	}
	
}
