
<%@page import="tns.CartItem"%>
<%@page import="tns.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Individual Product Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="js/imageswap.js"></script>
        <script src="js/polling.js"></script>
        <script src="js/addToCart.js"></script>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="icon" type="image/png" sizes="96x96" href="img/favicon-96x96.png">
	    <link href="https://fonts.googleapis.com/css?family=Playfair+Display" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200" rel="stylesheet" type="text/css">
	    <link rel="stylesheet" type="text/css" href="css/style.css">
	    <script src="/tns/js/formvalidation.js"></script>
	</head>
<body>
	<header>
        <div class="header">
            <h1 class="header-logo-text"> <a href="/tns/"> T H O R N E &amp; S P I N D L E </a> </h1>
            <nav class="navigationBar">
                <ul class="headernav">
                    <li class="navItem"><a href="ProductListingServlet?gender=women">Women</a></li>
                    <li class="navItem"><a href="ProductListingServlet?gender=men">Men</a></li>
                    <li class="navItem"><a href="about">About</a></li>
                    <li class="navItem"><a href="contact">Contact</a></li>
                    <li class="navItem" id="cartimage">
                        <a class="cart-icon" href="cart">
                            <img src="img/thecarticon.png" alt="cart icon"><span id="cart-qty">
                                
                            </span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
<jsp:useBean id="cart" class="tns.Cart" scope="session"/>



<div class="row">
	<h1>Order Confirmation</h1>
	<h2>here are your order details</h2>
</div>
<div class="row cart-container" id="12">
<% cart = tns.Orders.find(request.getParameter("orderId")); %>
<h2>SubTotal: <%= cart.getSubtotal() %></h2>
<h3>Tax: <%= cart.getTax() %></h3>
<h2>Total: <%= cart.getTotal() %></h2>
<% for(CartItem ci : cart.getCartItems()) { %>
<div class="row cart-container" id="<%= ci.product.getId() %>">
	<div class="cart-item">
		<div class="cart-img-container">
			<img src="/tns/img/products<%= ci.product.getDefaultImage() %>" />
		</div>
		<div class="cart-description">
			<span class="product-attr product-name"><%= ci.product.getName() %></span>
			<span class="product-attr product-brand"><%= ci.product.getBrand() %></span>
			<span class="product-attr">$<%= ci.product.getPrice() %></span>
			<span class="product-attr">qty: <%= ci.qty %></span>
		</div>
	</div>
</div>
<% } %>
<h1>Thanks for Shopping!</h1>
</div>

<footer>
        <div class="footer" style="margin-top:75px">
            <div class="row">
                <div class="third">
                    <h3 class="footer-header">Site Map</h3>
                    <div><a href="ProductListingServlet?gender=women">Women</a></div>
                    <div><a href="ProductListingServlet?gender=men">Men</a></div>
                    <div><a href="/index.php/cart">View Cart</a></div>
                </div>
                <div class="third">
                    <h3 class="footer-header">Company Info</h3>
                    <div><a href="about">About Us</a></div>
                    <div><a href="contact">Contact Us</a></div>
                    <br>
                    Join our mailing list!<br>
                    <input class="mailinglist-input" type="text" name="do">
                    <button type="button" class="mailinglist-subscribe-button">Subscribe</button>
                    
                </div>
                <div class="third">
                    <h3 class="footer-header">Connect</h3>
                    <div>
                        <a href="https://twitter.com/justinbieber">
                            <img src="img/twitter.png" width="20" height="auto">     Twitter
                        </a>
                    </div>
                    <div>
                        <a href="https://www.facebook.com/zuck">
                            <img src="img/facebook.png" width="20" height="auto"> Facebook
                        </a>
                    </div>
                    <div>
                        <a href="https://www.instagram.com/kang_gary8888/">
                            <img src="img/instagram.png" width="20" height="auto"> Instagram
                        </a>
                    </div>
                </div>
            </div>
            <p class="copyright">Copyright  2016 - TNS. All Rights Reserved</p>

        </div>
    </footer>


</body></html>