package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.print.resources.serviceui;
@WebFilter("/*")
public class RequestCountFilter extends HttpFilter{
	
	private int count;
	@Override
	public void init() throws ServletException {
		System.out.println("RequestCountFilter.init()");
	count = 0;
	}
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext servletContext=null;
		//increment request count
		count++;
		System.out.println("RequestCountFilter :: "+count);
		servletContext = getServletContext();
		servletContext.setAttribute("reqCount", count);
		//delegate req next filter/destComponent
		chain.doFilter(req, res);
	}

}
