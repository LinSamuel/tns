<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Individual Product Page</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="js/imageswap.js"></script>
	</head>
	<body>
		<header>
			<%@ include file="header.jsp" %>


		</header>		
<c:choose>
	<c:when test="${empty productList}">
		<section>
			<h2>No Results Found</h2>
		</section>
	</c:when>
	<c:otherwise>			
<section>
		
<c:forEach var="product" items="${productList}">
	<div class="row">
		<div id="productDisplay">
			<div class="big-image">
				<img id="bigpic" src="img/products${product.defaultImage}" alt="productImage" width="auto" height="auto">
			</div>
			<div class="big-image-body">
				<div>
					<c:forEach var="imageUrl" items="${product.images}">
						<img onclick="imageswap(this)" src="img/products/${imageUrl}" alt="productImage" width="15%" height="auto">
					</c:forEach>
	
				</div>
				<h3 class="product-name">${product.name}</h3>
				<p> by <span class="product-brand">${product.brand}</span></p>
				<br>
				<p class="product-name">Price</p>
				<p>${product.brand}</p>
				<br>
				<p class="product-name"> Color</p>
				<p></p>
				<p>${product.brand}</p>
				<br>
				<p class="product-name">Details</p>
				<br>
				<input id="product-qty" class="mailinglist-input" type="number" name="product-qty" value="1">
				<button onclick="addItems(${product.id})">Add Items To Cart </button>
			</div>
		</div>
	</div>
</c:forEach>

</section>
				
		
	</c:otherwise>
</c:choose>
		

<footer>
			<%@ include file="footer.jsp" %>

</footer>
	</body>
</html>