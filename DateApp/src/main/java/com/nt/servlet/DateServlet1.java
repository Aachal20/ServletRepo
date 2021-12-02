package com.nt.servlet;

import javax.servlet.*;
import java.io.*;
import java.util.*;

public class DateServlet1  extends GenericServlet
{
	
     public void service(ServletRequest req ,ServletResponse res)throws ServletException , IOException{
       //set response content type
       res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        Date d =  new Date();

     

       //pw.println("<h1> Date and Time is a::"+d+"</h1>");
       pw.println("<h1 style='color:red;text-align:center'> Date and Time is  :::: "+d+"</h1>");
       pw.println("<h2 style='color:red'> Welcome To Servlet"+d+"</h2>");
         
         pw.println("<h1 style='color:blue'> Welcome to Servlet</h1>");
       // pw.println("<br><b>Current servlet  class obj hashcode" +this.hashcode() "</b>");    
       pw.println("<br><b>req obj hashcode " +req.hashCode()+"</b>");
       // pw.println("<br><b>res obj hashcode " +res.hashcode()+ "</b>");
       pw.println("<br><b>current threadf obj hashcode " +Thread.currentThread().hashCode()+"---current thread name:::</b>"+Thread.currentThread().getName());
       pw.close();

    }//service

}//class