package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyRoutineServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException{

		
		//get printWriter stream
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		String name = req.getParameter("name");
		
		//wrie b.logic to generate wishMessage
		LocalDateTime ldt = LocalDateTime.now();// give current date time
		int hour=ldt.getHour();  //give current hour of the day 0-23
		pw.println("<h1 style='color:red;text-align:cente'>"+ldt.toString()+"</h1>");

		pw.println("<h2>Hi, "+name+" My Daily Schedule... </h2>");
		if(hour<12)
			//pw.println("<h1 style='color:orange;text-align:cente'>Good Morning</h1>");
			pw.println("<h3 style='color:purple;text-align:cente'> This is my WorkoutTime</h3>");
		else if(hour<16)
           // pw.println("<h1 style='color:orange;text-align:cente'>Good Afternoon</h1>");
			pw.println("<h3 style='color:purple;text-align:cente'>This is my Office Time</h3>");
        else if(hour<20) 
        	//pw.println("<h1 style='color:orange;text-align:cente'>Good Evening</h1>");
			pw.println("<h3 style='color:purple;text-align:cente'> This is my Family Time</h3>");
        else
        	//pw.println("<h1 style='color:orange;text-align:cente'>Good Night</h1>");
        	pw.println("<h3 style='color:purple;text-align:cente'>This is my Sleep time Time</h3>");
		
        //add home hyperlink
        pw.println("<br> <a href='page.html'>home</a>");
         //close stream
         pw.close(); 
}

}
