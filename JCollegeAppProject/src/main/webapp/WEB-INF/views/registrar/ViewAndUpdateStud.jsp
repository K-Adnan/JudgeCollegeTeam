<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View and Update Stud</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}
</style>
</head>
<body>
<div id="mainWrapper">
  <header> 
    <!-- This is the header content. It contains Logo and links -->
    <div id="logo"> 
      <!-- Company Logo text --> 
      <a href="../home"> <img src="../img/logo.png"/> </a></div>
    <div id="headerLinks"><a href="../logout" title="Logout">Logout</a></div>
    <div class="titletext">
		  <h2>Judge College</h2>
    </div>
  </header>
  <div id="content">
    <nav class="sidebar"> 
      <div id="menubar">
      	<div class="menu">
          <ul>
                	<li><a href="MyProfile">My Profile</a></li>
					<li><a href="SystemUsers">System Users</a></li>
					<li><a href="Courses">Courses</a></li>
					<li><a href="Departments">Departments</a></li>
					<li><a href="Timetable">Timetable</a></li>
					<li><a href="Grades">Grades</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="mainContent">
      
	<form align="left" name="form1" method="post" action="SystemUsers">
			<label class="SystemUsersLblPos"> <input name="submit2" type="submit" id="submit2" value="Back">
			</label>
		</form>
	<h2>Profile Information</h2>
	
	<form name="form1" method="post" action="EditInformationStud?username=${student.username}">
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
		</tr><tr>
			<td>Date of Birth</td>
			<td><fmt:formatDate value="${student.dOB}" type="both" pattern="dd/MM/yyyy"/></td>
		</tr>
	</table>
	<br/><br/>
	
	<table>
			<c:forEach items="${courseList}" var="c">
				<tr>
				<td>${c.courseName}</td> 
				<td><form name="RemoveFromCourse" action="RemoveFromCourse" onSubmit="return getConfRemoveFromCourse()">
					<input type="hidden" name="username" value="${student.username}" />
					<input type="hidden" name="courseCode" value="${c.courseCode}" />  
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
		
		<table>
				<tr>
					<th>Date of Absence</th>
					<th>Reason of Absence</th>
					<th>Approved</th>
				</tr>
			<c:forEach items="${absenceList}" var="a">
				<tr>
				<td><fmt:formatDate value="${a.dateOfAbsence.time}" type="both" pattern="dd/MM/yyyy"/></td>
				<td>${a.reasonForAbsence}</td>
				<td>${a.absenceApproved}</td>
				</tr> 
			</c:forEach>
		</table>
      
      
    </div>
  </div>
  <footer> 
    <!-- This is the footer with default 3 divs -->
    <div><span style="line-height: 5px"> <p><strong>Judge College</strong></p>
      <p>Cottons Centre</p>
      <p> Cottons Lane</p>
      <p> London SE1 2QG</p></span>
    </div>
    <div id="2col">
    	<span style="line-height: 10px"><p>Tel: 020 3141 5926</p> 
    	<p>Email: info@judgecollege.co.uk</p></span>
    </div>
    <div>
      <span style="line-height: 10px"><p>&copy; 2017 Judge College Inc.</p>
      <p>All Rights Reserved</p></span>
    </div>
  </footer>
</div>


</body>
</html>