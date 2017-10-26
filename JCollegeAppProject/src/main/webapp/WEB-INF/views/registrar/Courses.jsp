<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="PageDirectives.jsp"%>

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

	<ul>
		<div class="img">
			<IMG HEIGHT="250" WIDTH="300"
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
		<li><a href="My Profile">My Profile</a></li>
		<li><a href="System Users">System Users</a></li>
		<li><a href="Courses">Courses</a></li>
		<li><a href="Timetable">Timetable</a></li>
		<li><a href="Grades">Grades</a></li>
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">

		<h2>Course Catalogue</h2>

		<h5>
			<a href="Show all courses">Show all courses</a>
		</h5>

		<c:forEach items="${courseList}" var="c">
			<a href="processChooseCourse?courseId=${c.courseCode}">
				${c.courseName}</a>
			<br />
		</c:forEach>

		<table>
			<caption>Course Details</caption>
			<tr>
				<td>Course Name</td>
				<td><input type="hidden" id="courseName" value="${course.courseName}">${course.courseName}</td>
			</tr>
			<tr>
				<td>Course Code</td>
				<td>${course.courseCode}</td>
			</tr>
			<tr>
				<td>Assigned Professor</td>
				<td>
					<form name="updateProfForm" action="updateProfessor" onSubmit="return getConfirmation()">
						<select name="professorUsername">
							<option value="empty" selected></option>
							<c:forEach items="${professorList}" var="prof">
								<c:choose>
									<c:when test="${prof.username eq course.professor.username }">
										<option value="${prof.username}" selected>${prof.firstName} ${prof.lastName}</option>
									</c:when>
									<c:otherwise>
										<option value="${prof.username}">${prof.firstName} ${prof.lastName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select> <input type="hidden" name="code" value="${course.courseCode}" />
						<input type="submit" value="Update">
					</form></td>
			</tr>
			<tr>
				<td>Department</td>
				<td>${course.department.departmentName}</td>
			</tr>
		</table>

		<form name="CancelCourse" action="cancelCourse?courseId=${course.courseCode}" onSubmit="return getConfirmationForCancelling()">
			<input type="hidden" name="code" value="${course.courseCode}" /> 
			<input name="cancelCourse" type="submit" value="Cancel Course">
		</form>

		<table>
			<caption align="left">Enrolled Students</caption>
			<tr>
				<th>Student Id</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${studentList}" var="s">
				<td>${s.username}</td>
				<td>${s.firstName}${s.lastName}</td>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>