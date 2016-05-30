
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thorne & Spindle Checkout</title>
</head>
<body>

<jsp:useBean id="checkout" class="tns.Cart" scope="session"/>


<p>Cart subtotal: <jsp:getProperty name="checkout" property="subtotal"/></p>
<h1><%= request.getParameter("orderID")%></h1>
<jsp:useBean id="date" class="java.util.Date" /> 
<p>The date/time is <%= date %>


</body>
</html>