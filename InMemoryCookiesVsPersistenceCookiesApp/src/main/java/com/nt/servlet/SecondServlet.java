package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw= res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read cookies
		Cookie cookies[]=req.getCookies();
		
		if(cookies!=null) {
			//display cookies as HTML table Content

			pw.println("<table border=' bgcolor=pink' align='center'>");
			for(Cookie ck:cookies) {
				pw.println("<tr><td>"+ck.getName()+ "</td><td>" +ck.getValue()+"</td></tr>" );
			}

			pw.print("</table>");
		}
		else {
		pw.println("No Cookies Present");
	}
	//close strem
	pw.close();
}//doGet


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
