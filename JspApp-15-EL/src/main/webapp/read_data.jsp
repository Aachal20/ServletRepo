<%@ page language="java" 
        isELIgnored="false" %>
      <!--  attr1(page Scope) value :: $ {pageScope.attr1} <br>
       attr2(request scope) value ::  $ {requestScope.attr2}<br>
       attr3(session scope) value :: $ {sessionScope.attr3}<br>
         attr3(application  scope) value::$ {applicationScope.attr4}<br> -->
         attr1(page scope) value :: ${pageScope.attr1}
	<br> attr2(request scope) value :: ${requestScope.attr2}
	<br> attr3(session scope) value :: ${sessionScope.attr3}
	<br> attr4(application scope) value :: ${applicationScope.attr4}
	<br>
         Cookie Name :::$ {cookie.JSESSIONID.name}<br>
          Cookie value(sessionId) ::: $ {cookie.JSESSIONID.value}<br>