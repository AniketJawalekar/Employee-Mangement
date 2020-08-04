package com.smarteinc.employeeManagement.service;
import com.smarteinc.employeeManagement.factory.DepartmentRepoFactory;
import com.smarteinc.employeeManagement.model.DepartmentDTO;
import com.smarteinc.employeeManagement.repository.DepartmentRepository;

/** 
*  Department service implementation class
* @author Aniket 
*/
public class DepartmentServiceImpl implements DepartmentService{
	
	/** 
	* Transfer model class object to repository
	* class for persistence operation
	* @param departmentDTO - Model class object
	* @return boolean 
	*/
	public boolean addDepartmentData(DepartmentDTO departmentDTO)
	{
		DepartmentRepository repository=null;
		repository=DepartmentRepoFactory.getDepartmentRepository();
		return repository.saveDepartment(departmentDTO);
	}

}
