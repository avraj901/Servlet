package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExcelServlet extends HttpServlet{

      protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
                
            PrintWriter pw=null;
               //get PrintWriter.
               pw=res.getWriter();
               //set Response Content Type/MIME Type
               res.setContentType("application/vnd.ms-excel");
               //Write output message to res object.
                pw.println("<table align='center' border='1' color='cyan'>");
                pw.println("<tr><th>country</th><th>President</th>");
                pw.println("<tr><td>India</td><td>Modi</td></tr>");
                pw.println("<tr><td>Pakistan</td><td>ImranKhan</td></tr>");
                pw.println("<tr><td>Us</td><td>Trump</td></tr>");
                pw.println("<tr><td>China</td><td>Xi-xing ping</td></tr>");
                pw.println("</table>");

                //close Stream
                
                pw.close();
                 

    }

}


