<b>stat of a.jsp</b>
<br>

<%
   //read request param value
   String search=request.getParameter("ss");


//perform sendRedirection
response.sendRedirect("https://www.google.com/search?q=" +search);
%>