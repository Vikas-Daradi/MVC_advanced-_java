<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list_registration</title>
</head>
<body>
<h2>All Registration</h2>
<table><tr><th>name</th>
			<th>email</th>
			<th>mobile</th>
			<th>delete</th>
			<th>update</th>
	   </tr>
	<%
	ResultSet result =(ResultSet)request.getAttribute("result");
	while(result.next()){%>
	<tr>
	<td><%=result.getString(1)%></td>
	<td><%=result.getString(2)%></td>
	<td><%=result.getString(3)%></td>
	<td><a href="deletereg?email=<%=result.getString(2)%>">delete</a></td>
	<td><a href="updatereg?email=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>">update</a></td>
</tr>
       
	<%}%>



</table>

</body>
</html>