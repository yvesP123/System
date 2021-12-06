<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.cj.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3307/hospitalms";%>
<%!String user = "root";%>
<%!String psw = "";%>
<%
String id = request.getParameter("id");
String name=request.getParameter("name");
String address=request.getParameter("address");
String city=request.getParameter("city");
String gender=request.getParameter("gender");
String email=request.getParameter("uemail");
String phone=request.getParameter("phone");
if(name != null)
{
Connection con = null;
PreparedStatement ps = null;
int pid = Integer.parseInt(id);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="UPDATE umushoramali set id=?,name=?,address=?,city=?,gender=?,email=?,phone=? where id="+id;
ps = con.prepareStatement(sql);
ps.setString(1,id);
ps.setString(2, name);
ps.setString(3, address);
ps.setString(4, city);
ps.setString(5, gender);
ps.setString(6, email);
ps.setString(7, phone);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>