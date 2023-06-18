package com.cts.CaseStudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.CaseStudy.model.Employee;
import com.cts.CaseStudy.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	
	public Employee getEmployeeById(Integer id) throws Exception {
		
		Optional<Employee> emp = empRepo.findById(id);
		if(emp.isEmpty()) {
			throw new Exception("Employee with id "+id+" not found");
		}
		return emp.get();
	}

	public void deleteEmployeeById(Integer id) {
		empRepo.deleteById(id);
	}

	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	public Employee modifyEmployee(Employee employee) throws Exception {
		if(employee.getId()!=null) {
			try {
				getEmployeeById(employee.getId());
				return empRepo.save(employee);
			}catch(Exception e) {
				throw new Exception(e.getMessage());
			}
		}else {
			throw new Exception("Invalid data");
		}
		
	}
	
	

}
