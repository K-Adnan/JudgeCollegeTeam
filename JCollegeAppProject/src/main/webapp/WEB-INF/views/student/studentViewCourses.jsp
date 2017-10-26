<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Screen</title>
</head>
<body>

	<h2>Student Course Options</h2>

	<a href="/JCollegeAppProject/logout">Logout</a>

	<br /> ${username} please chose a course to enroll on


	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Professor</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Enroll</th>

		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th>${c.courseName}</th>
				<th>${c.courseInfo}</th>
				<th>
				<c:choose>
				<c:when test="${empty c.professor}">
				N/A
			</c:when>
			<c:otherwise>
				${c.professor.firstName} ${c.professor.lastName}
			</c:otherwise>
				</c:choose>
				</th>
				<th>${c.startDate}</th>
				<th>${c.endDate}</th>
				<th><a href="enrollOnCourse?courseCode=${c.courseCode}">Enroll</a></th>
		</c:forEach>
	</table>
	${message}

	Enrolled Courses
	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Professor</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Enroll</th>

		</tr>

		<c:forEach items="${enrolledCourses}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th>${c.courseName}</th>
				<th>${c.courseInfo}</th>
				<th>
				<c:choose>
				<c:when test="${empty c.professor}">
				N/A
			</c:when>
			<c:otherwise>
				${c.professor.firstName} ${c.professor.lastName}
			</c:otherwise>
				</c:choose>
				</th>
				<th>${c.startDate}</th>
				<th>${c.endDate}</th>
				<th><a href="vacateCourse?courseCode=${c.courseCode}">Vacate</a></th>
		</c:forEach>
	</table>

</body>
</html>