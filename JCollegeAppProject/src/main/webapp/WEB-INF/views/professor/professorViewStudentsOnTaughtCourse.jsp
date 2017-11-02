<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/professor.css" rel="stylesheet" type="text/css">
<title>View Students</title>
</head>
<body>



<a href="/JCollegeAppProject/logout" class = logoutLblPos>Logout</a>


		
		<ul>
  <li><a href = "viewCourses"> Courses </a></li>
  <li><a href = "viewProfile"> My Profile</a></li>
</ul>
	
		
	



	<h2>List of all students enrolled on ${course.courseName}</h2>


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
				<td><a href="viewStudent?username=${s.username}">${s.username}</a></td>
				<td>${s.firstName}</td>
				<td>${s.lastName}</td>
				<td>${s.emailAddress}</td>
 				
					<!--  <select name="gradeDropdown"> -->
					
			 		 <c:forEach items="${s.gradeList}" var="grade">
			 		 <c:set scope="request" var="grade" value="${grade }"/>
 				<sf:form method="post" action="updateGrade?courseCode=${course.courseCode}&username=${s.username}" modelAttribute="grade" >
			 		 	
			  			<c:if test="${grade.course.courseCode eq course.courseCode}"> 
							<td> <sf:input path="gradeValue" type="text" value= "${grade.gradeValue}"/> </td>
						 	<td> <sf:input path="gradeComment" value="${grade.gradeComment}"/> </td>
							<td><input type="submit" value="Update"/></td>
			  			</c:if>
			  </sf:form>
			  		</c:forEach>
			  		
 				</tr>
			  </c:forEach>
			  
			  
				<!--   		<c:choose>
							<c:when test="${tester eq 'has' }">
			  			<th><input name="gradeComment" value="${comment}"/> </th>
			  				</c:when>
			  		</c:choose>  
			  			
			  			
			  <c:set var="tester" value="has"/>
						<c:set var="comment" value="${grade.gradeComment}"/> -->
			  
			 <!--  <c:choose>
			  <%-- Display entire list when the student has no grades assigned to them --%>
				<c:when test="${empty s.gradeList}">
				<c:forEach items="${gradeList}" var="g">
						<option value="${g}" selected>${g}</option>
				</c:forEach>
				<th><input name="gradeComment" value=""/> </th>
				<th><input type="submit" value="Update"/></th>
				</c:when>
				
				<%-- Display assigned grade as selected when the student has at least one grade assigned to them  --%>
				<c:otherwise>
 				<c:forEach items="${s.gradeList}" var="grade">
					<c:choose>
						<c:when test="${grade.course.courseCode eq course.courseCode }">
							<c:set var="tester" value="has"/>
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
					<th><input name="gradeComment" value="${grade.gradeComment }"/> </th>
					<th><input type="submit" value="Update"/></th>
						 </c:when>
						<c:otherwise>
						<c:forEach items="${gradeList}" var="g">
							<option value="${g}" selected>${g}</option>
						</c:forEach>
						<c:choose>
							<c:when test="${tester ne 'has' }">
								<th><input name="gradeComment" value=""/> </th>
								<th><input type="submit" value="Update"/></th>
							</c:when>
						</c:choose>
						</c:otherwise>
 					</c:choose>
 				</c:forEach>
				</c:otherwise>
				</c:choose>
 			<!-- </select> -->
 					
				
 				<%--<th><a href="updateGrade?courseCode=${course.courseCode}&username=${s.username}&grade=${pageScope[gradeDropdown]}">Update</a></th> --%>
	
		
	
	
	
	</table>
	
	<br/>
	<br/>

	
	
<a href="professorHome">back Home</a>









</body>
</html>