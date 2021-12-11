
<%@page import="java.time.LocalDateTime"%>
<%!
   public String generateWishMessage(String user){
       //get system date and time
           java.time.LocalDateTime ldt = java.time.LocalDateTime.now();
      //get current hour of day
           int hour = ldt.getHour();
       //generate wishmessage
        if(hour<12)
            return "GM::" +user;
        else if(hour<16)
           return "Good Afternoon::" +user;
         else if(hour<22)
           return "Good Evening::" +user;
        else
             return "Good Night::" +user;
           }
          %>

<h1 style="color: red; text-align: center">Welcome to java server
	pages</h1>
<br>
<h1 style="color: green; text-align: center">
	Date and Time is:::<%= new java.util.Date()  %></h1>
	<% String name ="raja" ; %>
	  name:::<%= name %>
<br>
 <b> The Wish Message is :::<%--<%= generateWishMessage("Aachal") --%>--%></b>

