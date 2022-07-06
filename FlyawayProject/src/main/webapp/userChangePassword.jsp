<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewreport" content="width=device-width, initial-scale=1.0">
<title>Change User Password</title>
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
	margin-left: 8%;
	margin-bottom: 2%;
	margin-top: 2%;
	border-radius: 5px;
}
</style>
</head>





<body>
	<%
	HttpSession userSession = request.getSession();

	String uemail = (String) userSession.getAttribute("uemail");

	if (uemail != null) {
	%>

	<div class="container-fluid banner">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-md">
					<div class="navbar-brand text-dark">
						<a href="userHome.jsp" class="text-decoration-none text-dark"><i
							class="fas fa-plane"></i> Home</a>
					</div>
					<ul class="nav">
						<li class="nav-item"><a class="nav-link text-dark"
							href="UserLogout"><i class="fas fa-user-cog"></i> Logout</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-12">
				<h2 class="text-center text-dark">Change Password</h2>
			</div>
		</div>
	</div>
	<div class="row align-items-center" style="width: 100%;">
		<div class="col-md-3 bg-secondary booking">
			<p class="mt-3">Conform Password</p>
			<form name="contact-form" action="UserChangePassword" method="post">

				<div class="mb-3">
					<label for="Password" class="col-form-label">New Password:</label>
					<input type="password" class="form-control" id="txtPassword"
						name="newpassword" required />
				</div>
				<div class="mb-3">
					<label for="confirmpassword" class="col-form-label">Confirm
						Password:</label> <input type="text" class="form-control"
						id="txtConfirmPassword" name="confirmpassword" required>
				</div>
				<input type="submit" class="btn btn-primary mb-3" value="Submit">
			</form>
		</div>
		<div class="col-md-4">
			<img src="./assets/booking.svg" alt="">
		</div>
	</div>
	<%
	} else {
	response.sendRedirect("userLogin.html");
	}
	%>
</body>

</html>