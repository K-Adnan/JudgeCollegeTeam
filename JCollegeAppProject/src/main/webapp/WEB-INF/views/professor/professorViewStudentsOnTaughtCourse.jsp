<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
</head>
<body>

	<h2>List of all students enrolled on ${course.courseName}</h2>

	<a href="/JCollegeAppProject/logout">Logout</a>


	<table>
		<tr>

			<th>Student Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Address</th>
			<th>Grade</th>
			<th> New Comment </th>
		</tr>

		<c:forEach items="${studentList}" var="s">
			<tr>
				<th><a href="viewStudent?username=${s.username}">${s.username}</a></th>
				<th>${s.firstName}</th>
				<th>${s.lastName}</th>
				<th>${s.emailAddress}</th>
 				<th>
 				<form method="post" action="updateGrade?courseCode=${course.courseCode}&username=${s.username}" >
			<select name="gradeDropdown">
			  <c:choose>
			  <%-- Display entire list when the student has no grades assigned to them --%>
				<c:when test="${empty s.gradeList}">
				<c:forEach items="${gradeList}" var="g">
						<option value="${g}" selected>${g}</option>
				</c:forEach>
				</c:when>
				
				<%-- Display assigned grade as selected when the student has at least one grade assigned to them  --%>
				<c:otherwise>
 				<c:forEach items="${s.gradeList}" var="grade">
					<c:choose>
						<c:when test="${grade.course.courseCode eq course.courseCode }">
							
							<c:forEach items="${gradeList}" var="g">
							  <c:choose>
								<c:when test="${grade.gradeValue eq g }">
									<option value="${g}" selected>${g}</option>
								</c:when>
								<c:otherwise>
									<option value="${g}">${g}</option>
								</c:otherwise>
							  </c:choose>
							</c:forEach>
						 </c:when>
						<c:otherwise>
						<c:forEach items="${gradeList}" var="g">
							<option value="${g}" selected>${g}</option>
						</c:forEach>
						</c:otherwise>
 					</c:choose>
					<th><input name="gradeComment" value="${grade.gradeComment }"/> </th>
 				</c:forEach>
				</c:otherwise>
				</c:choose>
 			</select>
 					<input type="submit" value="Update"/>
					
				</form>
 				</th>
 				<%--<th><a href="updateGrade?courseCode=${course.courseCode}&username=${s.username}&grade=${pageScope[gradeDropdown]}">Update</a></th> --%>
	
	
		</c:forEach>
	
	
	
	</table>
	
	<br/>
	<br/>
	
	<a href="viewCourses">back to My Courses</a>
	
	<br/>
	<br/>
	
	
<a href="professorHome">back Home</a>

</body>
</html>