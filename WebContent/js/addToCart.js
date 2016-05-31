
function addItems(id) {
	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			alert("added to cart");
		}
	};

	xhr.open('GET', '/tns/CartLogicServlet?add=' + id + '&qty=' + value, true);
	xhr.send();
}

function updateItems(id) {
	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();
	
	var totalEl = document.getElementById('cart-total');
	var subtotalEl = document.getElementById('cart-subtotal');
	var taxEl = document.getElementById('cart-tax');
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			
			var response = JSON.parse(xhr.responseText);
			totalEl.innerHTML = response.total;
			subtotalEl.innerHTML = response.subtotal;
			taxEl.innerHTML = response.tax;
			
			if (response.total == 0) {
				// show sorry msg
				window.location = "/tns/cart";
			}
			if (response.deleted) {
				var cartContainer = document.getElementById(response.deleted);
				cartContainer.parentNode.removeChild(cartContainer);
			}
			
		}
	};

	xhr.open('GET', '/tns/CartLogicServlet?update=' + id + '&qty=' + value, true);
	xhr.send();
}

function removeItems(id) {
	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();
	var totalEl = document.getElementById('cart-total');
	var subtotalEl = document.getElementById('cart-subtotal');
	var taxEl = document.getElementById('cart-tax');
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var response = JSON.parse(xhr.responseText);
			totalEl.innerHTML = response.total;
			subtotalEl.innerHTML = response.subtotal;
			taxEl.innerHTML = response.tax;
			
			if (response.total == 0) {
				// show sorry msg
				window.location = "/tns/cart";
			}
			if (response.deleted) {
				var cartContainer = document.getElementById(response.deleted);
				cartContainer.parentNode.removeChild(cartContainer);
			}
		}
	};

	xhr.open('GET', '/tns/CartLogicServlet?update=' + id + '&qty=0', true);
	xhr.send();
}

