<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Users</title>

<link href="../css/style.css" rel="stylesheet" media="all">
<style type="text/css">
table tr input {
	opacity: 0;
	float: right
}

table tr:hover input {
	opacity: 1
}
</style>
<script type="text/javascript">
	function getConfRemoveUser() {
		
		var userid = document.getElementById("usernameid").value;
		<%--alert(userid);--%>
		var isOk = confirm("Are you sure you want to remove the user ?");
		return isOk;
	}
</script>
</head>

<body>
	<c:if test="${message eq 'User is removed!'}">
		<script>
			alert("User successfully removed!");
		</script>
	</c:if>
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
		<li><a href="Departments">Departments</a></li>
		<li><a href="Timetable">Timetable</a></li>
		<li><a href="Grades">Grades</a></li>
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">

		<a href="SystemUsers">Show All Users</a><br/>
		<a href="ShowProfessors">Show Professors</a><br/>
		<a href="ShowStudents">Show Students</a><br/>
		<form action="searchUser" method="post">
				<input name="search" width="50px" placeholder="Search for User"/>
				<input type="submit" value="Go!"/>
		</form>

		<table class="table1">
			<tr>
				<td>Username</td>
				<td>Name</td>
			</tr>
			<c:forEach items="${userList}" var="u">
				<tr>
					<td>${u.username}</td>
					<td>${u.firstName} ${u.lastName}</td>

					<td>
						<form name="ViewAndUpdate" method="post" action="ViewAndUpdate">
							<input type="hidden" name="username" value="${u.username}" /> <input
								name="submit3" type="submit" id="submit3"
								value="View and Update">
						</form>
					</td>

					<td>
					
						<form id="formRemove" action="RemoveUser" onsubmit="return getConfRemoveUser()">
							<input type="hidden" id="usernameid" name="username" value="${u.username}" >
							<input name="removeUser" type="submit" value="Remove">
						</form>
					</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</body>
</html>