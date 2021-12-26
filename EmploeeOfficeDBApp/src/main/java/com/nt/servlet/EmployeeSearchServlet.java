package com.nt.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/dburl")
public class EmployeeSearchServlet extends HttpServlet {
	 private static final String  GET_EMP_BY_ENO="SELECT EMPNO,ENAME,SAL,JOB ,DEPTNO FROM EMP  WHERE EMPNO=?";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	System.out.println("EmployeeSearchServlet.doGet()");
    	//get PrintWriter
    	PrintWriter pw = res.getWriter();
    	//Set responceContent type
    	res.setContentType("text/html");
    	//read form data
    	int no =Integer.parseInt(req.getParameter("eno"));
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
    	}
    	catch(ClassNotFoundException cnf) {
    		pw.println(cnf.getMessage());
    		cnf.printStackTrace();
    	}
    	//Write jdbc code
    	try(Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
    			PreparedStatement ps = con.prepareStatement(GET_EMP_BY_ENO)){
    		if(ps!=null)
    			ps.setInt(1, no);
    		try(ResultSet rs =ps.executeQuery()){
    			if(rs!=null) {
    				if(rs.next()) {
    					pw.println("<h1 style='color:blue ;text-align :center'>Employee Details are:::</h1>");
    					pw.println("<p style='text-align:center'><b> Employee Number::"+rs.getInt(1)+"</b><br>");
    					pw.println("<b>Employee Name::"+rs.getString(2)+"</b><br>");
    					pw.println("<b>Employee DESG::"+rs.getString(4)+"</b><br>");
    					pw.println("<b>Employee Salary::"+rs.getString(3)+"</b><br>");
    					pw.println("<b>Employee Dept no::"+rs.getInt(5)+"</b><br>");	
    				}//if
    				else{
    					pw.println("<h1 style='color:red ;text-align:center'>Employee Not Found::</h1>");
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
    	}
    }//doget
    @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}//class
