<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Information</title>
<link href="../css/style.css" rel="stylesheet" media="all">
</head>

<body>
	<ul>
		<div class="img">
			<IMG HEIGHT="50" WIDTH="80" SRC=http://www.pathwaysnetwork.co.uk/images/jeancarr-jc.jpg>
		</div>
		<h2>Judge College</h2>
		<form align="right" name="form1" method="post" action="../logout">
			<label class="logoutLblPos"> <input name="submit2" type="submit" id="submit2" value="Logout">
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
	
	<form align="centre" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
	<h2>Edit Information</h2>
	<sf:form method="post" action="processEditStud" modelAttribute="student">
			<sf:hidden path="username" value="${student.username}"/>
			<sf:hidden path="password" value="${student.password }"/>
			<sf:hidden path="registrationDate" value="${student.registrationDate }"/>
			<sf:hidden path="noOfIncorrectAttempts" value="${student.noOfIncorrectAttempts }"/>
	
			First Name <br/> <sf:input type="text" path="firstName" />
           <br/>
 			Last Name <br/> <sf:input type="text" path="lastName" />
           <br/>
           	Address <br/> <sf:input type="text" path="address" />
           <br/>
           	Phone Number <br/> <sf:input type="text" path="phoneNumber" />
           <br/>
            Email address <br/> <sf:input type="text" path="emailAddress" />
           <br/>
           Date of Birth <br/> <input name="dob" type="text" value="<fmt:formatDate value="${student.dOB}" type="both" pattern="dd/MM/yyyy"/>"/>
           <br/>
           Gender
           <br/>
           <select name="gender">
							<c:forEach items="${genders}" var="g">
								<c:choose>
									<c:when test="${student.genderString eq g}">
										<option value="${student.gender}" selected>${student.gender}</option>
									</c:when>
									<c:otherwise>
										<option value="${g}">${g}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
           </select>
           <br/>
           <input type="submit" value="Edit" />
     </sf:form>
	
</body>
</html>