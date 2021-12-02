package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineElligibilityChecking extends HttpServlet {
	
  //private static final ServletResponse res = null;

@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	  //get printwriter
	//  PrintWriter pw =resp.getWriter();
	  PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
      //read from form data(req param value)
		String name =req.getParameter("pname");
		String addrs =req.getParameter("paddrs");
		int age =Integer.parseInt(req.getParameter("page"));
		
		//write b.logic
		if(age<18)
			pw.println("<h1 style = 'color:red;text-align:center'>Miss ."+name+" U are not Eligible for Corona Vaccination</h1>");
		else
			pw.println("<h1 style = 'color:yellow;text-align:center'>Mrs ."+name+" U are  Eligible for Corona Vaccination</h1>");
	  
		//add home hyperlink(Graphical hyperlink)
				pw.println("<a href='corona_vaccine.html'><img src ='images/kk.png'></a>");
				//close streams
				pw.close();
	
    }//doGet
}//class
