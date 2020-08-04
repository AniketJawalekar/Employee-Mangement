package com.smarteinc.employeeManagement;

import com.smarteinc.employeeManagement.exception.ApplicationException;
import com.smarteinc.employeeManagement.factory.SessionFactory;

/** 
* Application Starter class
* @author Aniket 
*/
public class AppInitializer {
	
	/**  
	* Start the application flow
	* @param args command line args
	*/
	public static void main(String[] args)
	{
		try
		{
		initializeApp();
		}
		catch(ApplicationException appException)
		{
			System.out.println(appException.getMessage());
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		finally
		{
			closeApp();
		}
	}
	
	/** 
	* Load database configuration,  
    * build database connection factory
	* and store dummy data in 
	* database
	*/
	public static void initializeApp()
	{
		
		SessionFactory.buildEntityFactory();
		DatabaseBuilder builder=new DatabaseBuilder();
		builder.loadDbRecords();
	}
	
	/**  
	* Closes connection factory 
	*/
	public static void closeApp()
	{
		
		SessionFactory.closeEntityFactory();
	}
	
	

}
