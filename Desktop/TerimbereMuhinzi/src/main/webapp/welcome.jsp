<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("username")==null)
{
	response.sendRedirect("login.jsp");
	}
%>
<h1>Dear ${username},Your welcome to this pass</h1>
<form action="Logouts" >
<input type="submit" value="Logout">
</form>
<a href="user.jsp">User Account</a>
</body>
</html>