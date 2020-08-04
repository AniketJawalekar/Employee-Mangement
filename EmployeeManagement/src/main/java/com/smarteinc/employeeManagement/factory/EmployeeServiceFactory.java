package com.smarteinc.employeeManagement.factory;

import com.smarteinc.employeeManagement.service.EmployeeService;
import com.smarteinc.employeeManagement.service.EmployeeServiceImpl;

/** 
* Employee service factory class
* @author Aniket 
*/
public class EmployeeServiceFactory {
	
	private static EmployeeService service;
	
	/** 
	* Create and returns instance of implementation class
	* of EmployeeService interface. It will not create new instance 
	* for every method call, single instance is getting reuse
	* @return EmployeeService - Implementation class object
	*/
	public static EmployeeService getEmployeeService()
	{
		if(service==null)
		{
			service=new EmployeeServiceImpl();
		}
		return service;
	}
	

}
