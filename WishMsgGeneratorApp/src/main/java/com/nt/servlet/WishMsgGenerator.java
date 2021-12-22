package com.nt.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMsgGenerator extends HttpServlet {
	@Override
	public  void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//write printStream class
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//write b.logic to generate the wish message
		LocalDateTime ldt = LocalDateTime.now();
		//get hours of day
		int hours=ldt.getHour();   //between 0 to 23 hour
		//genetrate the wishmsg
		if(hours<12)
			pw.println("<h1 style = 'color:red; text-align:center' > Good Morning </h1>");
		else if(hours<16)
			pw.println("<h1 style = 'color:red;text-align:center' > Good Afternoon </h1>");
		else if(hours<20)
			pw.println("<h1 style = 'color:red;text-align:center' > Good Eveining </h1>");
		else 
			pw.println("<h1 style = 'color:red;text-align:center' > Good night </h1>");
		//add home hyper link
	        pw.println("<a href='page.html'><img src='images/office.jpg'></a>");
		//close strems
		  pw.close();
	}
}

