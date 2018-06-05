package com.niit.repository;

import java.util.List;

import com.niit.model.Employee;

public interface EmployeeRepository {

	boolean addEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	int deleteEmployee(int employeeId);
	List<Employee> getAllEmployees();
	//boolean getAllEmployees();
	Employee getByEmployeeId(int employeeId);
	public boolean validate(int id, String password);
	int UpdateEmploye_e(Employee employee);
	
}
