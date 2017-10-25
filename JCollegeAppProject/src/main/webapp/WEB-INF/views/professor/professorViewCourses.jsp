<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Screen</title>
</head>
<body>

	<h2>Student Course Options</h2>

	<a href="/JCollegeAppProject/logout">Logout</a>

	<br /> ${username} please chose a course to teach.


	<table>
		<tr>

			<th>Course Code</th>
			<th>Course Name</th>
			<th>Course Info</th>
			<th>Availability  </th>
			<th>Start Date</th>
			<th>End Date</th>
			
		</tr>

		<c:forEach items="${courseList}" var="c">
			<tr>
				<th><a href="processChoseCourse?courseCode=${c.courseCode}">${c.courseCode}</a></th>
				<th>${c.courseName}</th>
				<th>${c.courseInfo}</th>
				<th>if (${professor} = "null") {
        Available;
    } else
					{ ${professor}; }}</th>
				<th>${c.startDate}</th>
				<th>${c.endDate}</th>
		</c:forEach>
	</table>


</body>
</html>