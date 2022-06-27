<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--Scripting-->

	<%
	int a = 10;
	int b = 20;
	int c = a + b;
	out.print("Result is" + c);
	%>
	<!-- Declaration  -->

	<%!String name = "Akash Mahant";%>

	<h1><%=name%></h1>

	<!-- Expression   -->
	<%!int cube(int n) {
	return n * n * n;
}%>
	<%=	"Cube of 5: "+ cube(5)%>
	<%=	new java.util.Date()  %>
	


</body>
</html>