<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
</head>
<body>

	<h2>List of all students</h2>

	<a href="/JCollegeAppProject/logout">Logout</a>
	<br />
	<br /> ${username} 
	
	${c.courseName} - ${c.courseInfo} - ${c.startDate}	- ${c.endDate}


	<table>
		<tr>

			<th>Student Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Address</th>
			<th>Grade </th>

		</tr>

		<c:forEach items="${studentList}" var="s">
			<tr>
				<th>${s.username}</a></th>
				<th>${s.firstName}</th>
				<th>${s.lastName}</th>
				<th>${s.email}</th>
				<th><sf:input path="grade" value="${grade}"/></th>
		</c:forEach>
	</table>
	
	
	<a href="processChangeStudentGrades">Update Grades</a>
	<br/>
	<br/>
	<a href="professorHome">back home</a>
	
	


</body>
</html>