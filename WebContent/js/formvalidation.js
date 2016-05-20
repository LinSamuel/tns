
/**
 * formvalidation
 * lori ipsulm
 *
 * Usages: 
 */
 
function isNumeric(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}
	
function formValidation() {

	var firstname = document.getElementById("first-nameId");
	var lastname = document.getElementById("last-nameId");
	var street = document.getElementById("streetId");
	var city = document.getElementById("cityId");
	var state = document.getElementById("stateId");
	var zip = document.getElementById("zipId");
	var area = document.getElementById("phone-area");
	var three = document.getElementById("phone-first3");
	var four = document.getElementById("phone-last4");
	var email = document.getElementById("emailId");
	
	var name = document.getElementById("nameOnCardId");
	var number = document.getElementById("cardNumberId");
	var month = document.getElementById("expMonthId");
	var year = document.getElementById("expYearId");
	var cvc = document.getElementById("csvCscId");
	var errorsElement = document.getElementById("errors");

	// clear out errors
	errorsElement.innerHTML = "";

	var errors = [];
	
	if (firstname.value.length < 1 || isNumeric(firstname.value)) {
		firstname.style.borderColor = "red";
		errors.push("First name has to be at least 1 character long and contain no numeric values.");
	} else {
		firstname.style.borderColor = "";
	}
	
	if (lastname.value.length < 1 || isNumeric(lastname.value)) {
		lastname.style.borderColor = "red";
		errors.push("Last name has to be at least 1 character long and contain no numeric values.");
	} else {
		lastname.style.borderColor = "";
	}
	
	if (street.value.length < 4) {
		street.style.borderColor = "red";
		errors.push("Street has to be at least 4 characters long.");
	} else {
		street.style.borderColor = "";
	}
	
	if (isNumeric(city.value) || city.value.length < 1) {
		city.style.borderColor = "red";
		errors.push("City name has to be at least 1 character long and contain no numeric values.");
	} else {
		city.style.borderColor = "";
	}
	
	if (state.value.length != 2) {
		state.style.borderColor = "red";
		errors.push("A state must be selected.");
	} else {
		state.style.borderColor = "";
	}
	
	if (zip.value.length != 5 || !isNumeric(zip.value)) {
		zip.style.borderColor = "red";
		errors.push("Zip code must contain 5 numeric values.");
	} else {
		zip.style.borderColor = "";
	}
	
	if (area.value.length != 3 || !isNumeric(area.value)) {
		area.style.borderColor = "red";
		errors.push("Phone number area code must contain 3 numeric values.");
	} else {
		area.style.borderColor = "";
	}
	
	if (three.value.length != 3 || !isNumeric(three.value)) {
		three.style.borderColor = "red";
		errors.push("Phone number first 3 digits must contain numeric values.");
	} else {
		three.style.borderColor = "";
	}
	
	if (four.value.length != 4 || !isNumeric(four.value)) {
		four.style.borderColor = "red";
		errors.push("Phone number least 4 digits must contain numeric values.");
	} else {
		four.style.borderColor = "";
	}

	if(!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)) {
		email.style.borderColor = "red";
		errors.push("Email must follow the format: email@domain.domain");
	} else {
		email.style.borderColor = "";
	}
	
	if (name.value.length < 2 || isNumeric(name.value)) {
		name.style.borderColor = "red";
		errors.push("Name on card has to be at least 2 characters long and contain no numeric values.");
	} else {
		name.style.borderColor = "";
	}
	
	if (number.value.length < 13 || number.value.length > 19 || !isNumeric(number.value)) {
		number.style.borderColor = "red";
		errors.push("Card number has to be between 13 to 19 digits long and contain no letters.");
	} else {
		number.style.borderColor = "";
	}
	
	var currentDate = new Date();
	//Clear all other date parts
	currentDate.setDate(0);
	currentDate.setHours(0);
	currentDate.setMinutes(0);
	currentDate.setSeconds(0);
	currentDate.setMilliseconds(0);

	var dateToCheck = new Date(year.value + 2000, month.value, 0, 0, 0, 0, 0);

	if (!isNumeric(month.value) || !(month.value >= 1 && month.value <= 12)) {
		month.style.borderColor = "red";
		errors.push("Expiration month must contain no letters and be between 1 to 12.");
	} else {
		month.style.borderColor = "";
	}
	
	if (!isNumeric(year.value)) {
		year.style.borderColor = "red";
		errors.push("Expiration year must contain no letters and be numeric.");
	}else if (year.value < 16) {
		year.style.borderColor = "red";
		errors.push("Your credit card has expired");
	} else {
		if(dateToCheck.getTime() < currentDate.getTime()) {
			month.style.borderColor = "red";
			year.style.borderColor = "red";
			errors.push("Expiration date must be later than the current date.");
		} else {
			month.style.borderColor = "";
			year.style.borderColor = "";
		}
	}

	

	if (cvc.value.length != 3 || !isNumeric(cvc.value)) {
		cvc.style.borderColor = "red";
		errors.push("CSV/CSC must contain no letters and be three digits long.");
	} else {
		cvc.style.borderColor = "";
	}
	
	console.log(errors);
	if (errors.length > 0) {

		var errorString = "";
		for (var i=0; i<errors.length; i++) {
			errorString += "<p class=\"p-error\">" + errors[i] + "<p>";
		}

		errorsElement.innerHTML = errorString;

		return false;
	}

	var form = document.getElementById('checkout-form');
	form.submit();

}
