package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read  form1/request1  data
		String name1=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String addr=req.getParameter("address");
		String ms=req.getParameter("ms");
		//generate form2  based on marital status value
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<h1 style ='color:red'>you are married then ans below que??</h1>");
			pw.println("<form action ='secondurl' method='POST'> ");
			pw.println("<table  align='center' border='1' bgcolor='pink'>");
			pw.println("<tr><td> Souse Name:::</td> <td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td> No.of kids :: </td> <td> <input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'> </td> <td><input type='reset' value='cancel'> </td></tr>");
			pw.println("</table>");
			pw.println("<input type='hidden' name='hname' value="+name1+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='haddrs' value="+addr+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
			pw.println("</form>");

		}
		else {
			pw.println("<h1 style ='color:red'>you are bachlour ...Then give me some answers??</h1>");
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table align='center' bgcolor='pink'>"); 
			pw.println("<tr><td> Why do u want to marry :: </td> <td> <input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td> When do u want to marry :: </td> <td> <input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='register'> </td> <td><input type='reset' value='cancel'> </td></tr>");
			pw.println("</table>");
			pw.println("<input type='hidden' name='hname' value="+name1+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='haddrs' value="+addr+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
			pw.println("</form>");
		}

		//close stream
		pw.close();

	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class



