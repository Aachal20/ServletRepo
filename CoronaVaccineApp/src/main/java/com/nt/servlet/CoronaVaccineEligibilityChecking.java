package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class CoronaVaccineEligibilityChecking extends HttpServlet {


	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");


		//read from form data(req paramater)
		String name;
		int age;
		String address;
		try {
			 name = req.getParameter("pname");
			 age = Integer.parseInt(req.getParameter("page"));
			 address = req.getParameter("addrs");
		}//try
		catch(Exception e) {
			pw.println("Internal server Error....");
			e.printStackTrace();
			return;
		}//catch

		//write b.logic
		if(age<18)
			pw.println("<h1 style = 'color:red;text-align:center'>Miss ."+name+" U are not Eligible for Corona Vaccination</h1>");
		else
			pw.println("<h1 style = 'color:red;text-align:center'>Miss ."+name+" U are  Eligible for Corona Vaccination</h1>");

		//add home hyperlink(Graphical hyperlink)
		pw.println("<a href='corona_vaccine.html'><img src ='images/fly.jpg'></a>");
		//close streams
		pw.close();


	}//doget

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}//doPost

}//class
