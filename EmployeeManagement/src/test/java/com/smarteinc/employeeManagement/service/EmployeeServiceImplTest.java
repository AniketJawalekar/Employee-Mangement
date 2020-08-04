package com.smarteinc.employeeManagement.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.smarteinc.employeeManagement.AppInitializer;
import com.smarteinc.employeeManagement.factory.EmployeeServiceFactory;
import com.smarteinc.employeeManagement.model.EmployeeDTO;

public class EmployeeServiceImplTest {

	@Test
	public void testRegisterEmployee() {
		AppInitializer.initializeApp();//load dummy data and initialize the session factory
		boolean expectedResult=true;
		EmployeeService service=EmployeeServiceFactory.getEmployeeService();
		EmployeeDTO employeeDTO=new EmployeeDTO("Ian@smarteinc.com",48,105000,"12-10-2016",2,
				"Mumbai",400008,"Maharashtra","India",2);
		boolean actualResult=service.registerEmployee(employeeDTO);
		AppInitializer.closeApp();//close the session factory
		assertEquals(expectedResult,actualResult);
	}

}
