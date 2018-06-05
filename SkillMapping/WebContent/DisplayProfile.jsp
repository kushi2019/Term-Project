<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.niit.model.Employee" %>
<%!Employee empDetail; %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
h1{
      font-family: 'Fontdiner Swanky';font-size: 35px;
  
}
.input-container form,
.input-container form div {
    display: inline;
}

.input-container button {
    display: inline;
    vertical-align: middle;
}
input.searc {
    width: 10em;  height: 2em;
}

</style>
<br>
<br>

  <center> <h1><span style="color:blue">S</span><span style="color:red">k</span><span style="color:orange">i</span>
   <span style="color:blue">l</span>
   <span style="color:green">l</span><span style="color:red">M</span>
   <span style="color:oranging">a</span><span style="color:green">p</span>
   <span style="color:blue">p</span><span style="color:orange"> i</span>
   
   <span style="color:red">n</span><span style="color:blue">g</span>
   </h1>



<center>
<table border="1">
<tr><td>Employee Id</td><td>First Name</td><td>Last Name</td><td>Address</td><td>Password</td></tr>
<tr>
<td>${requestScope.emp.employeeId}</td>
<td>${requestScope.emp.firstName}</td>
<td>${requestScope.emp.lastName}</td>
<td>${requestScope.emp.address}</td>
<td>${requestScope.emp.password}</td></tr>
 </table>
<br>

<form action="UpdateServlet">
 Employee Id <input type="text" name="empId" /><br><br>
 Enter First Name <input type="text" name="empFirst" /><br><br>
 Enter Last Name <input type="text" name="empLast"/><br><br>
 Enter Address <input type="text" name="empAddress"/><br><br>
 Enter Password <input type="password" name="empPass"/><br><br>
 <input type="submit" name="submit"/>
 

</form></center>
</body>
</html>