package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.niit.model.Employee;
import com.niit.repository.EmployeeRepository;
import com.niit.repository.EmployeeRepositoryImpl;

public class TestSkill {
	public static EmployeeRepository empImp;

	@BeforeClass
	public static void init() {
		empImp = new EmployeeRepositoryImpl();

	}
	@Test
public void testdeleteEmployee()
{
		assertEquals(true,empImp.deleteEmployee(12));
	
}
	@Test
  public void  testUpdateEmploye_e(){
Employee emp=new Employee();
emp.setEmployeeId(123);
emp.setAddress("Noida Sector 7");
		emp.setFirstName("Rajani");
		emp.setLastName("Sinha");
		emp.setPassword("Sinha");
		
		
		assertEquals(1,empImp.UpdateEmploye_e(emp));
    }

	/*
	 * @Test public void testGetByEmployeeId() {
	 * assertEquals(true,empImp.getByEmployeeId(12)); }
	 */
	@Test
	public void testValidation() {
		assertEquals(true, empImp.validate(123, "a"));
	}
	@Test
 public void TestGetList()
 {
		assertEquals(true,empImp.getAllEmployees());
 }
	 
 
	
	
}
