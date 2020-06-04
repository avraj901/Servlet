package com.nt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=null,gender=null,ms=null,addres=null; String qlfy[]=null,crs[]=null,hb[]=null;
		int age=0;
		PrintWriter pw=null;
		//get PrintWriter Object
		pw=response.getWriter();
		//setResponse content type
		response.setContentType("text/html");
		//read from data
		name=request.getParameter("name");
		age=Integer.parseInt(request.getParameter("age"));
		gender=request.getParameter("gender");
		addres=request.getParameter("address");
		ms=request.getParameter("ms");
		qlfy=request.getParameterValues("qlfy");
		crs=request.getParameterValues("crs");
		hb=request.getParameterValues("hb");
		if(gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println(name +":: u r a baby boy");
			else if(age<10)
				pw.println(name + ":: u r a small boy");
			else if(age<20)
				pw.println(name + ":: u r a teen boy");
			else if(age<30)
				pw.println(name + ":: u are young");
			else if(age<40)
			pw.println(name + ":: u r to middled aged man");
			else 
				pw.println(name + ":: u r to old man");
			
		}
		else if(gender.equalsIgnoreCase("F")) {
			if(age<5)
				pw.println(name +":: u r a baby girl");
			else if(age<10)
				pw.println(name + ":: u r a small girl");
			else if(age<20)
				pw.println(name + ":: u r a teen girl");
			else if(age<30)
				pw.println(name + ":: u are girl");
			else if(age<40)
			pw.println(name + ":: u r to middled aged girl");
			else 
				pw.println(name + ":: u r to old girl");
		}
		pw.println("<br>name ::"+name);
		pw.println("<br>age ::"+age);
		pw.println("<br>gender ::"+gender);
		pw.println("<br>address ::"+addres);
		pw.println("<br>marital Status :: "+ms);
		pw.println("<br>Qualification ::"+Arrays.toString(qlfy));
		pw.println("<br>course :: "+Arrays.toString(crs));
		pw.println("<br>hobbies ::"+Arrays.toString(hb));
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
