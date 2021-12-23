package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printstream
		PrintWriter pw= res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read additioinal parm value
		String pval= req.getParameter("s1");
		//read form data and convert that in to numeric value only when hyperlink are not generating requests
		float val1=0.0f,val2=0.0f;
		if(!pval.equalsIgnoreCase("link1") &&!pval.equalsIgnoreCase("link2")){
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
		}

		//write request processing logics for submit buttons and hyperlink
		if(pval.equalsIgnoreCase("add")) {
			float result=val1+val2;
			pw.println("<h1 style= color:redltext-align:center> Add:"+result+"</h1>");
		}
		else if(pval.equalsIgnoreCase("sub")) {
			float result=val1-val2;
			pw.println("<h1 style= color:redltext-align:center> sub:"+result+"</h1>");
		}
		else if(pval.equalsIgnoreCase("mul")) {
			float result=val1*val2;
			pw.println("<h1 style= color:redltext-align:center> mul:"+result+"</h1>");
		}

		else if(pval.equalsIgnoreCase("div")) {
			float result=val1/val2;
			pw.println("<h1 style= color:redltext-align:center> Div:"+result+"</h1>");
		}
		else if(pval.equalsIgnoreCase("link1")) {
			pw.println("<b><h1 style= color:red;text-align:center> system properties"+System.getProperties()+"</h1></b>");
		}
		else {
			pw.println("<b>Date and Time:::" +new java.util.Date()+"</b>");
		}
		//add hyperlink home
		pw.println("<h1 style='color:orange;text-align:center'><a href =' form.html'>Home</a></h1>");

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}  
}

