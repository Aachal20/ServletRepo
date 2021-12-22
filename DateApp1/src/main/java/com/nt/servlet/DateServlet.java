package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet {

	public   DateServlet() {
		System.out.println("DateServlet.DateServlet()::0-param constructor");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		//get PrintSream obj from response objct
		PrintWriter pw = res.getWriter();
		//set response content type to browser
		res.setContentType("text/html");
		//write request processing  logic
		Date d = new Date();
		//String sysdate = d.toString();

		//write generated output to response object using printWriter stream obj
		// pw.println("<h1 style='color:blue;text-align:center'> "+sysdate+"</h1>");
		pw.println("<h1 style='color:red;text-align:center'>Current System Date And Time </h1>");
		pw.println("<h1 style='color:blue;text-align:center'> "+d+"</h1>");

		//close stream
		pw.close();


	}

}
