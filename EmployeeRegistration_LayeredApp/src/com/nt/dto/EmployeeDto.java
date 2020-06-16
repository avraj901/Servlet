package com.nt.dto;

import java.io.Serializable;
import java.sql.Date;

public class EmployeeDto implements Serializable{

	private String ename;
	private String eaddress;
	private Date doj;
	private float basicSalary;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDto [ename=" + ename + ", eaddress=" + eaddress + ", doj=" + doj + ", basicSalary="
				+ basicSalary + "]";
	}
	
}
