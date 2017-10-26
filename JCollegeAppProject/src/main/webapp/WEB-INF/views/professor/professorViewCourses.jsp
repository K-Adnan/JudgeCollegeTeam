<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Courses</title>
</head>
<body>

	<h2>Student Course Options</h2>
	<br /> ${username} please choose a course to teach.

	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Taught by</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th> </th>
		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th>${c.courseName}</th>
				<th>${c.courseInfo}</th>
			<th><c:choose>
						<c:when test="${empty c.professor}">
							N/A
						</c:when>
						<c:otherwise>
					${c.professor.firstName} ${c.professor.lastName}
					</c:otherwise>
					</c:choose></th>
				<th>${c.startDate}</th>
				<th>${c.endDate}</th>
				<th>
				<c:choose>
					<c:when test="${empty c.professor.username }">
						<a href="processChooseCourse?courseCode=${c.courseCode}"> Teach</a>
					</c:when>
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
				</th>
		</c:forEach>
	</table>
<br/>
<br />
<br />
<h2>My courses</h2>
<table>
		<tr>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Start Date</th>
			<th>End Date</th>
		</tr>

		<c:forEach items="${taughtCourseList}" var="t">
			<tr>
				<th>${t.courseCode}</th>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseName}</a></th>
				<th>${t.courseInfo}</th>
				<th>${t.startDate}</th>
				<th>${t.endDate}</th>
				<th><a href="unassignCourse?courseCode=${t.courseCode}">Unassign</a></th>
		</c:forEach>
	</table>

</br>
<a href="professorHome"> Go back Home</a>
<a href="/JCollegeAppProject/logout">Logout</a>
</body>
</html>