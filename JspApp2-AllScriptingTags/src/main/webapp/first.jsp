<%! 
     //Delclarative tag
     public void jspinit(){
         
           ServletConfig cg = getServletConfig();
           ServletContext sc= getServletContext();
           System.out.println("config obj class name"  +cg.getClass()  +cg.hashCode());
            System.out.println("application  obj class name"  +sc.getClass()  +sc.hashCode());
        
}
%>

<b> Driver loaded</b>
//expression Tag
"config obj class name" <%= application.getClass() %> 
                                               <%=application.hashCode() %><br>
"config obj class name" <%= config.getClass() %> 
                                                 <%=config.hashCode() %><br>
            