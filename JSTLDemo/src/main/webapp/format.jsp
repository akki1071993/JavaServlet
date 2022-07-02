<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set value="${1000/3}" var="num" />
		<c:set value="${100000}" var="num1" />
	<h2>
		<fmt:formatNumber maxFractionDigits="5" value="${num}" /> <br><br>
		
		<fmt:formatNumber minFractionDigits="2" value="${num1}" /><br><br>
		
		<fmt:formatNumber groupingUsed="false" minFractionDigits="2" value="${num1}" /><br><br>
	</h2>
	
	
	<c:set var="today" value="<%= new Date() %>"/>
	Small Date: <fmt:formatDate value="${today }" dateStyle="short" timeStyle="short" type="both"/><br>
	Medium Date : <fmt:formatDate value="${today }" dateStyle="medium" timeStyle="medium" type="both" /> <br>
	long Date: <fmt:formatDate value="${today}" dateStyle="long" timeStyle="long" type="both"/><br>
	
	Formatted date: <fmt:formatDate value="${today }" pattern="dd/MM/yyy"/>
	
	
	
	
	
</body>
</html>