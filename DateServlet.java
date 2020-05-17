package com.nt.servlet;

import javax.servlet.*;//servlet api 
import java.io.*; // Io Streams api 
import java.util.*; //Utility Api

public class DateServlet extends GenericServlet
{
       public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
       
           PrintWriter pw=null;
           Date d=null;

           //get PrintWriter from response Object to write the msg/outputs to response object.

            pw = res.getWriter();

//Set response content type to instruct browser towards the dis[laying the web page.
            res.setContentType("text/html");

             //write the business logic 
           
              d=new Date();
             //Write result/output message to response object using stream PrinWriter

             pw.println("<h1> DateServlet:: Date nad time is :: + d.toString()+</h1>");

//close Stream();

pw.close();
}
}
