<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<c:url var="cssHref" value="/css/site.css" />
		<link type="text/css" rel="stylesheet" href="${cssHref}" /> 
	    <script src="js/jquery.min.js" defer></script>
		<script src="js/jquery.validate.min.js" defer></script>
		<script src="js/additional-methods.min.js" defer></script>
		<title>${pageTitle}</title>
	</head>
	
<c:url var="pickerURL" value="/picker" />
<c:url var="detailsURL" value="/details" />
<c:url var="loginURL" value="/" />
<c:url var="registerURL" value="/register" />
<c:url var="logoURL" value="/img/logo.svg" />
	    
<div id="container">
	<header> 
		<a href="${homePageURL}"> 
		    <img src="${logoURL}" id="logo" />
		</a>
		<div class="nameHeader" id="pageHeader">
			<h1>Restaurant Picker</h1>
		</div>
		<div class="subHeader">
			<div class="nameHeader" id="nameHeader">
			<h3>${firstName} ${lastName}</h3>
			</div>
		</div>
	</header>
	
	<body>