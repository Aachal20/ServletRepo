

<!-- Read and display pageContext Attribute Value -->
<b>From b.jsp</b>
<b>attr1 (page scope) value::<%=pageContext.findAttribute("attr1")  %></b><br>
<b>attr2(request scope)::<%=pageContext.findAttribute("attr2") %></b><br>
<b>attr3(Session scope)::<%=pageContext.findAttribute("attr3") %></b><br>
<b>attr4(Application scope)::<%=pageContext.findAttribute("attr4") %></b><br>

<jsp:forward page="c.jsp"/>