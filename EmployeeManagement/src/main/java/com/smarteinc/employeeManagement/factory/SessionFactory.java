package com.smarteinc.employeeManagement.factory;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.smarteinc.employeeManagement.exception.DatabaseException;

/** 
* Database session factory class
* @author Aniket 
*/
public class SessionFactory {
	
	 private static EntityManagerFactory entityFactory;

	  /** 
	  * Load database configuration and  
	  * builds database connection factory
	  */
	  public static void buildEntityFactory()
	  {
		  try
		  {
			  entityFactory=Persistence.createEntityManagerFactory("employeeManagement"); 
		  }
		  catch(Exception exception)
		  {
			  throw new DatabaseException(exception.getMessage());
		  }
	  }
	 
	 /** 
	 * Retrieve and return database connection object from
	 * database connection factory
	 * @return EntityManager - database connection
	 */
	 public static EntityManager getDbSession()
	 {
		 if(entityFactory==null)
		 {
			 buildEntityFactory();
		 }
		 return entityFactory.createEntityManager();
	 }
	 
	 /** 
	 * Closes current database connection
	 * @param session - EntityManager i.e. connection object
	 */
	 public static void closeDbSession(EntityManager session)
	 {
		 session.close();
	 }
	 
	 /** 
	 * Closes EntityManagerFactory
	 */
	 public static void closeEntityFactory()
	 {
		  try
		  {
			 entityFactory.close();
		  }
		  catch(Exception exception)
		  {
			  throw new DatabaseException(exception.getMessage());
		  }
		 finally
		  {
			 entityFactory=null;
		  }
	 }
}
