package com.smarteinc.employeeManagement.model;

import java.io.Serializable;

/** 
* Model class
* @author Aniket 
*/
public class DepartmentDTO implements Serializable {
	
	private static final long serialVersionUID=1l;
	
	private int departmentId;
	private String departmentName;
	private int region;

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
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public DepartmentDTO()
	{
		
	}
	public DepartmentDTO(String departmentName,int region)
	{
		this.departmentName=departmentName;
		this.region=region;
	}
	
	@Override
	public String toString() {
		return "\tDepartmentDTO [\ndepartmentName=" + departmentName + "\n region=" + region + "]\n";
	}

}
