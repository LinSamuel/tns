
function removeItems(id) {

	var currentElement = document.getElementById(id);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			console.log(xhr.responseText);
			var x = JSON.parse(xhr.responseText);
			if (x.subtotal == 0) {
				window.location = "/index.php/cart";
			}
			console.log(x);
			var cartElement = document.getElementById('cart-qty');
			cartElement.innerHTML = "(" + x.qty + ")";
			var element = document.getElementById(id);
			element.parentNode.removeChild(element);
			element = document.getElementById('subtotal');
			element.innerHTML = "Subtotal: $" + x.subtotal;
		}
	};

	xhr.open('GET', '/index.php/removefromcart/' + id, true);


	xhr.send();
}
