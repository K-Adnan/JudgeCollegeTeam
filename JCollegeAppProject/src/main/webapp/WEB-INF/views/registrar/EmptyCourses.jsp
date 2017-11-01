<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
<link href="../css/style.css" rel="stylesheet" media="all">
<script  type="text/javascript">
					function getConfirmation() {
						var courseName = document.getElementById("courseName").value;
						var isOk = confirm("Are you sure you want to update the course " + courseName + "?");
						return isOk;
					}
				</script>
				
				<script  type="text/javascript">
					function getConfirmationForCancelling() {
						var courseName = document.getElementById("courseName").value;
						var isOk = confirm("Are you sure you want to cancel the course " + courseName + "?");
						return isOk;
					}
				</script>
</head>

<body>

<c:if test="${message eq 'Course is cancelled!'}">
	<script>
		alert("Successfully removed course!");
	</script>
</c:if>
<c:if test="${message2 eq 'Course is added!'}">
	<script>
		alert("Successfully added course!");
	</script>
</c:if>
	<ul>
		<div class="img">
			<IMG HEIGHT="50" WIDTH="80"
				SRC=http://www.pathwaysnetwork.co.uk/images/jeancarr-jc.jpg>
		</div>
		<h2>Judge College</h2>

		<form align="right" name="form1" method="post" action="../logout">
			<label class="logoutLblPos"> <input name="submit2"
				type="submit" id="submit2" value="Logout">
			</label>
		</form>
	</ul>

	<ul>
		<li><a href="MyProfile">My Profile</a></li>
		<li><a href="SystemUsers">System Users</a></li>
		<li><a href="Courses">Courses</a></li>
		<li><a href="Timetable">Timetable</a></li>
		<li><a href="Grades">Grades</a></li>
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">

		<h2>List of Courses with less than 3 Students</h2>
		
		<table>
			<tr>
				<th>Course Code</th>
				<th>Course Name</th>
				<th>No. of enrolled students</th>
				<th></th>
			</tr>
				<c:forEach items="${courseList}" var="c">
				  <tr>
					<td>${c.courseCode}</td>
					<td>${c.courseName}</td>
					<td>${fn:length(c.studentList)}</td>
					<td>
					
						<form name="CancelCourse" action="cancelEmptyCourse?courseCode=${c.courseCode}" onSubmit="return getConfirmationForCancelling()">
						<input type="hidden" name="courseCode" value="${c.courseCode}" />
						<input name="cancelCourse" type="submit" value="Cancel Course">
						</form>
					
					</td>
				  </tr>
				</c:forEach>
		</table>

	</div>
</body>
</html>