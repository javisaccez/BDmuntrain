<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container">
	
		<h1>Login</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/UserController" method="POST">
				
					<%-- <div class = "form-group">
						<input type="text" class="form-control" name="email" placeholder="Enter email" value="${user.email}"/>
					</div> --%>
				
					<div class = "form-group">
						<input type="text" class="form-control" name="login" placeholder="Enter user login" value="${user.login}"/>
					</div>
				
					<div class="form-group">
					  	<input type="password" class="form-control" name="password" placeholder="Enter password" value="${user.password}"/>
					</div>
				
					<%-- <input type="hidden" name="id" value="${user.id}"/> --%>
				
					<button type="submit" class="btn btn-primary">Send</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>