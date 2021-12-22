package com.nt.servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class XmlServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		//set response content type
		res.setContentType("application/xml");
		//get printWriter stream
		PrintWriter pw = res.getWriter();
		//Write o/p content to browser
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>Player Name</th> <th> Medal</th><th>Category</th></tr>");
		pw.println("<tr><td>Neeraj Chopra</td> <th> Gold</th><td>JavaLine </td></tr>");
		pw.println("<tr><td>Meera Bhai Channu</td> <th> Gold</th><td>JavaLine </td></tr>");
		pw.println("<tr><td>Ravikumar Dhaniya</td> <th> Silver</th><td>Wresling </td></tr>");
        
        pw.println("<tr><td>Meera Bhai Channu</td> <th> Silver</th><td>batmintan </td></tr>");
        pw.println("<tr><td> Channu thadake</td> <th> Gold</th><td>Boxing </td></tr>");
        pw.println("<tr><td>Meera chavhan</td> <th> Bronze</th><td>Hokey </td></tr>");
        pw.println("</table>");
        //close streams
        pw.close();


	}  //servise

}//class
