<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.*"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@page import="pack.BookedDetails"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing</title>
</head>
<body  style="background-color:lightsteelblue">
<form action ="ExitServlet" method="post">
<div align="center">
<%  
 List<Double> Billing = (List<Double>)request.getAttribute("Billing");
List<Integer> BookedCount = (List<Integer>)request.getAttribute("BookedCount");
List<String> BookedBus = (List<String>)request.getAttribute("BookedBus");
List<String> BookedType = (List<String>)request.getAttribute("BookedType");
List<BookedDetails> BookInf = new ArrayList<>();
BookedDetails bookedd = new BookedDetails(BookedBus,BookedCount,BookedType);
BookInf.add(bookedd);

%>
<% 
Double sum =0.0;
for(Double d:Billing)
{
	sum=sum+d;
}

%>
<h2>Total Amount<%=sum %></h2>
<% 
for(BookedDetails b: BookInf)
{
%>
<table border ="1">
<tr>
<th>BOOKED BUS
</th>
<th>BOOKED TICKETS COUNT
</th>
<th>BOOKED TICKETS TYPE
</th>
</tr>

<tr>
<td>
<%=b.getbookedname() %></td>

<td>
<%=b.getbookedcount()%></td>
<td>
<%=b.getbookedtype()%></td>
<%} %>
</tr>
</table>

<table>
<tr>
<td>
<input type = "submit" value="Continue Booking Tickets"name="continue">
<input type ="submit" value="Exit" name="exit">
</td>
</tr>
</table>
</div>
</form>
</body>
</html>