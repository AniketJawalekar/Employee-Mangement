package com.smarteinc.employeeManagement.service;

import static org.junit.Assert.*;

import org.junit.Test;
import com.smarteinc.employeeManagement.AppInitializer;
import com.smarteinc.employeeManagement.factory.DepartmentServiceFactory;
import com.smarteinc.employeeManagement.model.DepartmentDTO;

public class DepartmentServiceImplTest {

	@Test
	public void testAddDepartmentData() {
		AppInitializer.initializeApp();//load dummy data and initialize the session factory
		boolean expectedResult=true;
		DepartmentService service=DepartmentServiceFactory.getDepartmentService();
		DepartmentDTO departmentDTO=new DepartmentDTO("Finance",1);
		boolean actualResult=service.addDepartmentData(departmentDTO);
		AppInitializer.closeApp(); //close the session factory
		assertEquals(expectedResult,actualResult);
	}

}
