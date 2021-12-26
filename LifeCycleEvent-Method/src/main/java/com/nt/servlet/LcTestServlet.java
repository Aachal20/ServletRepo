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
		System.out.println("LcTestServlet::Static Block");
	}
	public LcTestServlet() {
		System.out.println("LcTestServlet::0-param constructor()");
	}
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("LcTestServlet.init()::init Method");
		String driver =cg.getInitParameter("drivername");
		String user=cg.getInitParameter("dbuser");
		System.out.println(driver+"  --" +user);

	}
	//req processing logic
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet.:::(req,res)");
		//get printWriter
		PrintWriter  pw =res.getWriter();
		res.setContentType("text/html");
		//write response to content typpe
		pw.println("<h1 style='color:red;text-align:center'>Date And time :::"+new java.util.Date()+"</h1>");
		//close stream
		pw.close();
	}
	public static void main(String[] args) {
		System.out.println("main method(-,-)");
	}
	@Override
	public void destroy() {
		System.out.println("LcTestServlet::destroy()");
	}
}
