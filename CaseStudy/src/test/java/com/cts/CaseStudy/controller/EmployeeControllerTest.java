package com.cts.CaseStudy.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cts.CaseStudy.model.Employee;
import com.cts.CaseStudy.service.EmployeeService;

public class EmployeeControllerTest {

	@Mock
	private EmployeeService empService;

	@InjectMocks
	private EmployeeController employeeController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetEmployeeById_ExistingId_ShouldReturnEmployee() throws Exception {
		Integer id = 1;
		Employee employee = new Employee();
		when(empService.getEmployeeById(id)).thenReturn(employee);

		Employee result = employeeController.getEmployeeById(id);

		assertEquals(employee, result);
	}

	@Test(expected = Exception.class)
	public void testGetEmployeeById_NonExistingId_ShouldThrowException() throws Exception {
		Integer id = 1;
		when(empService.getEmployeeById(id)).thenThrow(new Exception("Employee with id " + id + " not found"));

		employeeController.getEmployeeById(id);
	}


	@Test(expected = Exception.class)
	public void testDeleteEmployee_NonExistingId_ShouldThrowException() throws Exception {
		Integer id = 1;
		when(empService.getEmployeeById(id)).thenThrow(new Exception("Employee with id " + id + " not found"));

		employeeController.deleteEmployee(id);
	}

	@Test
	public void testAddEmployee_ShouldReturnSavedEmployee() {
		Employee employee = new Employee();
		when(empService.addEmployee(employee)).thenReturn(employee);

		Employee result = employeeController.addEmployee(employee);

		assertEquals(employee, result);
	}

	@Test
	public void testModifyEmployee_ValidEmployee_ShouldReturnUpdatedEmployee() throws Exception {
		Employee employee = new Employee();
		when(empService.modifyEmployee(employee)).thenReturn(employee);

		Employee result = employeeController.modifyEmployee(employee);

		assertEquals(employee, result);
	}

}
