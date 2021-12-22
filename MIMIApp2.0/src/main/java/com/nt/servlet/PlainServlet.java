package com.nt.servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class PlainServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		//set response content type
		res.setContentType("text/plain");
		//get printWriter stream
		PrintWriter pw = res.getWriter();
		//Write o/p content to browser
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>Player Name</th> <th> Medal</><th>Category</th></tr>");
		pw.println("<tr><td>Neeraj Chopra</td> <td> Gold</><td>JavaLine </td></tr>");
		pw.println("<tr><td>Meera Bhai Channu</td> <td> Gold</><td>JavaLine </td></tr>");
		pw.println("<tr><td>Ravikumar Dhaniya</td> <td> Silver</><td>Wresling </td></tr>");
        
        pw.println("<tr><td>Meera Bhai Channu</td> <td> Silver</><td>batmintan </td></tr>");
        pw.println("<tr><td> Channu thadake</td> <td> Gold</><td>Boxing </td></tr>");
        pw.println("<tr><td>Meera chavhan</td> <td> Bronze</><td>Hokey </td></tr>");
        pw.println("</table>");
        //close streams
        pw.close();


	}  //servise

}//class