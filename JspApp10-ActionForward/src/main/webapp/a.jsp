<b>stat of a.jsp</b>
<br>

<% float price =500+500*1.2f; %>
<jsp:forward page="b.jsp">
  <jsp:param value="java" name="BookName"/>
  <jsp:param value="<%=price %>" name="cost"/>
</jsp:forward>
<b>End of JSP</b>