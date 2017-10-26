<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile Information</title>
</head>
<body>

<h1>View My Grades</h1>

	<table>
			<tr>
				<th>Course Name</th>
				<th>Grade</th>
				<th>Professor</th>
			</tr>
			<c:forEach items="${gradeList}" var="g">
				<td>${g.course.courseName}</td>
				<td>${g.gradeValue}</td>
				<td>${g.professor.firstName} ${g.professor.lastName}</td>
				
			</c:forEach>
		</table>


</body>
</html>