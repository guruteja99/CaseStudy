package com.cts.CaseStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.CaseStudy.model.Employee;
import com.cts.CaseStudy.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) throws Exception {
		try {
			return empService.getEmployeeById(id);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Integer id) throws Exception {
		try {
			empService.getEmployeeById(id);
			empService.deleteEmployeeById(id);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@PostMapping("/postEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}
	
	@PutMapping("/modifyEmployee")
	public Employee modifyEmployee(@RequestBody Employee employee) throws Exception {
		return empService.modifyEmployee(employee);
	}
	
}
