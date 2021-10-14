<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buses Between Source And Destination</title>
</head>
<body  style="background-color:lightsteelblue">
<form action="ValidateBusServlet" method="post">
 <div align="center">
 <h1>BUSES AVAILABLE</h1>
 <c:forEach var="bus" items="${busesfound}">
 <c:out value="${bus}" />
 </c:forEach>
<table>
<tr>
<td style="color:fuchsia ;font-size:25px">Enter Ticket Count</td>
<td><input type="text" name="count">
</td>
</tr>
<tr>
<td style="color:fuchsia; font-size:25px">Enter Ticket Type</td>
<td>
<input type="radio" value="SL" name="type" >
<label >SL</label>
<input type="radio" value="ST" name="type" >
<label >ST</label>
</td>
</tr>
<tr>
<td>
<input type="submit" value="ValidateBus">
</td>
</tr>
</table>
 
</div>
</form>
</body>
</html>