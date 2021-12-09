
<%@ page import="com.nt.beans.*, com.nt.service.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PaySlip Process</title>
</head>
<body>
	<!-- Create/Locate Java bean class object -->
	<jsp:useBean id="emp" class="com.nt.beans.Employee" scope="request" />

	<!-- Write form data to have Java Bean class object -->
	<jsp:setProperty name="emp" property="*" />

	<!-- Create/Locate service class object -->
	<jsp:useBean id="service"
		class="com.nt.service.PaySlipGeneratorService" scope="application" />

	<!-- Invoke the business method -->
	<%
	service.generatePaySlip(emp);
	%>
<!-- Read the input and result from java bean class object and  display on the browser-->

<h1 style="color: red; text-align: center">Employee PaySlip Repor </h1>


	<table border="1" bgcolor="yellow" align="center">
		<tr>
			<td>Employee Name::</td>
			<td> <jsp:getProperty  property ="ename" name="emp"/></td>
		</tr>
		<tr>
			<td>Employee Address::</td>
			<td> <jsp:getProperty  property ="eadd" name="emp"/></td>
		</tr>
		
		<tr>
			<td>Employee GrossSalary::</td>
			<td> <jsp:getProperty  property ="grossSalary" name="emp"/></td>
		</tr>
		<tr>
			<td>Employee NetSalary::</td>
			<td> <jsp:getProperty  property ="netSalary" name="emp"/></td>
		</tr>
		<tr>
			<td>Employee BasicSalary::</td>
			<td> <jsp:getProperty  property ="basicSalary" name="emp"/></td>
		</tr>
		
		<br>
		<a href= "emp_details.html">Home</a>