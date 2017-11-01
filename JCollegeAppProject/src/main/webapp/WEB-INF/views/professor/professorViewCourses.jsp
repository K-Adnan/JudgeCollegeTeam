<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/professor.css" rel="stylesheet" type="text/css">
<title>View Courses</title>
</head>
<body>


		
		<ul>
  <li><a href = "viewCourses"> Courses </a></li>
  <li><a href = "viewProfile"> My Profile</a></li>
</ul>
	
		<a href="/JCollegeAppProject/logout" class = logoutLblPos>Logout</a>

	<h2>Student Course Options</h2>

	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Taught by</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Number of Students</th>
			
			<th> </th>
		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<th>${c.courseCode}</th>
				<th>${c.courseName}</th>
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
				<th>${fn:length(c.studentList)}</th>
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
			<th>Start Date</th>
			<th>End Date</th>
		</tr>

		<c:forEach items="${taughtCourseList}" var="t">
			<tr>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseCode}</a></th>
				<th><a href="viewStudents?courseCode=${t.courseCode}">${t.courseName}</a></th>
				<th>${t.startDate}</th>
				<th>${t.endDate}</th>
				<th><a href="unassignCourse?courseCode=${t.courseCode}">Remove Course</a></th>
		</c:forEach>
	</table>



<a href="professorHome">back home</a>
</body>
</html>