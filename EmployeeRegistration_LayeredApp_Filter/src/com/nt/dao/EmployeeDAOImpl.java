package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDao {
	static Connection con = null;
	private static final String REGISTER_STUDENT = "INSERT INTO employee(emp_name,emp_address,emp_basicsalary,emp_grosssalary,emp_netsalary,doj)VALUES(?,?,?,?,?,?)";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		System.out.println("EmployeeDAOImpl.getConnection()");
		  Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Organization?useSSL=false&serverTimezone=UTC", "root", "password");
		return con;
	}

	@Override
	public int insert(EmployeeBO employeeBO) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = null;
		int count=0;
		con = getConnection();
		ps=con.prepareStatement(REGISTER_STUDENT);
		ps.setString(1, employeeBO.getEname());
		ps.setString(2, employeeBO.getEaddress());
		ps.setFloat(3, employeeBO.getBasicSalry());
		ps.setFloat(4, employeeBO.getGrossSalry());
		ps.setFloat(5, employeeBO.getNetSalary());
		ps.setDate(6, employeeBO.getDoj());
		count = ps.executeUpdate();
		return count;
	}

}
