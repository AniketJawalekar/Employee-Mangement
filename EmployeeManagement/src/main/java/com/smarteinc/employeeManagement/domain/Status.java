package com.smarteinc.employeeManagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* Domain class
* @author Aniket 
*/

@Entity
@Table(name="status")
public class Status {
	

	@Id
	@Column(name="statusId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int statusId;
	
	@Column(name="description",unique=true)
	private String description;
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status()
	{
		
	}
	public Status(String description)
	{
		this.description=description;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", description=" + description +"]";
	}
	
	

}
