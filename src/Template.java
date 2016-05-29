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
"						<a class=\"cart-icon\" href=\"/index.php/cart\">\n" +
"							<img src = \"img/thecarticon.png\" alt=\"cart icon\" /><span id=\"cart-qty\">\n" +
"								()\n" +
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
}