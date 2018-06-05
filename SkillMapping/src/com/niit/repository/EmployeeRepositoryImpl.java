package com.niit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.database.ConnectionUtility;
import com.niit.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	Employee emp = new Employee();
	List<Employee> em_p = new ArrayList<>();
	int emp_id;

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Connection connect = ConnectionUtility.connection();
		try {
			System.out.println("in employee crud" + connect.getSchema() + "employee" + employee.getAddress());
			PreparedStatement statement = connect.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			statement.setInt(1, employee.getEmployeeId());
			statement.setString(2, employee.getActiv_e());
			statement.setString(3, employee.getLastName());
			statement.setString(4, employee.getAddress());
			statement.setString(5, employee.getPassword());
			statement.setString(6, employee.getActiv_e());
			int result = statement.executeUpdate();
			if (result >= 1)
				return true;
			else
				return false;
		} catch (SQLException ex) {
			return false;
		}

	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteEmployee(int employeeId) {
		int del=0;
		boolean flag=false;
		Connection connect = ConnectionUtility.connection();
		try {
			System.out.println("inside Delete ");
			PreparedStatement statement = connect.prepareStatement("delete from employee where employeeid=?");
              statement.setInt(1,employeeId);
			del = statement.executeUpdate();
			System.out.println("del:----->"+del);
			
				
			
		}catch(Exception e){}
			/*
			 * rs.next();
			 * 
			 * 
			 * System.out.println(rs.getInt(1));
			 * System.out.println(rs.getString(2));
			 * System.out.println(rs.getString(3));
			 * System.out.println(rs.getString(4));
			 */

		return del;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection connect = ConnectionUtility.connection();
		try {
			System.out.println("inside  ");
			PreparedStatement statement = connect.prepareStatement("select * from employee");

			ResultSet rs = statement.executeQuery();

			/*
			 * rs.next();
			 * 
			 * 
			 * System.out.println(rs.getInt(1));
			 * System.out.println(rs.getString(2));
			 * System.out.println(rs.getString(3));
			 * System.out.println(rs.getString(4));
			 */
			while (rs.next()) {
				Employee emp_1 = new Employee();
				emp_1.setEmployeeId(rs.getInt(1));
				emp_1.setFirstName(rs.getString(2));
				emp_1.setLastName(rs.getString(3));
				emp_1.setPassword(rs.getString(4));
				emp_1.setAddress(rs.getString(5));
				emp_1.setActiv_e(rs.getString(6));
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				em_p.add(emp_1);

			}
			System.out.println("inside list employeeId");

			flag = true;

		} catch (Exception e) {
		}
		return em_p;
	}

	@Override
	public Employee getByEmployeeId(int employeeId) {
		boolean flag = false;
		System.out.println("in EmployeeRepository");
		Connection connect = ConnectionUtility.connection();
		try {
			System.out.println("inside  ");
			PreparedStatement statement = connect.prepareStatement("select * from employee where employeeid=?");
			statement.setInt(1, employeeId);

			ResultSet rs = statement.executeQuery();
			rs.next();

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));

			emp.setEmployeeId(rs.getInt(1));
			emp.setFirstName(rs.getString(2));
			emp.setLastName(rs.getString(3));
			emp.setPassword(rs.getString(4));
			emp.setAddress(rs.getString(5));
			emp.setActiv_e(rs.getString(6));
			System.out.println("inside employeeId");
			System.out.println(emp.getFirstName());
			if (rs != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
		}

		return emp;

	}

	public int updateEmploye_e(int empId) {

		Connection connect = ConnectionUtility.connection();
		try {
			/*
			 * int empId=employee.getEmployeeId(); String
			 * empName=employee.getFirstName(); String
			 * empLast=employee.getLastName(); String
			 * empAddress=employee.getAddress(); String empPassword=
			 * employee.getPassword();
			 */
			System.out.println("inside updateEmployee  ");
			PreparedStatement statement = connect.prepareStatement(
					"update employee set firstname=? ,lastname=?,address=?,password=? where employeeid=?");
			statement.setString(1, "Prakash");
			statement.setString(2, "Sinha");
			statement.setString(3, "Noida sec 18");
			statement.setString(4, "sinha");
			// statement.setActiv_e(rs.getString(6));
			statement.setInt(5, empId);
			emp_id = statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
		}
		return emp_id;
	}

	@Override
	public boolean validate(int id, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println("in EmployeeRepository");
		Connection connect = ConnectionUtility.connection();
		try {
			System.out.println("inside  ");
			PreparedStatement statement = connect
					.prepareStatement("select * from employee where employeeid=? and password=?");
			statement.setInt(1, id);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();
			rs.next();

			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));

			if (rs != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
		}
		return flag;
	}

	@Override
	public int UpdateEmploye_e(Employee employee) {
		// TODO Auto-generated method stub
		Connection connect = ConnectionUtility.connection();
		try {
			/*
			 * int empId=employee.getEmployeeId(); String
			 * empName=employee.getFirstName(); String
			 * empLast=employee.getLastName(); String
			 * empAddress=employee.getAddress(); String empPassword=
			 * employee.getPassword();
			 */
			System.out.println("inside updateEmployee  ");
			PreparedStatement statement = connect.prepareStatement(
					"update employee set firstname=? ,lastname=?,address=?,password=? where employeeid=?");
			statement.setString(1,employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getAddress());
			statement.setString(4, employee.getPassword());
			// statement.setActiv_e(rs.getString(6));
			statement.setInt(5,employee.getEmployeeId());
			emp_id = statement.executeUpdate();
			statement.close();
		} catch (Exception e) {
		}
		return emp_id;

	}
}
