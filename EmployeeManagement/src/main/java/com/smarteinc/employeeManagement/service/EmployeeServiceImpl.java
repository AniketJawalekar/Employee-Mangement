package com.smarteinc.employeeManagement.service;

import com.smarteinc.employeeManagement.factory.EmployeeRepoFactory;
import com.smarteinc.employeeManagement.model.EmployeeDTO;
import com.smarteinc.employeeManagement.repository.EmployeeRepository;

/** 
* Employee service implementation class
* @author Aniket 
*/
public class EmployeeServiceImpl implements EmployeeService {
	
	/** 
	* Transfer model class object to repository
	* class for persistence operation
	* @param employeeDTO - Model class object
	* @return boolean 
	*/
	public boolean registerEmployee(EmployeeDTO employeeDTO)
	{
		EmployeeRepository repository=null;
		repository=EmployeeRepoFactory.getEmployeeRepository();	
	    return repository.registerEmployeeDetails(employeeDTO);
		
	}
}
