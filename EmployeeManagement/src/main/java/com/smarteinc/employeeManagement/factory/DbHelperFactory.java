package com.smarteinc.employeeManagement.factory;

import com.smarteinc.employeeManagement.dbUtilities.DbHelper;

/** 
* DbHelper factory class
* @author Aniket 
*/

public class DbHelperFactory {
	
	/** 
	* Returns new instance of DbHelper class
	* for every method call
	* @return DbHelper
	*/
	public static DbHelper getDbHelper()
	{
		return new DbHelper();
		
	}

}
