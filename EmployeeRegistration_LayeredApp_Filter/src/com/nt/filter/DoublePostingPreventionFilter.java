package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/*")
public class DoublePostingPreventionFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
              
		HttpSession session =null;
		String method = null;
		int serverToken,clientToken;
		RequestDispatcher requestDispatcher = null;
		//get Session
		session=req.getSession();
		//get request method
		method = req.getMethod();
		if(method.equalsIgnoreCase("GET")) {
			//generate token and make it server side token and also client side token in form page
			session.setAttribute("serverToken", new Random().nextInt(10000));
			chain.doFilter(req, res);
		}
		else {
			//read server token and client token values
			System.out.println("clientToken---"+req.getAttribute("clientToken"));
			clientToken=Integer.parseInt(req.getParameter("clientToken"));
			serverToken=(int) session.getAttribute("serverToken");
			System.out.println("servetToken"+serverToken+"ClientToken"+clientToken);
			if(serverToken==clientToken) {
				session.setAttribute("serverToken", new Random().nextInt(1000));
				chain.doFilter(req, res);
			}
			else {
				requestDispatcher=req.getRequestDispatcher("error.html");
				requestDispatcher.forward(req, res);
			}
		}
	}
}
