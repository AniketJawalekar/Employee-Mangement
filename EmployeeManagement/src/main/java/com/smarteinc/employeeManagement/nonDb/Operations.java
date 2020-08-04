package com.smarteinc.employeeManagement.nonDb;

import java.util.List;
import java.util.stream.Collectors;
import com.smarteinc.employeeManagement.DatabaseBuilder;
import com.smarteinc.employeeManagement.model.EmployeeDTO;

/** 
* Non DB operations class
* @author Aniket 
*/
public class Operations {
	
	DatabaseBuilder builder=null;
	
	/** 
	* It filters list of dummy data and return list of Employee model object from 
	* a department where employee age is greater than the given age
	* @param departmentId input value 
	* @param age input value
	* @return list of model objects which satisfies the filter condition
	*/
	public List<EmployeeDTO> findEmployeesGreaterThanAge(int departmentId,int age)
	{
		builder=new DatabaseBuilder();
		return builder.getEmployees().stream().filter(employeeDTO->
			{
				return (employeeDTO.getDepartment()==departmentId && employeeDTO.getAge()>age);
			}).collect(Collectors.toList());
		
	}
	
	/** 
	* It filters list of dummy data and return list of Employee model object from 
	* a department where employee status is active i.e. 1 and age is less than the given age
	* @param departmentId input value 
	* @param age input value
	* @return list of model objects which satisfies the filter condition
	*/
	public List<EmployeeDTO> findActiveEmployeesLessThanAge(int departmentId,int age)
	{
		builder=new DatabaseBuilder();
		return builder.getEmployees().stream().filter(employeeDTO->
			{
				return (employeeDTO.getDepartment()==departmentId && employeeDTO.getStatus()==1 && employeeDTO.getAge()<age);
			}).collect(Collectors.toList());
		
	}
	
	/** 
	* It filters list of dummy data and return list of Employee model object from 
	* a department where employee status is active i.e. 1 and age is less than the given age
	* and annualCTC greater than 200000
	* @param departmentId input value
	* @param age input value
	* @return list of model objects which satisfies the filter condition
	*/
	public List<EmployeeDTO> findActiveEmployeesLessThanAgeAndGreaterThanCTC(int departmentId,int age)
	{
		builder=new DatabaseBuilder();
		return builder.getEmployees().stream().filter(employeeDTO->
			{
				return (employeeDTO.getDepartment()==departmentId && employeeDTO.getStatus()==1 && employeeDTO.getAge()<age && employeeDTO.getAnnualCTC()>200000);
			}).collect(Collectors.toList());
		
	}

}
