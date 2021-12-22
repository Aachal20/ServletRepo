package com.nt.servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class HtmlServlet extends HttpServlet
{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{
		//set response content type
		res.setContentType("text/html");
		//get printWriter stream
		PrintWriter pw = res.getWriter();
		//enable auto refresh on the web page
		res.setHeader("refresh","10");
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
        //pw.println("<h2 style="color:red;">Hello Aachal </h2>");
        //pw.println("<h1 style="color:Tomato;">Hello World</h1>");
        pw.println("<h1>Hello World</h1>");
         pw.println("<br><h1 style ='color:red;text-align:center'>Date And Time is ::"+new java.util.Date()+"</h1>");
         pw.println("<br>req obj class name ::"+req.getClass());

           pw.println("<br>req obj class name ::"+res.getClass());
        //close streams
        pw.close();


	}  //servise

}//class