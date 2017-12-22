<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<c:url var="cssHref" value="/css/site.css" />
<link type="text/css" rel="stylesheet" href="${cssHref}" />
<title>Restaurant Picker</title>
</head>
<body>
	<h1>Make your choices here!</h1>

	<c:url var="formAction" value="/RestaurantPicker" />
	<form method="POST" action="${formAction}">
		

		<div class="formInputGroup">
			<label for="typeOfFood" style="color: black;">What type of food do you want?</label> 
			<select
				name="typeOfFood" id="typeOfFood">
				<option value="Type">type</option>
				<option value="Type">type</option>
				<option value="Type">type</option>
				<option value="Type">type</option>
				<option value="Type">type</option>
			</select>
		</div>

		<div class="formInputGroup">
			<label for="stars">Rating:</label> 
			<select
				name="stars" id="stars">
				<option value="*">*</option>
				<option value="**">**</option>
				<option value="***">***</option>
				<option value="****">****</option>
				<option value="*****">*****L</option>
			</select>
		</div>
		
		<div class="formInputGroup">
			<label for="submitBtn"></label> <input class="formSubmitButton" id="submitBtn" name="submitBtn" type="submit" value="Submit" />
		</div>

	</form>

</body>
</html>