package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriert
		PrintWriter pw = res.getWriter();
		//set resp[onse content  type
		res.setContentType("text/html");
		//read form data
		String  ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
		//Append  query string to the url placed  in   res.sendRedirection() method 

		String url=null;
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://in.search.bing.com/search?q="+ss;
		else
			url="https://in.search.yahoo.com/search?p="+ss;
		//perform sendRedirection
		pw.println("Before res.sendRedirect(-)");
		pw.println("hello aware");
		res.sendRedirect(url);
		pw.println("after res.sendRedirect(-)");
		pw.println("hey completed");
		//res.sendRedirect(url);
		//close stream 
		pw.close();
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class



