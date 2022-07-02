<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:set var="books">
		<books> <book> <name>2020 India goal</name> <author>Hiren
		Vays</author> </book> <book> <name>WWII</name> <author>Katani Jonh</author> </book> <el>
		<name>Pop</name> <no>2</no> </el> <el> <name>top</name> <no>3</no> </el> </books>
	</c:set>
	<x:parse xml="${books }" var="data"></x:parse>
	1st Book Name & Book Author::
	<x:out select="$data/books/book[1]/name" />
	<br>
	<x:out select="$data/books/book[1]/author" />
	<br> 2nd Book Author:
	<x:out select="$data/books/book[2]/name" />
	<br>
	<x:out select="$data/books/book[2]/author" />
	<br>
	<x:out select="$data/books/el[1]/name" />
	<br>
	<x:out select="$data/books/el[1]/no" />
	<br>
	<x:out select="$data/books/el[2]/name" />
	<br>
	<x:out select="$data/books/el[2]/no" />
</body>
</html>