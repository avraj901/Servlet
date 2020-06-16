package com.nt.bo;

import java.sql.Date;

public class EmployeeBO {

	private String ename;
	private String eaddress;
	private Date doj;
	private float basicSalry;
	private float grossSalry;
	private float netSalary;
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
	public float getBasicSalry() {
		return basicSalry;
	}
	public void setBasicSalry(float basicSalry) {
		this.basicSalry = basicSalry;
	}
	public float getGrossSalry() {
		return grossSalry;
	}
	public void setGrossSalry(float grossSalry) {
		this.grossSalry = grossSalry;
	}
	public float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(float netSalary) {
		this.netSalary = netSalary;
	}
	
}
