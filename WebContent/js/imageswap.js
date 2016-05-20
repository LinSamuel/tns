
/**
 * imageswap
 * This function works in conjunction with onClick (see product-layout-template.html).
 * When an image with this onClick in the <img> tag is clicked, imageswap is called which
 * replaces the bigimage with ID = "bigpic" with the image that was clicked.
 *
 * Usages: product-layout-template.html to switch the large image with More Pictures!
 */
function imageswap(scope) {
	var element = document.getElementById("bigpic");
	element.src = scope.src;
}