package com.smarteinc.employeeManagement.repository;

import com.smarteinc.employeeManagement.model.EmployeeDTO;

/** 
* Employee repository interface
* @author Aniket 
*/
public interface EmployeeRepository {

	public boolean registerEmployeeDetails(EmployeeDTO employeeDTO);
}
