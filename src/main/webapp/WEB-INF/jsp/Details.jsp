<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<c:url var="cssHref" value="/css/site.css" />
<link type="text/css" rel="stylesheet" href="${cssHref}" />
<title>Restaurant Details</title>

</head>
<body>
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