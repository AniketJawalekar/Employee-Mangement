package com.smarteinc.employeeManagement.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="Employee")
public class Employee {
	
	@Id
	@Column(name="employeeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int employeeId;
	
	@Column(name="username",unique=true)
	private String username;
	
	@Column(name="password")
	private int password;
	
	@Column(name="age")
	private int age;
	
	@Column(name="annualCTC")
	private int annualCTC;
	
	@Column(name="joiningDate")
	private Date joiningDate;
	
	@ManyToOne(targetEntity=Status.class,fetch=FetchType.LAZY)
	@JoinColumn(name="status",referencedColumnName="statusId")
	private Status status;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pinCode")
	private int pinCode;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
    
	@ManyToOne(targetEntity=Department.class,fetch=FetchType.LAZY)
	@JoinColumn(name="departmentId",referencedColumnName="departmentId")
	private Department department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
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

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee()
	{
		
	}

	public Employee(String username, int password, int age, int annualCTC, Date joiningDate, Status status,
			String city, int pinCode, String state, String country, Department department) {
		this.username = username;
		this.password = password;
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
		return "Employee [\nemployeeId=" + employeeId + "\n username=" + username + "\n password=" + password + "\n age="
				+ age + "\n annualCTC=" + annualCTC + "\n joiningDate=" + joiningDate + "\n status=" + status + "\n city="
				+ city + "\n pinCode=" + pinCode + "\n state=" + state + "\n country=" + country + "\n department="
				+ department + "\n]";
	}

}
