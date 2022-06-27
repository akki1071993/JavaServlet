<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="obj" class="akash.jsp.demo.Student" scope="session"></jsp:useBean>

<h2>Before  Set value</h2>
<jsp:getProperty  property="rollNo" name="obj"/><br><br>
<jsp:getProperty  property="name" name="obj"/><br><br>
<jsp:getProperty  property="email" name="obj"/><br><br>

<jsp:setProperty property="rollNo" name="obj" value="103"/>
<jsp:setProperty property="name" name="obj" value="Akash Mahant"/>
<jsp:setProperty property="email" name="obj" value="akash.mhanat@gmail.com" />

<h2>After Set value</h2>
<jsp:getProperty  property="rollNo" name="obj"/><br><br>
<jsp:getProperty  property="name" name="obj"/><br><br>
<jsp:getProperty  property="email" name="obj"/><br><br>

<a href="next.jsp">Next page</a>
</body>
</html>