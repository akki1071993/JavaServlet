<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<sql:setDataSource var="conn" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/ecommerce" user="root"
		password="akki@123" />

	<sql:query var="result" dataSource="${conn}">	
	select * from eproduct	
	</sql:query>

	<sql:update dataSource="${conn}" var="r">
	
	 UPDATE eproduct SET name=? where ID=?
	 <sql:param value="HP" />
	 <sql:param value="1" />
	</sql:update>

	<table border="1" cellspacing=0 cellpadding=10>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date</th>
			<th>Price</th>
		</tr>

		<c:forEach items="${result.rows }" var="d">
			<tr>
				<td><c:out value="${d.id}"></c:out></td>
				<td><c:out value="${d.name} "></c:out></td>
				<td><c:out value="${d.date_added }"></c:out></td>
				<td><c:out value="${d.price} "></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>