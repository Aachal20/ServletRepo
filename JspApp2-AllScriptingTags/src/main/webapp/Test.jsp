<h1 style="color:red">jsp implicit obj information</h1>

out obj class name  <%= request.getClass() %><br>
out obj class name  <%= out.getClass() %><br>
out obj class name  <%= response.getClass() %><br>
out obj class name  <%= config.getClass() %><br>
out obj class name  <%= application.getClass() %><br>
out obj class name  <%= session.getClass() %><br>
out obj class name  <%= page.getClass() %><br>
out obj class name  <%= pageContext.getClass() %><br>
out obj class name  <%= request.getClass() %><br>
<%-- <%! public void jspInit(){ --%>
//     Class.forName("oracle.jdbc.driver.OracleDriver");
//     System.out.println("driver loaded");
//     }
<%--     %> --%>
<%!
static {
    System.out.println("first_jsp ststick block");
}

%>