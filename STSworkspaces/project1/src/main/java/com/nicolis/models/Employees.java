package com.nicolis.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;
	private int EId;
	private Departments departments;
	private Employees employeesBySupervisorId;
	private Employees employeesByBenCoId;
	private String username;
	private String password;
	private String name;
	private String dob;
	private String email;
	private BigDecimal awardedR;

	public Employees() {
	}

	public Employees(int eId, String username, String password, String name, String dob, String email,
			BigDecimal awardedR) {
		super();
		EId = eId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.awardedR = awardedR;
	}

	public Employees(int EId, Departments departments, Employees employeesBySupervisorId, Employees employeesByBenCoId,
			String username, String password, String name, String dob, String email, BigDecimal awardedR) {
		this.EId = EId;
		this.departments = departments;
		this.employeesBySupervisorId = employeesBySupervisorId;
		this.employeesByBenCoId = employeesByBenCoId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.awardedR = awardedR;
	}

	public Employees(Departments departments, Employees employeesBySupervisorId, Employees employeesByBenCoId,
			String username, String password, String name, String dob, String email, BigDecimal awardedR) {
		super();
		this.departments = departments;
		this.employeesBySupervisorId = employeesBySupervisorId;
		this.employeesByBenCoId = employeesByBenCoId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.awardedR = awardedR;
	}

	public int getEId() {
		return this.EId;
	}

	public void setEId(int EId) {
		this.EId = EId;
	}

	@JsonIgnore
	public Departments getDepartments() {
		return this.departments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Employees getEmployeesBySupervisorId() {
		return employeesBySupervisorId;
	}

	public void setEmployeesBySupervisorId(Employees employeesBySupervisorId) {
		this.employeesBySupervisorId = employeesBySupervisorId;
	}

	public Employees getEmployeesByBenCoId() {
		return employeesByBenCoId;
	}

	public void setEmployeesByBenCoId(Employees employeesByBenCoId) {
		this.employeesByBenCoId = employeesByBenCoId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getAwardedR() {
		return this.awardedR;
	}

	public void setAwardedR(BigDecimal awardedR) {
		this.awardedR = awardedR;
	}

	@Override
	public String toString() {
		return "Employees [EId=" + EId + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", dob=" + dob + ", email=" + email + ", awardedR=" + awardedR + "]";
	}

}
