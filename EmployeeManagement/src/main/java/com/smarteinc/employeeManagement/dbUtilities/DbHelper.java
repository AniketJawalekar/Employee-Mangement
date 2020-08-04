package com.smarteinc.employeeManagement.dbUtilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.smarteinc.employeeManagement.exception.DatabaseException;
import com.smarteinc.employeeManagement.exception.EntityNotFoundException;
import com.smarteinc.employeeManagement.factory.SessionFactory;

/** 
* Helper class for database   
* related operations
* @author Aniket 
*/
public class DbHelper {
	
	/** 
	* Helper class for database   
	* related operations
	*/
	private EntityManager dbSession=null;
	private EntityTransaction transaction=null;
	private boolean isGroupTransaction=false;
	
	/** 
	 * Common method to retrieve database connection   
	 * if not already created
	 */
	public void getConnection()
	{
		 
		 if(dbSession==null)
		 {
			 try
			 {
			 dbSession=SessionFactory.getDbSession();
			 }
			 catch(Exception exception)
			 {
				 throw  new DatabaseException();
			 }
		 }
	}
	
	/** 
	* Common method to begin database transaction  
	* for DML operation
	*/
	public void beginTransaction()
	{
		 
		if(transaction==null)
		{
			try
			{
			transaction=dbSession.getTransaction();
			transaction.begin();
			}
			 catch(Exception exception)
			 {
				 transaction=null;
				 closeConnection();
				 throw new DatabaseException(exception.getMessage());
				   
			 }		
		}
	}
	
	/** 
	* Common method to begin database transaction    
	* for bulk DML operation
	*/
	public void beginGroupTransaction()
	{       
		 
		  getConnection();
		  beginTransaction();
	      isGroupTransaction=true;
	}
	
	/** 
	* Common method to commit transaction if  
	* there is no bulk DML
	* operation
	*/
	public void commitTransaction()
	{
		
		if(isGroupTransaction==false)
		{
			transaction.commit();
			transaction=null;
		}
	}
	
	/** 
	* Common method to commit transaction  
	* related to bulk DML
	* operation
	*/
	public void commitGroupTransaction()
	{
		
		isGroupTransaction=false;
		commitTransaction();
		closeConnection();
	}
	
	/** 
	* common method to rollback database transaction
	*/
	public void rollbackTransaction()
	{
		
		try
		{
		transaction.rollback();
		}
		finally
		{
		transaction=null;
		closeConnection();
		}
	}
	
	/** 
	* Common method to close database connection  
	* if not already closed and
	* no transaction exists
	*/
	public void closeConnection()
	{
		
		if(dbSession!=null && transaction==null)
		{
			try{
			SessionFactory.closeDbSession(dbSession);
			}
			finally
			{
				dbSession=null;	
			}
		}
	}
	
	 /** 
	 * Common method which will Persist domain class 
	 * objects in database
	 * @param bean object of domain class
	 * @return boolean indicating persistence status
	 */
	 public boolean saveEntity(Object bean)
	 {
		 
		 boolean isInserted=false;
		 getConnection(); 
		 beginTransaction();
		 try
		 {
		 dbSession.persist(bean);
		 commitTransaction();
		 isInserted=true;
		 }
		 catch(Exception exception)
		 {
			 rollbackTransaction();
			 throw new DatabaseException(exception.getMessage());
		 }
		 
		 closeConnection();
		 
		 return isInserted;
	 }
	 
	/**
	* Common method to return requested domain
	* class object, if object not found 
	* then raises EntityNotFoundException
	* @param clazz class Class object of requested domain class
	* @param pkey  primary key of domain class
	* @param keepSession indicate not to close the session
	* @return Object  Object of requested domain class
	*/
	public Object findEntity(Class clazz,Integer pkey,boolean keepSession)
	{

		Object entity=null;
		getConnection();
		entity=dbSession.find(clazz,pkey);
		if(keepSession==false)
		{
		closeConnection();
		}
        if(entity==null)
        {
        	throw new EntityNotFoundException(clazz.getName());
        }
		return entity;
	}

}
