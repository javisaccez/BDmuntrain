<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exam Template</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>

	<div class="container">

		<h1>Exam Temaplate Form</h1>
		<hr />

		<div class="row">
			<div class="col-md-4">
			
				<form action="${pageContext.request.contextPath}/QuestionController" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" name="name" placeholder="Enter question" value="${question.description}" />
					</div>
					<input type="hidden" name="id" value="${question.id}"/>
					<button type="submit" class="btn btn-primary">SaveQuestion</button>
				</form>
			</div>
			
				<div class="col-md-4">
					<form action="${pageContext.request.contextPath}/ResponsesController" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" name="response one" placeholder="Enter first response" 
								value="${responses.description}" />
									 <select class="form-control" name="responses.value" required>
										<option value="${responses.value}">TRUE</option>
										<option value="${responses.value}">FALSE</option>
									</select>
							<input type="hidden" name="id" value="${responses.id}"/>
						</div>

						<div class="form-group">
							<input type="text" class="form-control" name="descriptionR" placeholder="Enter second response"
								value="${responses.description}" /> 
								<select class="form-control" name="responses.value" required>
									<option value="${responses.value}">TRUE</option>
									<option value="${responses.value}">FALSE</option>
								</select>
							<input type="hidden" name="id" value="${product.id}"/>
						</div>
						
						<button type="submit" class="btn btn-primary">SaveResponses</button>

					</form>
					
					
			
				</div>
				
			</div>
			
		</div>

			<p>
				<button class="btn btn-primary" onclick="window.location.href = 'mainMenu.jsp'">Menu</button>
			</p>




			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>