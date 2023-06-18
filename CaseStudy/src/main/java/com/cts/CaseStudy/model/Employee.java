package com.cts.CaseStudy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	
	public Employee(String firstName, String lastName, String department, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phoneNo = phoneNo;
	}

	public Integer getId() {
		return id;
	}

	public Employee() {
		super();
	}

	public Employee(Integer id, String firstName, String lastName, String department, String phoneNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.phoneNo = phoneNo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String department;
	
	private String phoneNo;

}
