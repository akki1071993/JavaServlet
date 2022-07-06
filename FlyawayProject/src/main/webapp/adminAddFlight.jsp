<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	String email = (String) session.getAttribute("email");
	int adminid = (Integer) session.getAttribute("adminid");

	if (email != null) {
	%>




	<div
		class="container-fluid banner justify-content-center align-items-center">
		<div class="row g-2">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand text-dark">
						<a href="adminHome.jsp" class="text-decoration-none text-dark"><i
							class="fas fa-plane"></i> Home</a>
					</div>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="AdminLogout"><i class="fas fa-user-cog"></i> Logout</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-12 text-center text-dark">
				<h2>Add New Flight</h2>
				<p>
					You are logged in as :
					<%=session.getAttribute("email")%>
				</p>
			</div>

			<div class="row align-items-center" style="width: 100%;">
				<div class="col-md-8 bg-secondary booking">
					<p class="mt-3">Flight details:</p>

					<form action="adminAddFlight" method="post">
						<div class="container">
							<div class="row">
								<div class="col-md-4">
									<label for="pname" class="col-form-label">Flight Code:</label>
									<input type="text" class="form-control" id="f_code"
										name="f_code" required> <label for="phone"
										class="col-form-label">From:</label>
								  <select class="form-control" name="from" id="from">
										<option value="Delhi">Delhi</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Vadodara">Vadodara</option>
										<option value="Chennai">Chennai</option>
									</select> <label for="phone" class="col-form-label">Business
										Fare:</label> <input type="number" class="form-control"
										id="business_fare" name="business_fare" required>
																		</div>
								<div class="col-md-4">

									<label for="pemail" class="col-form-label">Airline:</label> <input
										type="text" class="form-control" id="airline" name="airline"
										required /> <label for="phone" class="col-form-label">To:</label>
									<select class="form-control" name="to" id="to">
										<option value="Delhi">Delhi</option>
										<option value="Mumbai">Mumbai</option>
										<option value="Vadodara">Vadodara</option>
										<option value="Chennai">Chennai</option>
									</select> 
									<label for="phone" class="col-form-label">Economic Fare:</label> 
									<input type="number" class="form-control"
										id="economic_fare" name="economic_fare" required>


								</div>

								<div class="col-md-4">
									<fieldset>
										<legend>Select Flight Days</legend>
										<table>
											<tr>
												<td><input type="checkbox" name="weekdays"
													value="mon"> Monday</td>
												<td><input type="checkbox" name="weekdays"
													value="tue"> Tuesday</td>
											</tr>
											<tr>
												<td><input type="checkbox" name="weekdays"
													value="wed"> Wednesday<br></td>
												<td><input type="checkbox" name="weekdays"
													value="thu"> Thursday</td>
											</tr>
											<tr>
												<td><input type="checkbox" name="weekdays"
													value="fri"> Friday</td>
												<td><input type="checkbox" name="weekdays"
													value="sat">Saturday</td>
											</tr>
											<tr>
												<th colspan="2"><input type="checkbox" name="weekdays"
													value="sun"> Sunday</th>
											</tr>
										</table>


									</fieldset>
									<label style="margin-top: 23px;" class="col-form-label">Prime
										Fare:</label> <input type="number" class="form-control"
										id="prime_fare" name="prime_fare" required>


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

	<%
	} else {
	response.sendRedirect("adminLogin.html");
	}
	%>


</body>
</html>