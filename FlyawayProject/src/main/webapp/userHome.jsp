<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	color: #fff;
}

.banner {
	height: 100vh;
	width: 100%;
	background: url('./assets/airline2.jpg');
	background-position: right;
	background-attachment: fixed;
	background-repeat: no-repeat;
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

.info {
	margin-left: 7%;
	margin-top: 3%;
	color: #fff;
	background: #e91d43;
	font-size: 2em;
	font-weight: 600;
	width: 220px;
	white-space: nowrap;
}

.info a:hover {
	background: #e91e63;
}
</style>
</head>
<body>
	<%
	HttpSession userSession = request.getSession();
	String uname = (String) userSession.getAttribute("uname");
	String uemail = (String) userSession.getAttribute("uemail");
	%>

	<div class="container-fluid banner">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<%
					if (uemail != null) {
					%>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="userChangePassword.jsp"><i class="fas fa-user-cog"></i>
								<%
								out.print("Welcome   " + uname);
								%></a></li>
					</ul>

					<ul class="nav">

					</ul>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="UserViewBooking"> <i class="fas fa-user-cog"></i>
								Booking Details
						</a></li>
						<li class="nav-item"><a class="nav-link text-dark"
							href="UserLogout"><i class="fas fa-user-cog"></i> Logout </a></li>

					</ul>
					<%
					} else {
					%>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="userHome.jsp"><i class="fas fa-user-cog"></i> Home</a></li>
					</ul>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="userLogin.html"><i class="fas fa-user-cog"></i> Login</a></li>
					</ul>

					<%
					}
					%>



				</nav>
			</div>
			<div class="col-md-12">
				<h2 class="text-center text-dark">Welcome to FlyAway booking
					portal</h2>

			</div>
			<div class="row">
				<div class="col-md-12 pt-5 mt-5">
					<a href="userSearchFlights.jsp" class="btn btn-lg text-center info">Search Flight</a>
				</div>
			</div>
		</div>
	</div>


</body>
</html>