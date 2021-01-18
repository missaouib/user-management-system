<%@ page language="java" contentType="text/html;" pageEncoding="ISO-8859-1"
         isELIgnored="false"%>
<%@page import="java.util.Date" %>
<%@ page import="com.nafisulbari.ums.entity.Employee" %>


<html>

<head>
    <title>First Web Application</title>
</head>

<body>
<h1>Home page</h1>

<a>Date is:</a>
<%= new java.util.Date() %>




<button onclick="window.location.href='add-employee-form';">Add Employee</button>
</body>

</html>