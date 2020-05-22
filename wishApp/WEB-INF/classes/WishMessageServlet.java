package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;




public class WishMessageServlet extends HttpServlet{


@Override
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

PrintWriter pw=null;
Calendar c = java.util.Calendar.getInstance(); 

int hour=0;

//getPrintWriter

pw=res.getWriter();

//setResponseContentType

res.setContentType("text/html");

//generate WishMessage by getting Sytem Date and Time



hour=c.get(Calendar.HOUR_OF_DAY);

//generate Wish Message

if(hour<12){
pw.println("<h1 style='color:red;text-align:center'>Good Morning</h1>");

}
else if(hour<16){
pw.println("<h1 style='color:yellow;text-align:center'>Good AfterNoon</h1>");
}
else if (hour<20){
pw.println("<h1 style='color:pink;text-align:center')>Good Evening</h1>");
}
else{
pw.println("<h1 style='color:green;text-align:enter'>Good Night</h1>");
}

pw.println("<br><a href='http://localhost:8080/wishApp/page.html'>Home Page</a>");
  }
}
