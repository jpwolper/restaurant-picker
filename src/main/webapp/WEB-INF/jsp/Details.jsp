<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
<c:param name="pageTitle" value="RP - Details" />
</c:import>

<h2>Your restaurant pick for today is:</h2>
<table>
	<tr>
		<td align="right"><b>Name:</b></td>
		<td align="left">${restaurant.restaurantName}</td>
	</tr>
	<tr>
		<td align="right"><b>Type:</b></td>
		<td align="left">${restaurant.foodType}</td>
	</tr>
	<tr>
		<td align="right"><b>Address:</b></td>
		<td align="left">${restaurant.streetAddress}, ${restaurant.zipCode}</td>
	</tr>
	<tr>
		<td align="right"><b>Rating:</b></td>
		<td align="left">${restaurant.rating} stars</td>
	</tr>
</table>

<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>