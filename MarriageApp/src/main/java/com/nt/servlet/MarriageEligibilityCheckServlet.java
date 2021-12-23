package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageEligibilityCheckServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
    //get printWriter
	PrintWriter pw = res.getWriter();
	//set response content type
	res.setContentType("text/html");
	//read form data
	String name=req.getParameter("pname");
	int age = Integer.parseInt(req.getParameter("page"));
	String gen=req.getParameter("gender");
	//write business logic
	if(gen.equalsIgnoreCase("Male")) {
		if(age>=21)
			pw.println("<h1 style ='color:red; text-align:center'> Mr."+name+" u are eligible  for marriage but thinks twice</h1>");
		else
			pw.println("<h1 style ='color:yellow; text-align:center'> Mr."+name+ "u are not  eligible  for marriage </h1>");
	
	}
	else {

		if(age>=18)
			pw.println("<h1 style ='color:pink ;text-align:center'> Mr."+name+" u are eligible  for marriage</h1>");
		else
			pw.println("<h1 style ='color:blue;text-align:center'> Mr."+name+ "u are not  eligible  for marriage ..Be Happy</h1>");
	
	}//else
	//add home hyperlink
	pw.println();
	//close stream
	pw.close();
	
	}//method
}//class
