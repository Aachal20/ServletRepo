package com.nt.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	 private static final String  GET_EMP_BY_CNO="SELECT CNO,CNAME,SAL,JOB FROM CUSTO   WHERE CNO=?";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	System.out.println("EmployeeSearchServlet.doGet()");
    	//get PrintWriter
    	PrintWriter pw = res.getWriter();
    	//Set responceContent type
    	res.setContentType("text/html");
    	//get acces to servletConfig object
    	ServletConfig cg = getServletConfig();
    	//read servlet init param values
    	String driver =cg.getInitParameter("driverclass");
    	String url = cg.getInitParameter("url");
    	String user =cg.getInitParameter("dbuser");
    	String pwd =cg.getInitParameter("dbpwd");
    	//read form data
    	int no =Integer.parseInt(req.getParameter("cno"));
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    	}
    	catch(ClassNotFoundException cnf) {
    		pw.println(cnf.getMessage());
    		cnf.printStackTrace();
    	}
    	//Write jdbc code
    	try(Connection con = DriverManager.getConnection(url,user,pwd);
    			PreparedStatement ps = con.prepareStatement(GET_EMP_BY_CNO)){
    		if(ps!=null)
    			ps.setInt(1, no);
    		try(ResultSet rs =ps.executeQuery()){
    			if(rs!=null) {
    				if(rs.next()) {
    					pw.println("<h1 style='color:blue ;text-align :center'>Employee Details are:::</h1>");
    					pw.println("<p style='text-align:center'><b>Customer Number::"+rs.getInt(1)+"</b><br>");
    					pw.println("<b>Customer Name::"+rs.getString(2)+"</b><br>");
    					pw.println("<b>Customer sal::"+rs.getInt(3)+"</b><br>");
    					pw.println("<b>Customer job::"+rs.getString(4)+"</b><br>");	
    					pw.println("<hr>");
    					pw.println("<br><b>servlet config object class name ::" +cg.getClass()+"</b>");
    					pw.println("<b>servlet  name ::" +cg.getServletName()+"</b><br>");
    					pw.println("<b>servlet  name ::" +cg.getServletName()+"</b><br>");
    				}//if
    				else{
    					pw.println("<h1 style='color:red ;text-align:center'>Custmer Not Found::</h1>");
    				}//else
    			}//if
    			pw.println("<br><br><p style='text-align:center;'><a href='search.html'>Home</a></p>");
    			//close stram
    			pw.close();
    		}//try2
    	}//try1
    	catch(SQLException se) {
    		pw.println("SQL Exception:: "+se.getMessage());
    		se.printStackTrace();
    	}catch(Exception e) {
    		pw.println("Unknown Exception:: "+e.getMessage());
    		e.printStackTrace();
    	}
    }//doget
    @Override
  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
      doGet(req, res);
    }
}//class
