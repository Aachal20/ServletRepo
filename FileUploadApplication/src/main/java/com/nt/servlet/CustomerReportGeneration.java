package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;
@WebServlet("/reporturl")
public class CustomerReportGeneration extends HttpServlet {

	private static final String GET_ALL_CUSTOMER="SELECT * FROM  CUSTOMER_INFO ";

	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");

		try {
			//write the jdbc code
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system " , "manager");
					PreparedStatement ps = con.prepareStatement(GET_ALL_CUSTOMER);    ){
				//execute the query
				ResultSet rs = ps.executeQuery();
				//process the resultset
				pw.println("<h1 style='color:red ; text-align:center'> Customer Info </h1>");
				pw.println("<table border='1' bgcolor='pink' align='center'> ");
				pw.println("<tr><th>CNO</th> <th>CNAME</th> <th>Customer Address</th><th>Customer Resume</th><th>Customer Photo</th> </tr> ");
				while(rs.next()) {

					pw.println("<tr>");
					pw.println("<td>" +rs.getInt(1)+ "</td>");
					pw.println("<td>" +rs.getString(2)+ "</td>");
					pw.println("<td>" +rs.getString(3)+ "</td>");

					//pw.println("<td><a href='downloadurl?pid=" +rs.getInt(1)+ "' Download photo</a></td>");
					//pw.println("<td ><a href='downloadurl?rid=" +rs.getInt(1)+ "' Download Resume</a></td>");
					pw.println("<td><a href='downloadurl?resumeid="+rs.getInt(1)+"'>Download Resume</a></td>");
					pw.println("<td><a href='downloadurl?photoid="+rs.getInt(1)+"'>Download Photo</a></td>");
					pw.println("</tr> ");
				}
				pw.println("</table> ");
				//Add home hyperlink
				pw.println("<br><h1 style='text-align:center'><a href='registerCustomer.html'>Home</a></h1>");

			}//try2
		}//try1
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red ; text-align:center'> Exception occour In Showing Customer Data From DB</h1>");
			System.out.println("exception e" +e.getMessage());
		}
	}//doget
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//dopost

}//class


