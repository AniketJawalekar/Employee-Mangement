package com.smarteinc.employeeManagement.repository;
import com.smarteinc.employeeManagement.model.DepartmentDTO;

/** 
* Department repository interface
* @author Aniket 
*/
public interface DepartmentRepository {
	
	public boolean saveDepartment(DepartmentDTO departmentDTO);

}
