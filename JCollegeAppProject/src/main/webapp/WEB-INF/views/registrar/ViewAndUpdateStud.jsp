<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View And Update</title>
<link href="../css/style.css" rel="stylesheet" media="all">
<script  type="text/javascript">
					function getConfRemoveFromCourse() {
						var username = document.getElementById("username").value;
						var courseName = document.getElementById("courseName").value;
						var isOk = confirm("Are you sure you want to remove student " + username + "from course" + courseName+ "?");
						return isOk;
					}
</script>
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
	
	<form align="left" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
	<h2>Profile Information</h2>
	
	<form name="form1" method="post" action="EditInformationStud">
		<label class="EditInformationLblPos"> 
			<input name="submit2" type="submit" id="submit2" value="Edit Information">
		</label>
	</form>
    
	<table>
		<tr>
			<td>Username</td>
			<td><input type="hidden" id="username" value="${student.username}">${student.username}</td>
		</tr><tr>
			<td>First Name</td>
			<td>${student.firstName}</td>
		</tr><tr>
			<td>Last Name</td>
			<td>${student.lastName}</td>
		</tr><tr>
			<td>Address</td>
			<td>${student.address}</td>
      	</tr><tr>
			<td>Phone Number</td> 
        	<td>${student.phoneNumber}</td>
		</tr><tr>
			<td>Email address</td>
			<td>${student.emailAddress}</td>
		</tr>
	</table>
	<br/><br/>
	
	<table>
			<c:forEach items="${courseList}" var="c">
				<tr>
				<td>${c.courseName}</td> 
				<td><form name="RemoveFromCourse" action="RemoveFromCourse?username=${user.username}" onSubmit="return getConfRemoveFromCourse()">
					<input type="hidden" name="username" value="${user.username}" /> 
					<input name="removeFromCourse" type="submit" value="Remove from Course">
				</form></td>
				</tr>
			</c:forEach>
		</table>
	
	<p>Absences</p>
		<form name="AddAbsence" method="post" action="AddAbsence?username=${student.username}">
			<label class="AddAbsenceLblPos"> <input name="AddAbsence" type="submit" value="Add Absence">
			</label>
		</form>
	
</body>
</html>