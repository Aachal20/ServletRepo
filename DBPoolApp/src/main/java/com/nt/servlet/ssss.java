package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ssss extends HttpServlet {
	private static final String ADMIN_LOGIN="SELECT COUNT(*) FROM ADIMIN_LOGIN WHERE EMAILID=? AND PASSWORD=?";
	public ssss() {
		System.out.println("StudentLoginPage::0-param constructor()");
	}

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		
		//read form data
		String mail =req.getParameter("adminname");
		String pass = req.getParameter("adminpwd");

	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
	catch(ClassNotFoundException cnf) {
			pw.println(cnf.getMessage());
			cnf.printStackTrace();
		}
		//Write jdbc code
		try(Connection con = getPooledConnection();
				//create PreparedStatement object
				PreparedStatement ps = con.prepareStatement(ADMIN_LOGIN)){
			if(ps!=null) {
				ps.setString(1, mail);
				ps.setString(2, pass);
				//Create RS object to gather result from DB s/w
				try(ResultSet rs =ps.executeQuery()){
					//process the rs
					if(rs!=null)
					if(rs.next()) {
						//pw.println("<h1 style='color:blue ;text-align :center'>Login Success:: "+mail + "    "+pass+"</h1>");
						    pw.println("Enter Librabrabrian Login Info ");
							RequestDispatcher rd = req.getRequestDispatcher("AdminLibLogin.html");
							rd.include(req, res);
						    
		       }				
	         else {
					pw.println("<h1 style='color:blue ;text-align :center'>Login Failed: Wrong usename and passsword:: </h1>");
				}//else-rs.next
					
		
					
						
				}
					//pw.println("<span style='text-align:center;'><a href='search.html'>Search</a></span>");
					//pw.println("<span style='text-align:center;'><a href='login.html'>Home</a></span>");
					//close stram
					pw.close();
				}//try2
		}	
   catch(SQLException se) {
		pw.println("SQL Exception:: "+se.getMessage());
		se.printStackTrace();
		}catch(Exception e) {
			pw.println("Unknown Exception:: "+e.getMessage());
			e.printStackTrace();
		}
	}//doget
		private Connection getPooledConnection() throws Exception {
			//create intialContext object
			InitialContext ic = new InitialContext();
			//Get DataSource obj ref from Jndi registery through lookup operation
			DataSource ds=(DataSource)ic.lookup("dsJndi");
			Connection con = ds.getConnection();
			return con;

		}



	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost

}//class
