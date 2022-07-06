<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.dao.Booking"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.math.BigDecimal"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewreport" content="width=device-width, initial-scale=1.0">
<title>Checkout</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
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
	height: 100vh;
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
	font-size: 2em;
	font-weight: 500;
	letter-spacing: 2px;
}

.booking {
	margin-left: 30%;
	margin-bottom: 2%;
	margin-top: 2%;
	border-radius: 5px;
	margin-top: 2%;
}
</style>
</head>

<body>
	<div class="container-fluid banner">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand text-dark">
						<a href="userHome.jsp" class="text-decoration-none text-dark"><i
							class="fas fa-plane"></i>Home</a>
					</div>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="UserLogout"><i class="fas fa-user-cog"></i> Logout</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-12">
				<h2 class="text-center text-dark">Booking Done !</h2>
			</div>
		</div>
	</div>


	<div class="row align-items-center" style="width: 100%;">
		<div class="col-md-5 bg-secondary booking">
			<br>


			<div class="container" style="text-align: center;">
				<div class="row">

					<h1>Booking Successfully Done </h1>

				</div>
			</div>
		</div>
	</div>
</body>




</html>