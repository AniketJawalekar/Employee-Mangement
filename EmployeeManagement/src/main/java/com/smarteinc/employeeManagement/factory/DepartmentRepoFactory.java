package com.smarteinc.employeeManagement.factory;

import com.smarteinc.employeeManagement.repository.DepartmentRepository;
import com.smarteinc.employeeManagement.repository.DepartmentRepositoryImpl;

/** 
* Department repository factory class
* @author Aniket 
*/
public class DepartmentRepoFactory {
	
    private static DepartmentRepository repository=null;
	/** 
	* Create and returns instance of implementation class
	* of DepartmentRepository interface. It will not create new instance 
	* for every method call, single instance is getting reuse
	* @return DepartmentRepository - Implementation class object
	*/
	public static DepartmentRepository getDepartmentRepository()
	{
		if(repository==null)
		{
			repository=new DepartmentRepositoryImpl();
		}
		return repository;
	}

}
