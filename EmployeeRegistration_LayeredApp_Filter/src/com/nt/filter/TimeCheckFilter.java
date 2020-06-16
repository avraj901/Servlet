package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter {

	static {
		System.out.println("TimeCheckFilter.static Block()");
	}
	public  TimeCheckFilter() {
		System.out.println("TimeCheckFilter.Constructor()");
	}
	public void init(ServletConfig config) {
		System.out.println("TimeCheckFilter.init()");
	}
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("TimeCheckFilter.doFilter()");
		Calendar calendar=null;
		PrintWriter pw=null;
		int hour=0;
		//get PrintWriter
		pw=response.getWriter();
		//set response content type
		response.setContentType("text/html");
		//get System Date
		calendar=Calendar.getInstance();
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		if(hour<9 || hour>17) {
			
			pw.println("<h1 style='text-align:center;color:red'>Request must not be given before 9  and after 17. </h1>");
		}else {
			System.out.println("TimeCheckFilter.before()");
			chain.doFilter(request, response);
			System.out.println("TimeCheckFilter.after()");
			
		}
	
	}
	public void destroy() {
		System.out.println("TimeCheckFilter.doFilter()");
	}
	
}
