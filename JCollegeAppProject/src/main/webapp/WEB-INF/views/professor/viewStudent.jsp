<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile Information</title>
</head>
<body>

<h1>View Profile Details for ${student.username}</h1>

<table>
	<tr>
		<th>Username</th>
		<td>${student.username}</td>
	</tr>
	<tr>
		<th>First Name</th>
		<td>${student.firstName}</td>
	</tr>
	<tr>
		<th>Last Name</th>
		<td>${student.lastName}</td>
	</tr>
	<tr>
		<th>Address</th>
		<td>${student.address}</td>
	</tr>
	<tr>
		<th>Gender</th>
		<td>${student.gender}</td>
	</tr>
	<tr>
		<th>Phone Number</th>
		<td>${student.phoneNumber}</td>
	</tr>
	<tr>
		<th>Date of Birth</th>
		<td><fmt:formatDate value="${student.dOB}" type="both" pattern="dd/MM/YYYY"/></td>
	</tr>
	<tr>
		<th>Courses enrolled on</th>
		<td>
			<c:forEach items="${student.courseList}" var="c">
						${c.courseName}<br/>
			</c:forEach>
		</td>
	</tr>
</table>


</body>
</html>