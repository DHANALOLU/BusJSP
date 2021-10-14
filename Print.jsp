<%@page import="pack.BusDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@page import="pack.Bus"%>
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Your Bus</title>
</head>

<body  style="background-color:lightsteelblue">
<div align = "center" >
<%  
BusDetails busd = new BusDetails();

List<Bus>  busDetails = busd.createBusDetails();
String [] stops= busd.createStops();

%>
<h2 style="color:maroon">Buses Available</h2>

<% for(Bus bus : busDetails)
	{
	   out.println(bus.getbusName());
	}
	%>
	
<h2 style="color:maroon">Stops Available</h2>
<% for(String s:stops)
	{
	   out.println(s);
	}
	%>

<form action="FindBusServlet" method="post">


 
<table>
<tr>
<td style="color:fuchsia ;font-size:25px">Enter Source</td>
<td><input type="text" name="source">
</td>
</tr>
<tr>
<td style="color:fuchsia; font-size:25px">Enter Destination</td>
<td><input type="text" name="destination">
</td>
</tr>
</table>
 
 
 <input type="submit" value="Click to Find Your Bus">
 </form>
</div>
</body>

</html>