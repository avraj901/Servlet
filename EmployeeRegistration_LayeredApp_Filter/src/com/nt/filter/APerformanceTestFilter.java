package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class APerformanceTestFilter extends HttpFilter{

public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
	System.out.println("PerformanceTestFilter.doFilter()");
	long start=0;
	long end=0;
	start=System.currentTimeMillis();
	System.out.println("PerformanceTestFilter.before()");
	chain.doFilter(request, response);
	System.out.println("PerformanceTestFilter.after()");
	end=System.currentTimeMillis();
	System.out.println(request.getRequestURI()+"request has taken  :: "+(end-start)+"---ms to process the request");
	
}

}
