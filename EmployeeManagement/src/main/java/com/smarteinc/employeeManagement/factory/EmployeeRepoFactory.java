package com.smarteinc.employeeManagement.factory;

import com.smarteinc.employeeManagement.repository.EmployeeRepository;
import com.smarteinc.employeeManagement.repository.EmployeeRepositoryImpl;

/** 
* Employee repository factory class
* @author Aniket 
*/
public class EmployeeRepoFactory {
	
	private static EmployeeRepository repository;
	
	/** 
	* Create and returns instance of implementation class
	* of EmployeeRepository interface. It will not create new instance 
	* for every method call, single instance is getting reuse
	* @return EmployeeRepository - Implementation class object
	*/
	public static EmployeeRepository getEmployeeRepository()
	{
		if(repository==null)
		{
			repository=new EmployeeRepositoryImpl();
		}
		return repository;
	}
	

}
