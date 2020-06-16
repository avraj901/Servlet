package com.nt.service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDto;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	EmployeeDao employeeDao;

	public EmployeeMgmtServiceImpl() {
		employeeDao = new EmployeeDAOImpl();
	}

	@Override
	public String registerEmployee(EmployeeDto empDto) throws Exception {

		float grossSalary =0.0f;
		float netSalary = 0.0f;
		EmployeeBO employeeBO = null;
		int count=0;
		
		grossSalary=empDto.getBasicSalary()+empDto.getBasicSalary()*0.4f;
		netSalary = grossSalary - (grossSalary*0.2f);
		//create Bo class Object 
		employeeBO = new EmployeeBO();
		employeeBO.setEname(empDto.getEname());
		employeeBO.setEaddress(empDto.getEaddress());
		employeeBO.setDoj(empDto.getDoj());
		employeeBO.setBasicSalry(empDto.getBasicSalary());
		employeeBO.setGrossSalry(grossSalary);
		employeeBO.setNetSalary(netSalary);
		//use Dao
		count = employeeDao.insert(employeeBO);
		if(count==0) {
			return "Registration Failed";
		}
		else
		return "registeration Successful";
		
	}

}
