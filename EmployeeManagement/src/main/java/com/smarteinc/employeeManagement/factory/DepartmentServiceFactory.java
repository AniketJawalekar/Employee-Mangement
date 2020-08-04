package com.smarteinc.employeeManagement.factory;

import com.smarteinc.employeeManagement.service.DepartmentService;
import com.smarteinc.employeeManagement.service.DepartmentServiceImpl;

/** 
* Department service factory class
* @author Aniket 
*/
public class DepartmentServiceFactory {
	
	private static DepartmentService service=null;
	
	/** 
	* Create and returns instance of implementation class
	* of DepartmentService interface. It will not create new instance 
	* for every method call, single instance is getting reuse
	* @return DepartmentService - Implementation class object
	*/
	public static DepartmentService getDepartmentService()
	{
		if(service==null)
		{
			service=new DepartmentServiceImpl();
		}
		return service;
	}

}
