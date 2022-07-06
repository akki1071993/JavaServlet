<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	margin-left: 18%;
	margin-bottom: 5%;
	margin-top: 2%;
	border-radius: 5px;
	margin-top: 2%;
}
</style>
</head>
<%
//User data

HttpSession userSession = request.getSession();
String uname = (String) userSession.getAttribute("uname");
String uemail = (String) userSession.getAttribute("uemail");
String umobile = (String) userSession.getAttribute("umobile");

// Selecte Flight Datails 
int f_id = (Integer) session.getAttribute("f_id");
String f_code = (String) session.getAttribute("f_code");
String airline = (String) session.getAttribute("airline");
String departure = (String) session.getAttribute("departure");
String arrival = (String) session.getAttribute("arrival");
BigDecimal business_fare = (BigDecimal) session.getAttribute("business_fare");
BigDecimal economic_fare = (BigDecimal) session.getAttribute("economic_fare");
BigDecimal prime_fare = (BigDecimal) session.getAttribute("prime_fare");
%>

<%
if (uemail != null) {
%>

<body>
	<div class="container-fluid banner">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand text-dark">
						<a href="index.jsp" class="text-decoration-none text-dark"><i
							class="fas fa-plane"></i>FlyAway</a>
					</div>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="login.jsp"><i class="fas fa-user-cog"></i> Logout</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-12">
				<h2 class="text-center text-dark">FlyAway Ticket Booking</h2>
			</div>
		</div>
	</div>


	<div class="row align-items-center" style="width: 100%;">
		<div class="col-md-8 bg-secondary booking">
			<br>

			<form name="contact-form" action="userPayment.jsp"
				method="post">
				<div class="container">
					<div style="margin-bottom: 5%;" class="row">
						<div class="col-md-3">

							<label for="cardname" class="col-form-label">Your Name:</label> <input
								value="${uname}" disabled="disabled" type="text"
								class="form-control" id="uname" name="uname" required> <label
								for="cardname" class="col-form-label">Flight Code:</label> <input
								value="${f_code}" disabled="disabled" type="text"
								class="form-control" id="f_code" name="f_code"> <label
								for="cardname" class="col-form-label">Departure:</label> <input
								value="${departure}" disabled="disabled" type="text"
								class="form-control" id="departure" name="departure">
						</div>
						<div class="col-md-3">
							<label for="cardname" class="col-form-label">Your Mobile
								No:</label> <input value="${umobile}" disabled="disabled" type="text"
								class="form-control" id="uname" name="uname" required> <label
								for="cardname" class="col-form-label">Airline:</label> <input
								value="${airline}" disabled="disabled" type="text"
								class="form-control" id="cardname" name="airline"> <label
								for="cardname" class="col-form-label">Arrival:</label> <input
								value="${arrival}" disabled="disabled" type="text"
								class="form-control" id="arrival" name="arrival" required>


						</div>

						<div class="col-md-3">
							<label for="cardname" class="col-form-label">Business
								fare:</label> <input value="${business_fare}" disabled="disabled"
								type="text" class="form-control" id="business_fare"
								name="business_fare"> <label for="cardname"
								class="col-form-label">Economic fare:</label> <input
								value="${economic_fare}" disabled="disabled" type="text"
								class="form-control" id="economic_fare" name="economic_fare">
							<label for="cardname" class="col-form-label">Prime fare:</label>
							<input value="${prime_fare}" disabled="disabled" type="text"
								class="form-control" id="prime_fare" name="prime_fare">
						</div>

						<div class="col-md-3">

							<label for="phone" class="col-form-label">Select your
								Class</label> <select class="form-control" name="type" id="type"
								required>
								<option value="economic_fare">Economic</option>
								<option value="business_fare">Business</option>
								<option value="prime_fare">Prime</option>


							</select> <label for="phone" class="col-form-label">Travel Date
								date:</label> <input class="form-control" type="date"
								id="date_of_travel" name="date_of_travel" value="2022-07-06"
								min="2022-07-06" max="2023-12-31" required> <label
								for="phone" class="col-form-label">Total No of Travels:</label>
							<select class="form-control" name="no_of_passenger"
								id="no_of_passenger" required>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>

							</select>
						</div>


						<div class="col-md-3">
							<input style="margin-top: 25px; margin-bottom: 00px;"
								type="submit" class="btn btn-primary" value="Confirm booking">

						</div>
					</div>


				</div>
			</form>
		</div>
	</div>
</body>


<%
} else {

response.sendRedirect("userLogin.html");

}
%>
</html>