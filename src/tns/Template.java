package tns;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author john 
 */
public class Template {
    public static void printHeader(PrintWriter out) {
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
        out.println("<head>\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"img/favicon-96x96.png\">\n" +
"	<link href='https://fonts.googleapis.com/css?family=Playfair+Display' rel='stylesheet' type='text/css'>\n" +
"	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200' rel='stylesheet' type='text/css'>\n" +
"	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n" +
"	<script src=\"/tns/js/formvalidation.js\"></script>" +
"</head>\n" +
"	<header>\n" +
"		<div class=\"header\">\n" +
"			<h1 class=\"header-logo-text\"> <a href=\"/tns/\"> T H O R N E & S P I N D L E </a> </h1>\n" +
"			<nav class = \"navigationBar\">\n" +
"				<ul class=\"headernav\">\n" +
"					<li class=\"navItem\"><a href=\"ProductListingServlet?gender=women\">Women</a></li>\n" +
"					<li class=\"navItem\"><a href=\"ProductListingServlet?gender=men\">Men</a></li>\n" +
"					<li class=\"navItem\"><a href=\"about\">About</a></li>\n" +
"					<li class=\"navItem\"><a href=\"contact\">Contact</a></li>\n" +
"					<li class=\"navItem\" id=\"cartimage\">\n" +
"						<a class=\"cart-icon\" href=\"cart\">\n" +
"							<img src = \"img/thecarticon.png\" alt=\"cart icon\" /><span id=\"cart-qty\">\n" +
"							</span>\n" +
"						</a>\n" +
"					</li>\n" +
"				</ul>\n" +
"			</nav>\n" +
"		</div>\n" +
"	</header>");

    }
    
    public static void printFooter(PrintWriter out) {
        out.println("<html>\n" +
"<head>\n" +
"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
"<title></title>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"	<footer>\n" +
"		<div class=\"footer\" style=\"margin-top:75px\">\n" +
"			<div class=\"row\">\n" +
"				<div class=\"third\">\n" +
"					<h3 class=\"footer-header\">Site Map</h3>\n" +
"					<div><a href=\"ProductListingServlet?gender=women\">Women</a></div>\n" +
"					<div><a href=\"ProductListingServlet?gender=men\">Men</a></div>\n" +
"					<div><a href=\"/index.php/cart\">View Cart</a></div>\n" +
"				</div>\n" +
"				<div class=\"third\">\n" +
"					<h3 class=\"footer-header\">Company Info</h3>\n" +
"					<div><a href=\"about\">About Us</a></div>\n" +
"					<div><a href=\"contact\">Contact Us</a></div>\n" +
"					<br>\n" +
"					Join our mailing list!<br>\n" +
"					<input class=\"mailinglist-input\" type=\"text\" name=\"do\" />\n" +
"					<button type=\"button\" class=\"mailinglist-subscribe-button\">Subscribe</button>\n" +
"					\n" +
"				</div>\n" +
"				<div class=\"third\">\n" +
"					<h3 class=\"footer-header\">Connect</h3>\n" +
"					<div>\n" +
"						<a href=\"https://twitter.com/justinbieber\">\n" +
"							<img src=\"img/twitter.png\" width=\"20\" height=\"auto\"/>     Twitter\n" +
"						</a>\n" +
"					</div>\n" +
"					<div>\n" +
"						<a href=\"https://www.facebook.com/zuck\">\n" +
"							<img src=\"img/facebook.png\" width=\"20\" height=\"auto\"/> Facebook\n" +
"						</a>\n" +
"					</div>\n" +
"					<div>\n" +
"						<a href=\"https://www.instagram.com/kang_gary8888/\">\n" +
"							<img src=\"img/instagram.png\" width=\"20\" height=\"auto\"/> Instagram\n" +
"						</a>\n" +
"					</div>\n" +
"				</div>\n" +
"			</div>\n" +
"			<p class=\"copyright\">Copyright  2016 - TNS. All Rights Reserved</p>\n" +
"\n" +
"		</div>\n" +
"	</footer>\n" +
"</body>\n" +
"</html>");
    }
    
    public static void printBody(PrintWriter out, String s)
    {
    	out.println("<body>");
    	out.println(s);
    	out.println("</body>");
    }
    
    public static void CheckoutForm(PrintWriter out, Cart cart) {
    	printHeader(out);
    	printBody(out, "<div class=\"row\">\n" + 
    			"	<form id=\"checkout-form\" name=\"checkoutForm\" method=\"post\">\n" + 
    			"	<table id=\"checkout-table\">\n" + 
    			"		<td>\n" + 
    			"			<h2>Shipping & Billing Address</h2>\n" + 
    			"			<div id=\"shippingAddress\">\n" + 
    			"				First Name <input name=\"first_name\" id=\"first-nameId\" type=\"text\" required /><br />\n" + 
    			"				Last Name <input name=\"last_name\" id=\"last-nameId\" type=\"text\" required /><br />\n" + 
    			"				Street <input name=\"address\" id=\"streetId\" type=\"text\" required /><br />\n" + 
    			"				City <input name=\"city\" id=\"cityId\" type=\"text\" required /><br />\n" + 
    			"				State <select name=\"state\" id=\"stateId\" required>\n" + 
    			"					<option value=\"AL\">Alabama</option>\n" + 
    			"					<option value=\"AK\">Alaska</option>\n" + 
    			"					<option value=\"AZ\">Arizona</option>\n" + 
    			"					<option value=\"AR\">Arkansas</option>\n" + 
    			"					<option value=\"CA\">California</option>\n" + 
    			"					<option value=\"CO\">Colorado</option>\n" + 
    			"					<option value=\"CT\">Connecticut</option>\n" + 
    			"					<option value=\"DE\">Delaware</option>\n" + 
    			"					<option value=\"DC\">District Of Columbia</option>\n" + 
    			"					<option value=\"FL\">Florida</option>\n" + 
    			"					<option value=\"GA\">Georgia</option>\n" + 
    			"					<option value=\"HI\">Hawaii</option>\n" + 
    			"					<option value=\"ID\">Idaho</option>\n" + 
    			"					<option value=\"IL\">Illinois</option>\n" + 
    			"					<option value=\"IN\">Indiana</option>\n" + 
    			"					<option value=\"IA\">Iowa</option>\n" + 
    			"					<option value=\"KS\">Kansas</option>\n" + 
    			"					<option value=\"KY\">Kentucky</option>\n" + 
    			"					<option value=\"LA\">Louisiana</option>\n" + 
    			"					<option value=\"ME\">Maine</option>\n" + 
    			"					<option value=\"MD\">Maryland</option>\n" + 
    			"					<option value=\"MA\">Massachusetts</option>\n" + 
    			"					<option value=\"MI\">Michigan</option>\n" + 
    			"					<option value=\"MN\">Minnesota</option>\n" + 
    			"					<option value=\"MS\">Mississippi</option>\n" + 
    			"					<option value=\"MO\">Missouri</option>\n" + 
    			"					<option value=\"MT\">Montana</option>\n" + 
    			"					<option value=\"NE\">Nebraska</option>\n" + 
    			"					<option value=\"NV\">Nevada</option>\n" + 
    			"					<option value=\"NH\">New Hampshire</option>\n" + 
    			"					<option value=\"NJ\">New Jersey</option>\n" + 
    			"					<option value=\"NM\">New Mexico</option>\n" + 
    			"					<option value=\"NY\">New York</option>\n" + 
    			"					<option value=\"NC\">North Carolina</option>\n" + 
    			"					<option value=\"ND\">North Dakota</option>\n" + 
    			"					<option value=\"OH\">Ohio</option>\n" + 
    			"					<option value=\"OK\">Oklahoma</option>\n" + 
    			"					<option value=\"OR\">Oregon</option>\n" + 
    			"					<option value=\"PA\">Pennsylvania</option>\n" + 
    			"					<option value=\"RI\">Rhode Island</option>\n" + 
    			"					<option value=\"SC\">South Carolina</option>\n" + 
    			"					<option value=\"SD\">South Dakota</option>\n" + 
    			"					<option value=\"TN\">Tennessee</option>\n" + 
    			"					<option value=\"TX\">Texas</option>\n" + 
    			"					<option value=\"UT\">Utah</option>\n" + 
    			"					<option value=\"VT\">Vermont</option>\n" + 
    			"					<option value=\"VA\">Virginia</option>\n" + 
    			"					<option value=\"WA\">Washington</option>\n" + 
    			"					<option value=\"WV\">West Virginia</option>\n" + 
    			"					<option value=\"WI\">Wisconsin</option>\n" + 
    			"					<option value=\"WY\">Wyoming</option>\n" + 
    			"				</select>\n" + 
    			"				Zip <input id=\"zipId\" name=\"zipcode\" type=\"text\" onchange=\"calculateTax(this.value)\" maxlength=\"5\" required /><br />\n" + 
    			"				Phone (<input id=\"phone-area\" name=\"phone\" type=\"text\" value=\"\" maxlength=\"3\" required />) <input id=\"phone-first3\" type=\"text\" value=\"\" maxlength=\"3\" required /> - <input id=\"phone-last4\" type=\"text\" value=\"\" maxlength=\"4\" required /><br />\n" + 
    			"				Email <input id=\"emailId\" name=\"email\" type=\"email\" required /><br />\n" + 
    			"			</div>\n" + 
    			"		</td>\n" + 
    			"		<td>\n" + 
    			"			<div id=\"creditCardInfo\">\n" + 
    			"				<h2>Credit Card Information</h2>\n" + 
    			"				Name on Card <input id=\"nameOnCardId\" type=\"text\" required /><br />\n" + 
    			"				Card Number <input id=\"cardNumberId\" type=\"text\" maxlength=\"16\" required /><br />\n" + 
    			"				Expiration Date <input id=\"expMonthId\" type=\"text\" value=\"\" maxlength=\"2\" required /> / <input id=\"expYearId\" type=\"text\" value=\"\" maxlength=\"2\" required /><br />\n" + 
    			"				CSV/CSC <input id=\"csvCscId\" type=\"text\" value=\"\" maxlength=\"3\" required /><br />\n" + 
    			"			</div>\n" + 
    			"		<td>\n" + 
    			"	</table>\n" + 
    			"\n" + 
    			"	<div id=\"errors\"></div>\n" + 
    			"	<div id=\"checkout-order-summary\">\n" + 
    			"		<h2>Order Summary</h2>\n" + 
    			"		Shipping Method<select id=\"checkout-ship-method\" required>\n" + 
    			"			<option value=\"Standard\">Standard . . . Free</option>\n" + 
    			"			<option value=\"Priority\">Priority . . . Free</option>\n" + 
    			"		</select>\n" + 
    			"		<p>Total Merchandise: <span id=\"checkout-qty\"></span></p>\n" + 
    			"		<p>Shipping: $0.00</p>\n" + 
    			"		<p>Subtotal: $<span id=\"checkout-subtotal\">" + cart.getSubtotal() + "</span></p>\n" + 
    			"		<p>Tax: $<span id=\"checkout-tax\">" + cart.getTax() + "</span></p>\n" + 
    			"		<p>Price Total: $<span id=\"checkout-price\">" + cart.getTotal() +"</span></p>\n" + 
    			"		<button id=\"checkout-submit-button\" type=\"button\" class=\"big-btn\" onclick=\"formValidation();\">Purchase</button>\n" + 
    			"	</div>\n" + 
    			"	</form>\n" + 
    			"</div>");
    	printFooter(out);
    	
    }
}