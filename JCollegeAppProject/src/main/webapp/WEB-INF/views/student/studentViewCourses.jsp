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

	<a href="/JCollegeAppProject/logout">Logout</a><br/>
	<a href="ViewCourses">Show All Available Courses</a>

	<form action="searchCourse" method="post">
		<input name="search" width="50px" placeholder="Search for Course"/>
		<input type="submit" value="Go!"/>
	</form>

	<table>
		<tr>
			<th>Course Code</th>
			<th>Course Name</th>
			<th>Department</th>
			<th>Course Info</th>
			<th>Professor</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Enroll</th>

		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th><a href="viewCourse?courseCode=${c.courseCode}">${c.courseName}</a></th>
				<th>${c.department.departmentName}
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
				<th><a href="enrollOnCourse?courseCode=${c.courseCode}&courseName=${c.courseName}">Enroll</a></th>
		</c:forEach>
	</table>
	${message}
		<br/>
		<br/>
		<br/>

	My Courses
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
				<th><a href="vacateCourse?courseCode=${c.courseCode}">Remove Course</a></th>
		</c:forEach>
	</table>

</body>
</html>