<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>

	<div>
		<p>${NOTIFICATION}</p>
	</div>
	<div>
	
		<p>
			<button class="btn btn-primary" onclick="window.location.href = 'examtemplate-form.jsp'">Create Exam</button>
		</p>
		<p>
			<button class="btn btn-primary" onclick="window.location.href = 'examtemplate-list.jsp'">See Previous Exams</button>
		</p>
		<p>
			<button class="btn btn-primary" onclick="window.location.href ='blank'">Do an Exam</button>
		</p>
		
	</div>
	
</body>
</html>