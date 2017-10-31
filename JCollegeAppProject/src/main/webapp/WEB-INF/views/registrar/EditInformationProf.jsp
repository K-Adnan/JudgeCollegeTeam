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
	</ul>
	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
	
	<form align="centre" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
	<h2>Edit Information</h2>

	<sf:form method="post" action="processEditProfessor" modelAttribute="professor">
First Name: <sf:input path="firstName" value="${professor.firstName}" />
           <br /> <br />
Last Name: <sf:input path="lastName" value="${professor.lastName}" />
           <br />
           <br />
User Name: <sf:input path="username"  value="${professor.username}" />
           <br />
           <br />
Address <sf:input path="address" value="${professor.address}" />
           <br />
           <br />
Phone: <sf:input path="phone"  value="${professor.phone}" />
           <br />
           <br />
Fax:       <sf:input path="fax"  value="${professor.fax}" />
           <br />
           <br />


           <input type="submit" value="Edit" />
           
     </sf:form>
	
</body>
</html>