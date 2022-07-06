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
String uemail = (String) userSession.getAttribute("uemail");
int uid = (Integer) userSession.getAttribute("uid");

HttpSession bookFlightSession = request.getSession();

Booking booking = new Booking();

booking.setC_id(uid);
booking.setF_id((Integer) session.getAttribute("f_id"));
booking.setDate_of_travel(Date.valueOf(request.getParameter("date_of_travel")));//converting string into SQL date
booking.setNo_of_passenger(Integer.parseInt(request.getParameter("no_of_passenger")));
booking.setType(request.getParameter("type"));

bookFlightSession.setAttribute("c_id", uid);
bookFlightSession.setAttribute("f_id", (Integer) session.getAttribute("f_id"));
bookFlightSession.setAttribute("date_of_travel", Date.valueOf(request.getParameter("date_of_travel")));
bookFlightSession.setAttribute("no_of_passenger", Integer.parseInt(request.getParameter("no_of_passenger")));
bookFlightSession.setAttribute("type", request.getParameter("type"));

BigDecimal totalFare = null;
BigDecimal total_no_passenger = new BigDecimal(booking.getNo_of_passenger());
if (booking.getType().equals("economic_fare")) {

	BigDecimal economic_fare = (BigDecimal) session.getAttribute("economic_fare");
	totalFare = economic_fare.multiply(total_no_passenger);

}
if (booking.getType().equals("business_fare")) {

	BigDecimal business_fare = (BigDecimal) session.getAttribute("business_fare");
	totalFare = business_fare.multiply(total_no_passenger);

}
if (booking.getType().equals("prime_fare")) {

	BigDecimal prime_fare = (BigDecimal) session.getAttribute("prime_fare");
	totalFare = prime_fare.multiply(total_no_passenger);

}
booking.setTotal_fare(totalFare);

bookFlightSession.setAttribute("total_fare", booking.getTotal_fare());

String type = (String) bookFlightSession.getAttribute("type");
Date date_of_travel = (Date.valueOf(request.getParameter("date_of_travel")));
BigDecimal total_fare = (BigDecimal) bookFlightSession.getAttribute("total_fare");
int no_of_passenger = (Integer) bookFlightSession.getAttribute("no_of_passenger");
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
				<h2 class="text-center text-dark">Payment Portal</h2>
			</div>
		</div>
	</div>


	<div class="row align-items-center" style="width: 100%;">
		<div class="col-md-8 bg-secondary booking">
			<br>

			<form name="contact-form" action="UserBookingConformation" method="post">
				<div class="container">
					<div style="margin-bottom: 5%;" class="row">
						<div class="col-md-3">

							<label for="cardname" class="col-form-label">Total
								Amounts</label> <input value="${total_fare}" disabled="disabled"
								type="text" class="form-control" id="total_fare"
								name="total_fare"> <label for="cardname"
								class="col-form-label">Date of travel</label> <input
								value="${date_of_travel}" disabled="disabled" type="text"
								class="form-control" id="date_of_travel" name="date_of_travel"
								required>
						</div>
						<div class="col-md-3">
							<label for="cardname" class="col-form-label">Total
								Passenger</label> <input value="${no_of_passenger}" disabled="disabled"
								type="text" class="form-control" id="no_of_passenger"
								name="no_of_passenger" required> <label for="cardname"
								class="col-form-label">Class </label> <input value="${type}"
								disabled="disabled" type="text" class="form-control" id="type"
								name="type">
						</div>
						<div class="col-md-3">

							<label for="cardname" class="col-form-label">Enter Card
								No</label> <input type="text" class="form-control"
								required> <label for="cardname"
								class="col-form-label">Valid Thru</label> <input type="text"
								class="form-control">
						</div>
						<div class="col-md-3">

							<label for="cardname" class="col-form-label">Card Holder
								Name</label> <input type="text" class="form-control" required> <label for="cardname"
								class="col-form-label">CVV</label> <input type="password"
								class="form-control">
						</div>

					</div>
					<div class="col-md-3">
						<input type="submit" style="margin-bottom: 15%"
							class="btn btn-primary" value="Payment Confirm">

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