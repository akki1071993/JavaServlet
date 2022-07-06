<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8">
<meta name="viewreport" content="width=device-width, initial-scale=1.0">
<title>Registration Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script type="text/javascript"
	src='https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.min.js'></script>
<script type="text/javascript"
	src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.3/js/bootstrap.min.js'></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet" />
<script src="https://kit.fontawesome.com/92e9dde9ec.js"
	crossorigin="anonymous">
	
</script>

<script type="text/javascript">
	window.onload = function() {
		var txtPassword = document.getElementById("txtPassword");
		var txtConfirmPassword = document.getElementById("txtConfirmPassword");
		txtPassword.onchange = ConfirmPassword;
		txtConfirmPassword.onkeyup = ConfirmPassword;
		function ConfirmPassword() {
			txtConfirmPassword.setCustomValidity("");
			if (txtPassword.value != txtConfirmPassword.value) {
				txtConfirmPassword.setCustomValidity("Passwords do not match.");
			}
		}
	}
</script>
<style type="text/css">
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
	margin-left: 20%;
	margin-bottom: 2%;
	margin-top: 2%;
	border-radius: 5px;
}
</style>
</head>


<body>

	<%
	HttpSession userSession = request.getSession();
	String uname = (String) userSession.getAttribute("uname");
	String uemail = (String) userSession.getAttribute("uemail");
	%>

	<div
		class="container-fluid banner justify-content-center align-items-center">
		<div class="row g-2">

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
			<div class="row align-items-center" style="width: 100%;">
				<div class="col-md-8 bg-secondary booking">
					<p class="mt-3">Search Flights:</p>
					<form action="UserSearchFlight" method="post">
						<div class="container">
							<div class="row">
								<div class="col-md-4">
									<label for="phone" class="col-form-label">Departure:</label> <select
										class="form-control" name="departure" id="from">
										<option value="Delhi">Delhi</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Vadodara">Vadodara</option>
										<option value="Chennai">Chennai</option>
									</select>
								</div>
								<div class="col-md-4">

									<label for="phone" class="col-form-label">Arrival:</label> <select
										class="form-control" name="arrival" id="to">
										<option value="Delhi">Delhi</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Vadodara">Vadodara</option>
										<option value="Chennai">Chennai</option>
									</select>


								</div>
								

								<div class="col-md-4">
									<label for="phone" class="col-form-label">Travel Date date:</label> 
									<input
										class="form-control" type="datetime-local" id="start"
										name="date_of_travel" value="2022-07-06" min="2022-07-06" max="2023-12-31"
										required>


								</div>
								<div class="col-md-4">
									<input style="margin-top: 25px;" type="submit"
										class="btn btn-primary" value="Submit">
								</div>
							</div>


						</div>
					</form>

				</div>
			</div>
		</div>
	</div>




</body>
</html>