package com.nt.dao;

import java.sql.SQLException;

import com.nt.bo.EmployeeBO;

public interface EmployeeDao {

	public int insert(EmployeeBO employeeBO) throws SQLException, ClassNotFoundException;
}
