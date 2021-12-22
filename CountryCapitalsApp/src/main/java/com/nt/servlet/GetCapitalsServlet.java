package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalsServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter 
		PrintWriter pw= res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		int country=Integer.parseInt(req.getParameter("country"));
		//get capitals city name
		String capitals[]=new String[] {"New Delhi" ,"Islamabad","WashingtonDC","Bejeling","Dhaka","Paris"};
		String countries[]=new String[] {"India","pakistan","USA","Chiana","Bangladesh","France"};
		pw.println("<h1 style='color:red;text-align:center'> Capital name of country" +countries[country] + "is::"  +capitals[country]+"</h1> ");
		//add home hyperlink
		pw.println("<h1 style='color:blue;text-align:center'><a href='page.html' >Home</a></h1>");
		//close stream
		pw.close();

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}


}//class
