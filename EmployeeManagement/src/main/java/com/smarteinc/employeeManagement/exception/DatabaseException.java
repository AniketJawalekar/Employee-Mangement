package com.smarteinc.employeeManagement.exception;

/** 
* Custom exception class
* @author Aniket 
*/

public class DatabaseException extends ApplicationException
{
	private static final long serialVersionUID=1l;
	private static final String connectionError="Database connection error";
	public DatabaseException()
	{
		super(connectionError);
	}
	
	public DatabaseException(String exceptionMsg)
	{
		super(exceptionMsg);
	}
}

