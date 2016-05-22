<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thorne & Spindle Index</title>
</head>
<body>
<header>
			<%@ include file="header.jsp" %>
</header>

<jsp:include page="/IndexServlet" />

<footer>
			<%@ include file="footer.jsp" %>

</footer>
</body>
</html>