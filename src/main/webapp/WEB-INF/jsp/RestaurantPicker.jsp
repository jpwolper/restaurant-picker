<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
<c:param name="pageTitle" value="RP - Picker" />
</c:import>

<c:import url="/WEB-INF/jsp/header.jsp" />
	<h1>Make your choices here!</h1>

	<c:url var="formAction" value="/RestaurantPicker" />
	<form method="GET" action="${formAction}">
		

		<div class="formInputGroup">
			<label for="typeOfFood" style="color: black;">What type of food do you want?</label> 
			<select
				name="typeOfFood" id="typeOfFood">
				<c:forEach items="${foodTypes}" var="foodType"> 
				<option value="${foodType}">"${foodType}"</option>
			</c:forEach >	
			</select>
		</div>

		<div class="formInputGroup">
			<label for="stars">Rating:</label> 
			<select
				name="stars" id="stars">
				<option value="1">*</option>
				<option value="2">**</option>
				<option value="3">***</option>
				<option value="4">****</option>
				<option value="5">*****L</option>
			</select>
		</div>
		
		<div class="formInputGroup">
			<label for="submitBtn"></label> <input class="formSubmitButton" id="submitBtn" name="submitBtn" type="submit" value="Submit" />
		</div>

	</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>