<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose Your Bus</title>
</head>
<body  style="background-color:lightsteelblue">
<form action="ValidateServlet" method="post">
<div align="center">
<h1>Choose Your Bus:</h1>
<c:forEach var="b" items="${validatedbuses}">

 <c:out value="${b.getbusName()}" />
 </c:forEach>
 <table>
<tr>
<td style="color:fuchsia ;font-size:25px">Enter BusYou Want to buy Ticket</td>
<td><input type="text" name="busname">
</td>
</tr>

</table>
<input type ="submit" value="BookTicket">
</div>
</form>
</body>
</html>