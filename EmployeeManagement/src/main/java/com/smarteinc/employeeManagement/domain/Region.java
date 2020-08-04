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
@Table(name="Region")
public class Region {
	
	@Id
	@Column(name="regionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int regionId;
	
	@Column(name="name")
	private String name;
	
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Region()
	{
		
	}
	public Region(String name)
	{
		this.name=name;
	}
	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ",name=" + name + "]";
	}

}
