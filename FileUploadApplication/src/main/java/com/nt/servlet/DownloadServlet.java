package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {
	private static final String GET_PHOTO_PATH_BY_NO = "SELECT RESUME_PATH FROM CUSTOMER_INFO WHERE CNO=?";
	private static final String GET_RESUME_PATH_BY_NO = "SELECT PHOTO_PATH FROM CUSTOMER_INFO WHERE CNO=?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Check which download hyperlink is clicked(resume or photo)
		String query=null;
		int eno=0;
		if(req.getParameter("resumeid")!=null) {  //for resume
			query=GET_RESUME_PATH_BY_NO;
			eno=Integer.parseInt(req.getParameter("resumeid"));
		}
		else {  //for photo
			query=GET_PHOTO_PATH_BY_NO;
			eno=Integer.parseInt(req.getParameter("photoid"));
		}
		//Load the JDBC driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}

		String filePath=null;
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				PreparedStatement ps = con.prepareStatement(query);
				){
			//Set values to query param
			ps.setInt(1, eno);

			//Execute the query
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next())
					filePath=rs.getString(1);
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//Get the length of the file and make it as response content length
		File file = new File(filePath);
		res.setContentLengthLong(file.length());

		//Get file content type (MIME type) and make it as response content type
		ServletContext sc = getServletContext();
		String mimeType = sc.getMimeType(filePath);
		mimeType=mimeType!=null?mimeType:"application/octet-stream";
		res.setContentType(mimeType);

		//Give Instruction to browser to make the received content as the downloadable file content
		res.setHeader("Content-Disposition","attachment;fileName="+file.getName());

		//Create InputStream pointing to the file
		InputStream is = new FileInputStream(filePath);

		//Create OutputStream pointing to response object
		OutputStream os = res.getOutputStream();  //byte stream is taken to deal with both text, non-text content

		//Copy file content to response object(this completes file downloading
		IOUtils.copy(is, os);

		//Close streams
		is.close();
		os.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
