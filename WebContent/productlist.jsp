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
	<c:when test="${empty productListing}">
		<section>
			<h2>No Results Found</h2>
		</section>
	</c:when>
	<c:otherwise>			
<section>
<div class="row">
<c:if test ="${pageMode == 'menGeneral'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=men"> <h1 style="color: #5E9DC8">Men</h1> </a>
	    <a href="ProductListingServlet?gender=men&category=tops">
	        <h4>Tops</h4> </a>
	    <a href="ProductListingServlet?gender=men&category=bottoms">
	        <h4>Bottoms</h4> </a>
	</div>
</c:if>
<c:if test ="${pageMode == 'womenGeneral'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=women"> <h1 style="color: #5E9DC8">Women</h1> </a>
		<a href="ProductListingServlet?gender=women&category=tops">
			<h4>Tops</h4> </a>
		<a href="ProductListingServlet?gender=women&category=bottoms">
			<h4>Bottoms</h4> </a>
		<a href="ProductListingServlet?gender=women&category=dresses">
			<h4>Dresses</h4> </a>
	</div>
</c:if>
<c:if test ="${pageMode == 'menBottoms'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=men"> <h1>Men</h1> </a>
		<a href="ProductListingServlet?gender=men&category=tops">
		    <h4>Tops</h4> </a>
		<a href="ProductListingServlet?gender=men&category=bottoms">
		    <h4 style="color: #5E9DC8">Bottoms</h4> </a>
	</div>
</c:if>
<c:if test ="${pageMode == 'menTops'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=men"> <h1>Men</h1> </a>
		<a href="ProductListingServlet?gender=men&category=tops">
			<h4 style="color: #5E9DC8">Tops</h4> </a>
		<a href="ProductListingServlet?gender=men&category=bottoms">
			<h4>Bottoms</h4> </a>
	</div>
</c:if>
<c:if test ="${pageMode == 'womenBottoms'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=women"> <h1>Women</h1> </a>
		<a href="ProductListingServlet?gender=women&category=tops">
		    <h4>Tops</h4> </a>
		<a href="ProductListingServlet?gender=women&category=bottoms">
		    <h4 style="color: #5E9DC8">Bottoms</h4> </a>
		<a href="ProductListingServlet?gender=women&category=dresses">
		    <h4>Dresses</h4> </a>
	</div>
</c:if>
<c:if test ="${pageMode == 'womenDresses'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=women"> <h1>Women</h1> </a>
		<a href="ProductListingServlet?gender=women&category=tops">
		    <h4>Tops</h4> </a>
		<a href="ProductListingServlet?gender=women&category=bottoms">
		    <h4>Bottoms</h4> </a>
		<a href="ProductListingServlet?gender=women&category=dresses">
		    <h4 style="color: #5E9DC8">Dresses</h4> </a>
	</div>
</c:if>
<c:if test ="${pageMode == 'womenTops'}">
	<div class="sidebar">
		<a href="ProductListingServlet?gender=women"> <h1 >Women</h1> </a>
		<a href="ProductListingServlet?gender=women&category=tops">
		    <h4 style="color: #5E9DC8">Tops</h4> </a>
		<a href="ProductListingServlet?gender=women&category=bottoms">
		    <h4>Bottoms</h4> </a>
		<a href="ProductListingServlet?gender=women&category=dresses">
		    <h4>Dresses</h4> </a>
	</div>
</c:if>
<div id="productList">
<c:forEach var="product" items="${productListing}">
	<div class="main-page">
	<a href = "BrowseServlet?productID=${product.id}"> <img class ="product-image" src="img/products${product.defaultImage}" alt=productImage width="150" height="auto"/></a>
	<p class="product-name">${product.name}</p>
	<p class="product-brand">${product.brand}</p>
	<p>${product.price}</p>
	</div>
</c:forEach>
</div>
</div>
</section>
				
		
	</c:otherwise>
</c:choose>
		

<footer>
			<%@ include file="footer.jsp" %>

</footer>
	</body>
</html>