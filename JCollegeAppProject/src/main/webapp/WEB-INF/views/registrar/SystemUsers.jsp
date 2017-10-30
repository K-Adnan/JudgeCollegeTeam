<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Users</title>
<link href="../css/style.css" rel="stylesheet" media="all">#
<style type="text/css">
      table tr input { opacity:0; float:right }
      table tr:hover input { opacity:1 }
</style> 
    
</head>

<body>

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
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
	
	<table class="table1">
		<tr>
			<td>Username</td>
			<td>Name</td>
		</tr>
		<c:forEach items="${userList}" var="u">
			<tr><td>${u.username}</td> 
			<td>${u.firstName}${u.lastName} </td>
			
			<td><form name="form3" method="post" action="ViewAndUpdate">
			<input type="hidden" name="username" value="${u.username}" /> 
			<input name="submit3" type="submit" id="submit3" value="View and Update">
			</form></td>
			
			<td><form name="form4" method="post" action="RemoveUser">
			<input type="hidden" name="username" value="${u.username}" /> 
			<input name="submit4" type="submit" id="submit4" value="Remove">
			</form></td></tr>
			
		</c:forEach>
		
	</table> 
	</div>
</body>
</html>