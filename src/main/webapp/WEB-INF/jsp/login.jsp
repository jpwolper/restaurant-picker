<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />
<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			
			rules : {
				userName : {
					required : true
				},
				password : {
					required : true
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
	});
</script>
<div>
<h1>Welcome to Restaurant Picker</h1>
<p>The amazing benefits of using Restaurant Picker and why you should sign up immediately!</p>
</div>
<div>
	<c:url var="formAction" value="/login" />
	<form method="POST" action="${formAction}">
		<div>
			<label for="userName">User Name: </label> <input type="text"
				id="userName" name="userName" placeHolder="User Name"
				class="form-control" />
		</div>
		<div>
			<label for="password">Password: </label> <input type="password"
				id="password" name="password" placeHolder="Password"
				class="form-control" />
		</div>
		<button type="submit">Login</button>
	</form>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />