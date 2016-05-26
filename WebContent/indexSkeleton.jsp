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
	<div class="row">
	<h2>Recently Viewed Products</h2>
<c:choose>
	<c:when test="${empty viewHistory}">
		<section>
			<h2>No Recently Viewed Products Can Be Displayed</h2>
		</section>
	</c:when>
<c:otherwise>			
	<section>

	<c:forEach var="product" items="${viewHistory}">      

        <div class="third text-center">
            <a href="IndividualProductServlet?productID=${product.id}"><img src="img/products/${product.defaultImage}" alt="productImage" width="150" height="auto"></a>
                <p>${product.name}</p>
                <p>${product.brand}</p>
                <p>${product.price}</p> 
        </div>          
	</c:forEach>
	</div>
	</section>
	</c:otherwise>
</c:choose>
		<div class="content">
			<img class="splash" src="img/pic.jpg" width="700" height="auto" align="middle"/>
		</div>
<c:choose>
	<c:when test="${empty productListHomeWomen}">
		<section>
			<h2>No Results Found</h2>
		</section>
	</c:when>
<c:otherwise>			
	<section>
	<div class="row">
	<h2>New Releases for Women</h2>
	<c:forEach var="product" items="${productListHomeWomen}">
        <div class="third text-center">
            <a href="IndividualProductServlet?productID=${product.id}"><img src="img/products/${product.defaultImage}" alt="productImage" width="150" height="auto"></a>
                <p>${product.name}</p>
                <p>${product.brand}</p>
                <p>${product.price}</p> 
        </div>        
	</c:forEach>
	</div>
	</section>
				
			
</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${empty productListHomeMen}">
		<section>
			<h2>No Results Found</h2>
		</section>
	</c:when>
<c:otherwise>			
	<section>
	<div class="row">
	<h2>New Releases for Men</h2>
	<c:forEach var="product" items="${productListHomeMen}">      

        <div class="third text-center">
            <a href="IndividualProductServlet?productID=${product.id}"><img src="img/products/${product.defaultImage}" alt="productImage" width="150" height="auto"></a>
                <p>${product.name}</p>
                <p>${product.brand}</p>
                <p>${product.price}</p> 
        </div>        
	</c:forEach>
	</div>
	</section>
				
				
	</c:otherwise>
</c:choose>
</body>
</html>