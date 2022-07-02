<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" method="post">


		<table>
			<tr>
				<th>Product Id</th>
				<th><input type="text" name="pid"></th>
			</tr>
			<tr>
				<th>Product Name</th>
				<th><input type="text" name="pname"></th>
			</tr>
			<tr>
				<th>Product Price</th>
				<th><input type="text" name="pprice"></th>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Save"></th>
			</tr>

		</table>
	</form>
</body>
</html>