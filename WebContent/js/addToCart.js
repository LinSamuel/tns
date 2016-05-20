
function addItems(id) {

	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var cartElement = document.getElementById('cart-qty');
			cartElement.innerHTML = "(" + xhr.responseText + ")";
		}
	};

	xhr.open('GET', '/index.php/addtocart/' + id + '/' + value, true);
	xhr.send();
}

