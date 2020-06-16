package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;

@WebServlet("/controller")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeMgmtService employeeMgmtService;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("MainController.init()");
		employeeMgmtService = new EmployeeMgmtServiceImpl();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainController.doGet()");
		EmployeeVO employeeVO = null;
		EmployeeDto employeeDto = null;
		PrintWriter pw = null;
		String result;

		// Read Form data and store in EmployeeVO class Object.
		employeeVO = new EmployeeVO();
		employeeVO.setEname(request.getParameter("ename"));
		employeeVO.setEaddress(request.getParameter("eaddress"));
		employeeVO.setDoj(request.getParameter("doj"));
		System.out.println("date of joining" + request.getParameter("doj"));
		System.out.println("BasicSalary ::"+request.getParameter("basicSalary"));
		employeeVO.setBasicSalary(request.getParameter("basicSalary"));

		// create PrinWriter
		pw = response.getWriter();
		// set Response Content Type
		response.setContentType("text/html");
		// convert vo class Object to Dto class Object.
		employeeDto = new EmployeeDto();
		employeeDto.setEname(employeeVO.getEname());
		employeeDto.setEaddress(employeeVO.getEaddress());
		employeeDto.setDoj((java.sql.Date.valueOf(employeeVO.getDoj())));
		System.out.println("getBasicSalary :: "+employeeVO.getBasicSalary());
		employeeDto.setBasicSalary(Float.parseFloat(employeeVO.getBasicSalary()));
		try {
			result = employeeMgmtService.registerEmployee(employeeDto);
			pw.println("<h1 style='text-align:center;color:red'>Result ::"+result+"</h1>");
		}catch(Exception e) {
			pw.print("<h1>Internal Problem</h1>");
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainController.doPost()");
		doGet(request, response);
	}

	public void destroy() {
		System.out.println("MainController.destroy()");
	}

}
