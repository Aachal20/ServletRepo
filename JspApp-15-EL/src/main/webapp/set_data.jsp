<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        isELIgnored="false" %>
        <% 
                pageContext.setAttribute("attr1" , "val1");
                  pageContext.setAttribute("attr1 ,val1" ,pageContext.REQUEST_SCOPE);
                pageContext.setAttribute("attr1 ,val1" ,pageContext.SESSION_SCOPE);
                pageContext.setAttribute("attr1 ,val1" ,pageContext.APPLICATION_SCOPE);
                
                
                
                
                %>
                <jsp:forward page="read_data.jsp"></jsp:forward>