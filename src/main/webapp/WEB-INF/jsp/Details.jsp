<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
<c:param name="pageTitle" value="RP - Details" />
</c:import>

<h2>Your restaurant pick for today is:</h2>
<h4>${restaurant.restaurantName}</h4>
<p>${restaurant.foodType}</p>
<p>${restaurant.streetAddress}</p>
<p>${restaurant.zipCode}</p>
<p>${restaurant.rating}</p>

<c:import url="/WEB-INF/jsp/footer.jsp" />
</body>
</html>