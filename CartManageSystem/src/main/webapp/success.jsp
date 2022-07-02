<%@page import="com.akash.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<c:set var="pdata" value="${sessionScope.productList}"></c:set>



	<table border="1" cellspacing=0 cellpadding=10>
		<tr>
			<th>Id</th>
			<th>Product Name</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${productList}" var="p">
			<tr>
				<td><c:out value="${p.pid}"></c:out></td>
				<td><c:out value="${p.pname}"></c:out></td>
				<td><c:out value="${p.pprice}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="index.jsp">Add new </a>

</body>
</html>