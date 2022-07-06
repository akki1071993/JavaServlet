<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.services.AdminServices"%>
<%@ page import="com.dao.Flight"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewreport" content="width=device-width, initial-scale=1.0">
<title>FlyAway</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/92e9dde9ec.js"
	crossorigin="anonymous"></script>
<style>
body {
	margin: 0;
	padding: 0;
	background: #fff;
	font-family: 'Raleway', sans-serif;
	background: url('./assets/airline1.jpg');
	color: #fff;
}

.banner {
	height: 100vh;
	width: 100%;
}

.banner .navbar {
	margin-top: 2%;
}

.banner .navbar-brand {
	color: #fff;
	font-size: 1.8em;
	font-weight: 700;
	margin-left: 7%;
}

.banner .nav {
	margin-right: 7%;
}

.banner .nav li a {
	color: #aaa;
	font-size: 1.5em;
}

.banner p {
	font-weight: 500;
	letter-spacing: 2px;
}

.login {
	margin-left: 50%;
}

tr:nth-child(even) {
	background-color: #D6EEEE;
}

tr:hover {
	background-color: #D6EEEE;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>






</head>



<body>
	<div
		class="container-fluid banner justify-content-center align-items-center">
		<div class="row g-2">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand text-dark">
						<a href="userHome.jsp" class="text-decoration-none text-dark"><i
							class="fas fa-plane"></i> Home</a>
					</div>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="userLogout"><i class="fas fa-user-cog"></i> Logout</a></li>
					</ul>
				</nav>
			</div>
			
		</div>

		<div class="container">
			<div class="row text-dark">
				<div class="col-md-12 mb-3">
					<table style="width: 100%; text-align: center;">
						<tr>
							<th>Flight Id</th>
							<th>Flight Code</th>
							<th>Airline</th>
							<th>Departure</th>
							<th>Arrival</th>
							<th>Weekdays</th>
							<th>Business Fare</th>
							<th>Economic Fare</th>
							<th>Prime Fare</th>

						</tr>

						<c:forEach items="${flightData}" var="flight">
							<tr>
								<td>${flight.getF_id()}</td>
								<td>${flight.getF_code()}</td>
								<td>${flight.getAirline()}</td>
								<td>${flight.getDeparture()}</td>
								<td>${flight.getArrival()}</td>
								<td>${flight.getWeekdays()}</td>
								<td>${flight.getBusiness_fare()}</td>
								<td>${flight.getEconomic_fare()}</td>
								<td>${flight.getPrime_fare()}</td>
								<th><a href= 'UserBooking?f_id=${flight.getF_id()}'>Book</a></th>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	



</body>





</body>
</html>