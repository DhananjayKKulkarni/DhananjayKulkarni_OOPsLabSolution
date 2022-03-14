package com.glearning.pg.model;

public class Employee {
	
	private final String firstName, lastName;
	private String password;
	
	String department;
	
	public Employee(String firstName, String lastName, String department)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.department= department;
	}
	
	
		public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}
	
}
