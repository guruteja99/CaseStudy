package com.cts.CaseStudy.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.CaseStudy.model.Employee;
import com.cts.CaseStudy.repo.EmployeeRepo;

public class EmployeeServiceTest {

	@Mock
	private EmployeeRepo empRepo;

	@InjectMocks
	private EmployeeService employeeService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetEmployeeById_ExistingId_ShouldReturnEmployee() throws Exception {
		Integer id = 1;
		Employee employee = new Employee();
		employee.setId(id);
		Optional<Employee> optional = Optional.of(employee);
		when(empRepo.findById(id)).thenReturn(optional);

		Employee result = employeeService.getEmployeeById(id);

		assertEquals(employee, result);
	}

	@Test
	public void testGetEmployeeById_NonExistingId_ShouldThrowException() throws Exception {
		Integer id = 1;
		when(empRepo.findById(id)).thenReturn(Optional.empty());

		assertThrows(Exception.class, () -> employeeService.getEmployeeById(id));
	}

	@Test
	public void testDeleteEmployeeById_ShouldCallDeleteById() {
		Integer id = 1;

		employeeService.deleteEmployeeById(id);

		verify(empRepo, times(1)).deleteById(id);
	}

	@Test
	public void testAddEmployee_ShouldReturnSavedEmployee() {
		Employee employee = new Employee();
		when(empRepo.save(employee)).thenReturn(employee);

		Employee result = employeeService.addEmployee(employee);

		assertEquals(employee, result);
	}

	@Test
	public void testModifyEmployee_ValidIdAndExistingEmployee_ShouldReturnUpdatedEmployee() throws Exception {
		Integer id = 1;
		Employee employee = new Employee();
		employee.setId(id);
		Optional<Employee> optional = Optional.of(employee);
		when(empRepo.findById(id)).thenReturn(optional);
		when(empRepo.save(employee)).thenReturn(employee);

		Employee result = employeeService.modifyEmployee(employee);

		assertEquals(employee, result);
	}

	@Test
	public void testModifyEmployee_ValidIdButNonExistingEmployee_ShouldThrowException() throws Exception {
		Integer id = 1;
		Employee employee = new Employee();
		employee.setId(id);
		when(empRepo.findById(id)).thenReturn(Optional.empty());

		assertThrows(Exception.class, () -> employeeService.modifyEmployee(employee));
	}

	@Test
	public void testModifyEmployee_NullId_ShouldThrowException() {
		Employee employee = new Employee();
		employee.setId(null);

		assertThrows(Exception.class, () -> employeeService.modifyEmployee(employee));
	}

}
