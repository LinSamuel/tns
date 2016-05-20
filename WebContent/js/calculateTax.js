/**
 * Created by john on 5/1/16.
 */

function calculateTax(zipcode) {

	if (zipcode.length < 5) {
		return;
	}

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var taxObj = JSON.parse(xhr.responseText);

			var subtotalPrice = document.getElementById('checkout-subtotal');
			var checkoutPrice = document.getElementById('checkout-price');
			var taxPrice = document.getElementById('checkout-tax');

			subtotalPrice.innerHTML = taxObj.subtotal;
			taxPrice.innerHTML = "(" + taxObj.tax_rate + ") " + taxObj.tax;
			checkoutPrice.innerHTML = taxObj.total;
		}
	};

	xhr.open('GET', '/index.php/calculatetax/' + zipcode, true);
	xhr.send();
}