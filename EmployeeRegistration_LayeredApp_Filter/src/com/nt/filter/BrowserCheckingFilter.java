package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class BrowserCheckingFilter extends HttpFilter{

	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("BrowserCheckingFilter.doFilter()");
		PrintWriter pw=null;
		String browser = null;
		//get Printwriter
		pw=response.getWriter();
		//set response content type
		response.setContentType("text/html");
		//get curent browser name
		browser=request.getHeader("user-agent");
		if(browser.indexOf("Chrome")==-1) {
			pw.print("<h1 style='text-align:center;color : red'>Use Chrome browser to visit this website</h1>");
		}else {
			System.out.println("BrowserCheckingFilter.before()");
			chain.doFilter(request, response);
			System.out.println("BrowserCheckingFilter.after()");
		}
	}
}
