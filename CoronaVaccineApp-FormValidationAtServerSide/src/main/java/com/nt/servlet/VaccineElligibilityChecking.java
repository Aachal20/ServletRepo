package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineElligibilityChecking extends HttpServlet {
	
  //private static final ServletResponse res = null;


@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	System.out.println("VaccineEligibilityCheckServlet.doPost(-,-)");

	//Get PrintWriter
	PrintWriter pw=res.getWriter();

	//Set response content type
	res.setContentType("text/html");

	//Read form data(req parameters value)
	String name = req.getParameter("pname");
	String addrs = req.getParameter("paddrs");
	String tage = req.getParameter("page");
	//String csvStatus = req.getParameter("vflag");
	System.out.println(name+" "+addrs+" "+tage);//+" "+csvStatus);
	
	int age=0;
	//if(csvStatus.equalsIgnoreCase("no")) {		
		//Form validation logics(Server side)
		System.out.println("Server side form validations");
		List<String> errorsList=new ArrayList();
		if(name==null || name.length()==0 || name.equalsIgnoreCase(""))  //required rule on name
			errorsList.add("Person name is required");

		if(addrs==null || addrs.length()==0 || addrs.equalsIgnoreCase(""))  //required rule on address
			errorsList.add("Person address is required");
		else if(addrs.length()<10)  //min length rule on address
			errorsList.add("Person address must have minimum 10 characters");

		if(tage==null || tage.length()==0 || tage.equalsIgnoreCase(""))  //required rule on age
			errorsList.add("Person age is required");
		else {
			try {
				age=Integer.parseInt(tage);
				if(age<=0 || age>125)
					errorsList.add("Person age must be in the range of 1 through 125"); //age range rule
			}
			catch(NumberFormatException nfe) {
				errorsList.add("Person age must be numeric value");
			}
		}//else

		if(errorsList.size()>0) {
			pw.println("<ul style='color:red'>");
			for(String errMsg:errorsList)
				pw.println("<li>"+ errMsg +"</li>");
			pw.println("</ul>");
			return;  //block control going further
		}
	//}
	//else
		age=Integer.parseInt(tage);
	//Write b.logic (request processing logic)
	if(age<18)
		pw.println("<h1 style='color:red; text-align:center'> Mr/Miss/Mrs. "+name+" you are not eligible for Corona Vaccination</h1>");
	else
		pw.println("<h1 style='color:green; text-align:center'> Mr/Miss/Mrs. "+name+" you are eligible for Corona Vaccination, Make it happen</h1>");

	//Add graphical hyperlink for home
	pw.println("<a href='corona_vaccine.html'><img src='images/pp.png' width='150px' height='150px'></a>");

	//Close Stream objs
	pw.close();
}//doPost(-,-);
}//class
