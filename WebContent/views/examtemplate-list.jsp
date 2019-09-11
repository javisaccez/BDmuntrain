<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Examtemplate List</title>
</head>
<body>
	
	<div class = "container">
		
		<h1>Examtemplate List</h1>
		<hr/>
		
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'examtemplate-form.jsp'">Create</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Description</th>
			</tr>
			
			<c:forEach items="${list}" var="examtemplate">
			
				<tr>
					<td>${examtemplate.descriptionET}</td>
					<td> 
				
						<a href = "${pageContext.request.contextPath}/ExamtemplateController?action=EDIT&id=${examtemplate.id}">Edit</a>
				   		| 
						<a href = "${pageContext.request.contextPath}/ExamtemplateController?action=DELETE&id=${examtemplate.id}">Delete</a>
						
						<a href = "${pageContext.request.contextPath}/ExamtemplateController?action=PUBLISH&id=${examtemplate.id}">Publish</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>