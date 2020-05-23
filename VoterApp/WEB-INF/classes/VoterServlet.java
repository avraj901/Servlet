package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VoterServlet extends HttpServlet{


@Override
public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{

PrintWriter pw=null;

//get PrintWriter
pw=res.getWriter();

String name=null;
int age=0;
//Set Response Content Type

res.setContentType("text/html");

//read form data 

name=req.getParameter("pname");
age=Integer.parseInt(req.getParameter("page"));

if(age<18){
      pw.println("<h1 style='color:red;text-align:center'>Mr./Miss "+name+" You are not eligible for vote</h1>");

}
else{
         pw.println("<h1 style='color:green;text-align:center'>Mr./Miss "+name+" you are eligible for vote</h1>");
}

pw.println("<a href='http://localhost:8080/VoterApp/input.html'><img src='home.jpeg'></a>");
  }
}
