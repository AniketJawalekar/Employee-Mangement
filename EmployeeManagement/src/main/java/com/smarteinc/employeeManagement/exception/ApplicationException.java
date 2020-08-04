package com.smarteinc.employeeManagement.exception;

/** 
* Custom exception class
* @author Aniket 
*/

public class ApplicationException extends RuntimeException {
	private static final long serialVersionUID=1l;
	
	public ApplicationException(String exceptionMsg)
	{
		super(exceptionMsg);
	}
	


}
