package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");

		// Get access to existing HttpSession object
		HttpSession ses=req.getSession(false);

		String name=(String)ses.getAttribute("name");
		String fname=(String)ses.getAttribute("fname");
		String addrs=(String)ses.getAttribute("addrs");
		String ms=(String)ses.getAttribute("ms");
		//display form1/req1 data
		/*
		 * Cookie cookies[]=req.getCookies(); String name=null
		 * ,fname=null,ms=null,addr=null; if(cookies!=null) {
		 * name=cookies[0].getValue(); fname=cookies[1].getValue();
		 * addr=cookies[2].getValue(); ms=cookies[3].getValue(); }
		 */

		String f2val1=req.getParameter("f2t1");
		String f2val2=req.getParameter("f2t2");
		//display form1/req1 data
		pw.println("<h1 style='color:red'>Two forms/requests  data </h1>");

		pw.println("<br><b> from1/req1 data :: "+name+"...."+fname+"....."+addrs+"....."+ms);
		pw.println("<br><b> from2/req2 data :: "+f2val1+"...."+f2val2);
		//invaldate the session
		ses.invalidate();

		//add home hyperlink
		pw.println("<br><a href='search.html'>home </a>");
		pw.println("<br><br> <b> Session id :: "+ses.getId()+"</b>");
		//close stream
		pw.close();

	}//doGet(req,res)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class
