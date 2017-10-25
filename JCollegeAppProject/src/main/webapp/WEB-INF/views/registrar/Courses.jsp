<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="PageDirectives.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
<link href="../css/style.css" rel="stylesheet" media="all"> 
</head>
<body>
<div class="img"> 
	<IMG HEIGHT="250" WIDTH="300" SRC=http://www.pathwaysnetwork.co.uk/images/jeancarr-jc.jpg>
</div>
<h2> Judge College </h2>

<form align="right" name="form1" method="post" action="log_out.php">
  <label class="logoutLblPos">
  <input name="submit2" type="submit" id="submit2" value="Logout">
  </label>
</form>

<ul>
    <li><a href="My Profile">My Profile</a></li>
    <li><a href="System Users">System Users</a></li>
    <li><a href="Courses">Courses</a></li>
    <li><a href="Timetable">Timetable</a></li>
    <li><a href="Grades">Grades</a></li>
</ul>

<div class="clearlist"></div>

<h2> Course Catalogue</h2>

<h5><a href="Show all courses">Show all courses</a></h5>

<c:forEach items="${courseList}" var="c">
		<a href="processChooseCourse?courseId=${c.courseCode}"> ${c.courseName}</a> <br/>
	</c:forEach>

<caption> <b  Course Details:>Course details:  </b> </caption>
	<table border="0">
	<tr>
	<td>Course Name</td>
	<td>${course.courseName} </td>
	</tr>
	<tr>
	<td>Course Code</td>
	<td>${course.courseCode}</td>
	</tr>
	<tr>
	<td>Assigned Professor</td>
	<td>
	<form action="updateProfessor">
	
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
		<input type="hidden" name="code" value="${course.courseCode}"/>
	</select>
  		<input type="submit" value="Update">
	</form></td>
	</tr>
	<tr>
	<td>Department</td>
	<td>${course.department.departmentName}</td>
	</tr>
	</table>

<form action="cancelCourse">
    <label>
  <input name="cancelCourse" type="submit" value="Cancel Course">
  </label>
</form>	

</body>
</html>