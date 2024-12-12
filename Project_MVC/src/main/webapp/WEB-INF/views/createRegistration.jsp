<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
</head>
<body>
	<h2>Create Registration</h2>
	<form action="Savereg" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>mobile</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
			</tr>
			</table>
	</form>
</body>
</html>