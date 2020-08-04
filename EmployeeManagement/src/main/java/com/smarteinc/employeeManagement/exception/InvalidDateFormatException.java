package com.smarteinc.employeeManagement.exception;

/** 
* Custom exception class
* @author Aniket 
*/
public class InvalidDateFormatException extends ApplicationException {
 
	private static final long serialVersionUID=1l;
	
	private static final String msg=" is not a valid date, it must be in dd-mm-yyyy format";
	
	public InvalidDateFormatException(String invalidDate)
	{
		super(invalidDate+" "+msg);
	}
}
