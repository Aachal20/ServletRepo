package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	static {
		System.out.println("LcTestServlet.enclosing_method()");
	}
	public LcTestServlet() {
		System.out.println("LcTestServlet.LcTestServlet()");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LcTestServlet.init()::init Method");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet.:::req,res");
		//get printWriter
		PrintWriter  pw =res.getWriter();
		res.setContentType("text/html");
		//write response to content typpe
		pw.println("<h1>Date And time :::"+new java.util.Date()+"</h1>");
		//close stream
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("LcTestServlet::destroy()");
	}
}
