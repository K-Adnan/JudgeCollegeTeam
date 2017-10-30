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
	</ul>
	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
	
	<form align="left" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
	<h2>Profile Information</h2>
	
	<form align="right" name="form1" method="post" action="EditInformation">
		<label class="EditInformationLblPos"> 
			<input name="submit2" type="submit" id="submit2" value="Edit Information">
		</label>
	</form>
	
	<table>
		<tr>
			<td>Username</td>
			<td><input type="hidden" id="username" value="${user.username}">${user.username}</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${user.lastName}</td>
		</tr>
		<tr>
			<td>	
			<c:choose>
				<c:when test = "${Role eq Professor or Role eq Student}">
         			Address
      			</c:when>
      		</c:choose>
      		</td>
			
			<td>
				<c:if test = "${Role eq Professor}">
         			${professor.address}
      			</c:if>
      			<c:if test = "${Role eq Student}">
         			${student.address}
      			</c:if>
      		</td>
      		</tr>
		
		<tr><td>
			<c:if test = "${Role eq Professor or Role eq Student}">
         		<c:out value = "Phone Number" />
         	</c:if>
         </td> 
         <td>
         	<c:if test = "${Role eq Professor}">
         		<c:out value = "${professor.phone}"/>
      		</c:if>
			<c:if test = "${Role eq Student}">
         		<c:out value = "${student.phoneNumber}"/>
      		</c:if>
		</tr>
		
		<tr><td>
			<c:choose>
				<c:when test = "${Role eq Professor}">
         			Fax
      			</c:when>
      			<c:otherwise> 
      			
      			</c:otherwise>
      		</c:choose>
		</td>
			<td>${professor.fax}</td>
		</tr>
		<tr>
			<td>Email address</td>
			<td>${user.emailAddress}</td>
		</tr>
	</table>
</body>
</html>