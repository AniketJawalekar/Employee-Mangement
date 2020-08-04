package com.smarteinc.employeeManagement.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** 
* Domain class
* @author Aniket 
*/

@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@Column(name="departmentId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int departmentId;
	
	@Column(name="departmentName")
	private String departmentName;
	
	@ManyToOne(targetEntity=Region.class)
	@JoinColumn(name="region",referencedColumnName="regionId")
	private Region region;
	

	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", region=" + region+ "]";
	}
	
	public Department()
	{
		
	}
	public Department(String departmentName,Region region)
	{
		this.departmentName=departmentName;
		this.region=region;
	}
	

}
