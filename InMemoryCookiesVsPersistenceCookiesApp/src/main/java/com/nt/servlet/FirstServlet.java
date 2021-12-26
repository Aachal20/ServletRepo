package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
  @Override
public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get PrintWriter
	  PrintWriter pw= res.getWriter();
    //set response content type
	  res.setContentType("text/html");
	  //create cookies
	  Cookie ck1 = new Cookie("MP", "baitul");
	  Cookie ck2= new Cookie("TS", "Hydrabad");
    
	  Cookie ck3 = new Cookie("AP", "NoCapital");
	  Cookie ck4 = new Cookie("Odisha" ,"BBBBB");
	  ck3.setMaxAge(1*60);
	  ck4.setMaxAge(2*60);
	  //add cookies to the response
	  res.addCookie(ck1); res.addCookie(ck2);   //InMemory Cookies
	  res.addCookie(ck3); res.addCookie(ck4);   //Persistence Cookie
	  
	  pw.print("<b>Cookies Added  Successfully</b>");
	  //close stream 
	  pw.close();
  }
  
  @Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
  
}
