
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String name=request.getParameter("name");
String address=request.getParameter("address");
String city=request.getParameter("city");
String gender=request.getParameter("gender");
String phone=request.getParameter("phone");
String email=request.getParameter("email");
String password=request.getParameter("password");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/hospitalms", "root", "");
Statement st=conn.createStatement();

int i=st.executeUpdate("INSERT INTO umushoramali(name,address,city,gender,phone,email,password) values('"+name+"','"+address+"','"+city+"','"+gender+"','"+phone+"','"+email+"','"+password+"')");
out.println("Data is successfully inserted!");
}
catch(Exception e)
{
System.out.print(e);

e.printStackTrace();
}
%>