package com.smarteinc.employeeManagement.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.smarteinc.employeeManagement.dbUtilities.DbHelper;
import com.smarteinc.employeeManagement.domain.Department;
import com.smarteinc.employeeManagement.domain.Employee;
import com.smarteinc.employeeManagement.domain.Status;
import com.smarteinc.employeeManagement.exception.InvalidDateFormatException;
import com.smarteinc.employeeManagement.factory.DbHelperFactory;
import com.smarteinc.employeeManagement.model.EmployeeDTO;

/** 
* Employee repository implementation class
* @author Aniket 
*/
public class EmployeeRepositoryImpl implements EmployeeRepository {

	/** 
	* Retrieve employee information from model  
	* class, prepare Employee object and perform persistence
	* operation
	* @param employeeDTO Model class object
	* @return boolean 
	*/
	public boolean registerEmployeeDetails(EmployeeDTO employeeDTO)
	{
		DbHelper helper=null;
		Employee employee=null;
		SimpleDateFormat format=null;
		Date joiningDate=null;
		helper=DbHelperFactory.getDbHelper();
		try{
		format=new SimpleDateFormat("dd-MM-yyyy");
		format.setLenient(false);
		joiningDate=format.parse(employeeDTO.getJoiningDate());
		}
		catch(Exception ex)
		{
			throw new InvalidDateFormatException(employeeDTO.getJoiningDate());
		}
		Status status=(Status)helper.findEntity(Status.class,new Integer(employeeDTO.getStatus()),true);
		Department department=(Department)helper.findEntity(Department.class,new Integer(employeeDTO.getDepartment()),true);
		employee=new Employee(employeeDTO.getUsername(),"Royal111".hashCode(),employeeDTO.getAge(),employeeDTO.getAnnualCTC(),
				joiningDate,status,employeeDTO.getCity(),employeeDTO.getPinCode(),employeeDTO.getState(),employeeDTO.getCountry(),department);
	    return helper.saveEntity(employee);
	}
}
