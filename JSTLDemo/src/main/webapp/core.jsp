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

	<c:set var="income" value="${1000*5}"></c:set>
	<br> Income:
	<c:out value="${income}"></c:out>
	<c:remove var="income" />

	<br>
	<h3>After remove Income</h3>
	<c:out value="${income}"></c:out>
	<%--Like System.out.print --%>


	<c:catch var="ex">
		<%-- try and catch --%>
		<%
		int n = 10 / 0;
		%>
	</c:catch>
	<c:out value="${ex}"></c:out>
	<br>

	<c:set var="nub" value="${1000}"></c:set>
	<c:if test="${nub>999}">
		<%-- like simple if --%>
		<c:out value="The value is more then 500, Value is:  ${nub}">
			<br>
		</c:out>
	</c:if>
	<br>
	<c:choose>
		<%-- Like If else Statement --%>
		<c:when test="${nub > 1500 }">
			<c:out value="The value is more then 1000:">
				<br>
			</c:out>
		</c:when>
		<c:otherwise>
			<c:out value="The value is not more then 1000">
				<br>
			</c:out>
		</c:otherwise>
	</c:choose>
	
	<h3>For Tokens</h3>
	<c:forTokens items="_1_2_3_4_5_6_7_8_9" delims="_" var="s">
		<c:out value="${s}" />
	</c:forTokens>




</body>
</html>