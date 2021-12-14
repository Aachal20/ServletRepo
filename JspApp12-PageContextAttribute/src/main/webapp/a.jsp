

<b style="color:red"> From a.jsp</b>
<%
//create All the 4 scope of attribute

//page scope
pageContext.setAttribute("attr1" ,"val1");
//request scope
pageContext.setAttribute("attr2" ,"val2"  ,pageContext.REQUEST_SCOPE);
//SESSION SCOPE
pageContext.setAttribute("attr3" , "val3" , pageContext.SESSION_SCOPE);
//aPPLICATION scope
pageContext.setAttribute("attr4" , "val4" , pageContext.APPLICATION_SCOPE);

%>
<jsp:forward page="b.jsp"/>