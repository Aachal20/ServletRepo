package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO CUSTOMER_INFO VALUES(PID_SEQ.NEXTVAL,?,?,?,?)";

	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");

		try { 
			//create special request object as wrapper around req object
			MultipartFormDataRequest nreq  = new MultipartFormDataRequest(req);
			//read form data (simple text-boxes data)
			String name=nreq.getParameter("cname");
			String addr=nreq.getParameter("caddr");
			//specify file upload setting 
			UploadBean ub = new UploadBean();
			
			//set folder location in server machine
			ub.setFolderstore("E:\\store");
			//perform uploading
			ub.store(nreq);
			ub.setOverwrite(false);
			ub.setFilesizelimit(100*1024);

			//get the list of the file that are uploaded
			Hashtable<String ,UploadFile> ht = nreq.getFiles();
			
			String photo=ht.get("f1").getFileName();
			String profile=ht.get("photo").getFileName();
			pw.println("<h1 style='color:yellow'> Customer Profile is :::"     +profile+ "      Customer photo is :::"+photo+   "    uploaded succefully </h1>");

			//write the jdbc code
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try(Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system " , "manager");
					PreparedStatement ps = con.prepareStatement(INSERT_QUERY);    ){
				//SET VALUES TO query param
			 
				ps.setString(1, name);
				ps.setString(2,addr);
				ps.setString(3,"E:\\store\\"+photo);
				ps.setString(4,"E:\\store\\"+profile);
				//execute the query
				int result=ps.executeUpdate();
               	//process the resultset
				if(result==0)
					pw.println("<h1 style='color:red ; text-align:center'> Customer not register </h1>");
				else
					pw.println("<h1 style='color:blue ; text-align:center'> customer register</h1>");
			
				//Add home hyperlink
				pw.println("<br><h1 style='text-align:center'><a href='registerCustomer.html'>Home</a></h1>");
			}//try2
			
		}//try1
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red ; text-align:center'> Exception occour At FileUploading</h1>");
			System.out.println("exception e");
		}
		//close stream
		pw.close();
	}//doget
	@Override
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//dopost
}//class