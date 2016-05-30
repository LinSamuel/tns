
function addItems(id) {
	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {;
		}
	};

	xhr.open('GET', '/tns/CartLogicServlet?add=' + id + '&qty=' + value, true);
	xhr.send();
}

function updateItems(id) {
	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {;
		}
	};

	xhr.open('GET', '/tns/CartLogicServlet?update=' + id + '&qty=' + value, true);
	xhr.send();
}

function removeItems(id) {
	var value = document.getElementById('product-qty').value;

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {;
		}
	};

	xhr.open('GET', '/tns/CartLogicServlet?update=' + id + '&qty=0', true);
	xhr.send();
}

