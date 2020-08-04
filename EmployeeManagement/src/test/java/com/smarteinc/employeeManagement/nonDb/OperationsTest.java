package com.smarteinc.employeeManagement.nonDb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.smarteinc.employeeManagement.model.EmployeeDTO;

public class OperationsTest {

	@Test
	public void testFindEmployeesGreaterThanAge() {
		int departmentId=1;
		int age=40;
		Operations operations=new Operations();
		List<EmployeeDTO> employeeList=operations.findEmployeesGreaterThanAge(departmentId, age);
		employeeList.stream().forEach(employeeDTO->{
			assertEquals(departmentId,employeeDTO.getDepartment());
			assertTrue(employeeDTO.getAge()>age);
			
			});
		
		
	}
	@Test
	public void testFindActiveEmployeesLessThanAge() {
		int departmentId=1;
		int age=40;
		int status=1;
		Operations operations=new Operations();
		List<EmployeeDTO> employeeList=operations.findActiveEmployeesLessThanAge(departmentId, age);
		employeeList.stream().forEach(employeeDTO->{
			assertEquals(departmentId,employeeDTO.getDepartment());
			assertEquals(status,employeeDTO.getStatus());
			assertTrue(employeeDTO.getAge()<age);
			
			});
	}
	@Test
	public void testFindActiveEmployeesLessThanAgeAndGreaterThanCTC() {
		int departmentId=1;
		int age=40;
		int status=1;
		int salary=200000;
		Operations operations=new Operations();
		List<EmployeeDTO> employeeList=operations.findActiveEmployeesLessThanAgeAndGreaterThanCTC(departmentId, age);
		employeeList.stream().forEach(employeeDTO->{
			assertEquals(departmentId,employeeDTO.getDepartment());
			assertEquals(status,employeeDTO.getStatus());
			assertTrue(employeeDTO.getAge()<age);
			assertTrue(employeeDTO.getAnnualCTC()>salary);
			
			});
	}

}
