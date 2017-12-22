<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/header.jsp">
<c:param name="pageTitle" value="RP - Details" />
</c:import>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h2>Your restaurant pick for today is:</h2>
<h4>${restaurant.getRestaurantName}</h4>
<p>${restaurant.getFoodType}</p>
<p>${restaurant.getStreetAddress}</p>
<p>${restaurant.getZipCode}</p>
<p>${restaurant.getRating}</p>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>