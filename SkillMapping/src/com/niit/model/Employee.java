package com.niit.model;

import java.io.Serializable;

public class Employee implements Serializable{
	private int employeeId;
	private String firstName;
	private String lastName;
	private String address;
	private String password;
	private String activ_e;
public Employee()
{
	
	
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getActiv_e() {
	return activ_e;
}
public void setActiv_e(String activ_e) {
	this.activ_e = activ_e;
}

	}
