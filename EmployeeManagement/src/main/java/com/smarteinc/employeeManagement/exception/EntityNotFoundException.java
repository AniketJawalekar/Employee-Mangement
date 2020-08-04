package com.smarteinc.employeeManagement.exception;

/** 
* Custom exception class
* @author Aniket 
*/

public class EntityNotFoundException extends ApplicationException {

	private static final long serialVersionUID=1l;
	private static final String notFound="Object not found";
	public EntityNotFoundException(String className)
	{
		super(className+" "+notFound);
	}
}
