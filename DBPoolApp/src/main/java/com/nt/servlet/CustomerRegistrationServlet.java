package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	public static final String CUSTOMER_INSERT_QUERY="INSERT INTO CUSTOMER_SERVLET VALUES(CUSTO_CNO_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwrite
		PrintWriter pw =res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data(req param value)
		String name=req.getParameter("cname");
		String addrs = req.getParameter("cadd");
		float billAmt = Float.parseFloat(req.getParameter("billAmt"));
		long mobNo = Long.parseLong(req.getParameter("mobNo"));

		//get pooled jdbc connection
		try(Connection con = getPooledConnection();
				PreparedStatement ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);
				){
			//SET VALUES TO QUERY PARAM

			ps.setString(1, name);
			ps.setString(2,addrs);
			ps.setFloat(3, billAmt);
			ps.setLong(4, mobNo);
			//execute the query
			int result =ps.executeUpdate();



			if(result==1) 
				pw.println("<h1 style='color:green;text-align:center'> Customer is registerd</h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Customer is not registerd</h1>");


			//add hyperlink
			pw.println("<br><br><a href ='Customer_register.html'>HOME</a>");
			//close strems
			pw.close();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:green;text-align:center'> Internal problem occour"+se.getMessage()+"</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:green;text-align:center'> Internal problem occour"+e.getMessage()+"</h1>");	
			//add hyperlink
			pw.println("<br><br><a href ='Customer_register.html'>HOME</a>");
		}

	}
	//helper method
	private Connection getPooledConnection() throws Exception {
		// create intial contxt object
		InitialContext ic = new 	InitialContext();
		//get dataSource ref object
		DataSource  ds =(DataSource)ic.lookup("DsJndi");
		//get pooled jdbc connection
		Connection con =ds.getConnection();
		return con;
		
	}
}

