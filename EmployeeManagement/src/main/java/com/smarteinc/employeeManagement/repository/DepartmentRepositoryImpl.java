package com.smarteinc.employeeManagement.repository;

import com.smarteinc.employeeManagement.dbUtilities.DbHelper;
import com.smarteinc.employeeManagement.domain.Department;
import com.smarteinc.employeeManagement.domain.Region;
import com.smarteinc.employeeManagement.factory.DbHelperFactory;
import com.smarteinc.employeeManagement.model.DepartmentDTO;

/** 
* Department repository implementation class
* @author Aniket 
*/
public class DepartmentRepositoryImpl implements DepartmentRepository{
	
	/** 
	* Retrieve department information from model   
	* class, prepare Department object and perform persistence
	* operation
	* @param departmentDTO model class object
	* @return boolean 
	*/
	public boolean saveDepartment(DepartmentDTO departmentDTO)
	{
		DbHelper helper=null;
		Department department=null;
		helper=DbHelperFactory.getDbHelper();
		Region region=(Region)helper.findEntity(Region.class,new Integer(departmentDTO.getRegion()),true);
		department=new Department(departmentDTO.getDepartmentName(),region);
		return helper.saveEntity(department);
	}

}
