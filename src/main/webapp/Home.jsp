<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.Register.Login" %>
    <%@ page import="java.lang.*" %>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bank application</title>

</head>
<body>
<h1 style="text-align:center;color:blue">Bank of India</h1>
<div style="display:flex;justify-content:space-between;border: 0px solid blue;background-color:blue;color:white">
<h2>Name:<%=session.getAttribute("uname") %></h2>
<h2>Cont.no:<%=session.getAttribute("PhNo") %></h2>
<h2>Email:<%=session.getAttribute("Email") %></h2>
<button onclick="logout()">Logout</button>
</div>
<script>
function logout(){
	window.location.href="Login.html";
}
</script>


</body>
	