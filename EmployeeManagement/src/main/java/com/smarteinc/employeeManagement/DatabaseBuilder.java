package com.smarteinc.employeeManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import com.smarteinc.employeeManagement.dbUtilities.DbHelper;
import com.smarteinc.employeeManagement.domain.Region;
import com.smarteinc.employeeManagement.domain.Status;
import com.smarteinc.employeeManagement.factory.DbHelperFactory;
import com.smarteinc.employeeManagement.factory.DepartmentServiceFactory;
import com.smarteinc.employeeManagement.factory.EmployeeServiceFactory;
import com.smarteinc.employeeManagement.model.DepartmentDTO;
import com.smarteinc.employeeManagement.model.EmployeeDTO;
import com.smarteinc.employeeManagement.service.DepartmentService;
import com.smarteinc.employeeManagement.service.EmployeeService;

/** 
* Helper class for database population
* with dummy data
* @author Aniket 
*/

public class DatabaseBuilder {
	
	/** 
	* Populate database with dummy data of  
	* status, region, department and 
	* employee in database
	*/
	public void loadDbRecords()
	{
		
		loadStaticData();
		loadDepartments();
		loadEmployees();
		
	}
	
	/** 
	* Populate database with dummy data of  
	* status and region 
	*/
	public void loadStaticData()
	{
		
		DbHelper helper=DbHelperFactory.getDbHelper();
		helper.beginGroupTransaction();
		persistData(getStatus().stream(),helper);
		persistData(getRegion().stream(),helper);
		helper.commitGroupTransaction();
		System.out.println("Status and Region data inserted successfully");
	}
	
	/** 
	* Populate database with dummy data of  
	* departments
	*/
	public void loadDepartments()
	{ 
		
		DepartmentService service=DepartmentServiceFactory.getDepartmentService();
		getDepartments().stream().forEach(departmentDTO->{
			service.addDepartmentData(departmentDTO);
		});
		System.out.println("Department data inserted successfully");
	}
	
	/** 
	* Populate database with dummy data of  
	* employees in database
	*/
	public void loadEmployees()
	{
		
		EmployeeService service=EmployeeServiceFactory.getEmployeeService();
		getEmployees().stream().forEach(employeeDTO->{
			service.registerEmployee(employeeDTO);
		});
		System.out.println("Employee data inserted successfully");
	}
	
	/** 
	* common method for persistence 
	* of stream of object
	* @param stream stream of domain class object
	* @param helper Database helper class
	*/
	public void persistData(Stream<?> stream,DbHelper helper)
	{
		
		stream.forEach(entity->{
			helper.saveEntity(entity);
		});
	}
	
	/** 
	* Build and return DepartmentDTO objects list 
	* @return list of dummy DepartmentDTO objects
	*/
	public List<DepartmentDTO> getDepartments()
	{
		
		List<DepartmentDTO> departmentList=new ArrayList<DepartmentDTO>();
		Consumer<DepartmentDTO> consumer=departmentDTO->
		{
			departmentList.add(departmentDTO);
	    };
	    
	    consumer.accept(new DepartmentDTO("Sales",1));
	    consumer.accept(new DepartmentDTO("Admin",2));
		
		return departmentList;
		
	}
	
	/** 
	* Build and return EmployeeDTO objects list 
	* @return list of dummy EmployeeDTO objects
	*/
	public List<EmployeeDTO> getEmployees()
	{
		
		List<EmployeeDTO> employeeList=new ArrayList<EmployeeDTO>();
		Consumer<EmployeeDTO> consumer=employee->
		{
			employeeList.add(employee);
	    };
	    for(EmployeeDTO emp:employeeData())
	    {
	    	consumer.accept(emp);	
	    }
		return employeeList;
		
	}
	
	/** 
	* Build and return status objects list 
	* @return  list of dummy Status objects
	*/
	public List<Status> getStatus()
	{
		
		List<Status> statusList=new ArrayList<Status>();	
		Consumer<Status> consumer=status->
		{
			statusList.add(status);
	    };
	    consumer.accept(new Status("ACTIVE"));
	    consumer.accept(new Status("INACTIVE"));
	    
		return statusList;
	}
	
	/** 
	* Build and return region objects list 
	* @return  list of dummy Region objects
	*/
	public List<Region> getRegion()
	{
		
		List<Region> regionList=new ArrayList<Region>();	
		Consumer<Region> consumer=region->
		{
			regionList.add(region);
	    };
	    consumer.accept(new Region("Europe"));
	    consumer.accept(new Region("Asia"));
	    consumer.accept(new Region("Africa"));
	    
		return regionList;
	}

	/** 
	* Build and return EmployeeDTO array 
	* @return array of dummy EmployeeDTO objects
	*/
	public EmployeeDTO[] employeeData()
	{
		
		EmployeeDTO [] employees=new EmployeeDTO[20];
		employees[0]=new EmployeeDTO("Nancy@smarteinc.com",30,600000,"24-10-2013",1,
					"Mumbai",400008,"Maharashtra","India",1);
		   
		employees[1]=new EmployeeDTO("Andrew@smarteinc.com",31,700000,"14-09-2016",1,
				"Mumbai",400008,"Maharashtra","India",2);
		
		employees[2]=new EmployeeDTO("Janet@smarteinc.com",39,800000,"10-12-2010",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[3]= new EmployeeDTO("Margaret@smarteinc.com",45,710000,"08-08-2015",1,
				"Mumbai",400008,"Maharashtra","India",2);
		
		employees[4]=new EmployeeDTO("Steven@smarteinc.com",41,390000,"19-07-2017",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[5]=new EmployeeDTO("Michael@smarteinc.com",30,490000,"19-04-2007",2,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[6]=new EmployeeDTO("Robert@smarteinc.com",30,570000,"24-10-2008",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[7]=new EmployeeDTO("Laura@smarteinc.com",44,550000,"05-10-2003",1,
				"Mumbai",400008,"Maharashtra","India",2);
		
		employees[8]=new EmployeeDTO("Anne@smarteinc.com",50,600000,"03-10-2009",1,
				"Mumbai",400008,"Maharashtra","India",1);
	
		employees[9]=new EmployeeDTO("Adam@smarteinc.com",40,200000,"06-10-2016",1,
				"Mumbai",400008,"Maharashtra","India",2);
		
		employees[10]=new EmployeeDTO("Antonio@smarteinc.com",32,700000,"11-12-2014",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[11]=new EmployeeDTO("Paul@smarteinc.com",25,150000,"12-12-2000",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[12]=new EmployeeDTO("Sophie@smarteinc.com",48,105000,"12-10-2016",2,
				"Mumbai",400008,"Maharashtra","India",2);
		
		employees[13]= new EmployeeDTO("Ben@smarteinc.com",30,100000,"14-10-2016",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[14]=new EmployeeDTO("James@smarteinc.com",40,200000,"24-10-2016",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[15]=new EmployeeDTO("Glen@smarteinc.com",50,307000,"24-10-2016",2,
				"Mumbai",400008,"Maharashtra","India",2);
		
		employees[16]=new EmployeeDTO("Jon@smarteinc.com",35,305000,"24-10-1999",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[17]=new EmployeeDTO("Rob@smarteinc.com",27,400500,"24-10-2004",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[18]=new EmployeeDTO("Erica@smarteinc.com",32,300900,"21-04-1995",1,
				"Mumbai",400008,"Maharashtra","India",1);
		
		employees[19]=new EmployeeDTO("Rachel@smarteinc.com",37,208000,"24-10-1996",1,
				"Mumbai",400008,"Maharashtra","India",2);
		
		return employees;
	}
}
