package com.smarteinc.employeeManagement.model;

import java.io.Serializable;

/** 
* Model class
* @author Aniket 
*/
public class EmployeeDTO implements Serializable {
	
	private static final long serialVersionUID=1l;
	
	private String username;
	
	private int age;
	
	private int annualCTC;
	
	private String joiningDate;
	
	private int status;
	
	private String city;
	
	private int pinCode;
	
	private String state;
	
	private String country;
    
	private int department;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAnnualCTC() {
		return annualCTC;
	}

	public void setAnnualCTC(int annualCTC) {
		this.annualCTC = annualCTC;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public EmployeeDTO()
	{
		
	}
	public EmployeeDTO(String username,int age,int annualCTC,String joiningDate,int status,
			String city, int pinCode, String state, String country, int department) {
		this.username = username;
		this.age = age;
		this.annualCTC = annualCTC;
		this.joiningDate = joiningDate;
		this.status = status;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
		this.country = country;
		this.department = department;
	}

	@Override
	public String toString() {
		return "\tEmployeeDTO [\nusername=" + username + "\n age=" + age + "\n annualCTC=" + annualCTC + "\n joiningDate="
				+ joiningDate + "\n status=" + status + "\n city=" + city + "\n pinCode=" + pinCode + "\n state=" + state
				+ "\n country=" + country + "\n department=" + department + "]\n";
	}


}
