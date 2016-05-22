<%@ page language="java" pageEncoding="ISO-8859-1"%>
    
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" sizes="96x96" href="favicon-96x96.png">
	<link href='https://fonts.googleapis.com/css?family=Playfair+Display' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
	<header>
		<div class="header">
			<h1 class="header-logo-text"> <a href="/tns/"> T H O R N E & S P I N D L E </a> </h1>
			<nav class = "navigationBar">
				<ul class="headernav">
					<li class="navItem"><a href="ProductListingServlet?gender=women">Women</a></li>
					<li class="navItem"><a href="ProductListingServlet?gender=men">Men</a></li>
					<li class="navItem"><a href="/index.php/about">About</a></li>
					<li class="navItem"><a href="/index.php/contact">Contact</a></li>
					<li class="navItem" id="cartimage">
						<a class="cart-icon" href="/index.php/cart">
							<img src = "img/thecarticon.png" alt="cart icon" /><span id="cart-qty">
								()
							</span>
						</a>
					</li>
				</ul>
				<form>
					<input type="text" id="searchBar" placeholder="Search products" onFocus="this.placeholder=''" onkeyup="getResults(this.value)">
					<img src="img/searchicon.png" alt="search icon" />
					<div id = searchContainer>
						<div id="searchResults"></div>
					</div>
				</form>
			</nav>
		</div>
	</header>