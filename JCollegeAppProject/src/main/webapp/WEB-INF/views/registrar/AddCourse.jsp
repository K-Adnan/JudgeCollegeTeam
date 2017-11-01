<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
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
	<h2>Add Course</h2>
	<sf:form method="post" action="doAddCourse" modelAttribute="course">
		 Course Name : <br /> <sf:input type="text" path="courseName" /> <br />
		<div class="form-group">
		<sf:label path="department" class="col-lg-3 control-label">Department :</sf:label>
		<div class="col-lg-8">
		<div class="ui-select">
				<select name="departmentId">
					<c:forEach items="${departmentList}" var="dep">
						<option value="${dep.departmentId}">${dep.departmentName}</option>
					</c:forEach>
						<option value="" selected="selected"/>
				</select>
		</div>
		</div>
		</div>
		
		Monday :<br/>
		<select name="monday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Tuesday :<br/>
		<select name="tuesday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Wednesday :<br/>
		<select name="wednesday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Thursday :<br/>
		<select name="thursday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		Friday :<br/>
		<select name="friday">
					<c:forEach items="${timeList}" var="t">
						<option value="${t}">${t}</option>
					</c:forEach>
		</select><br/>
		
		
		
		<sf:input path="" type="submit" value="Add Course" />
	</sf:form>	
	</div>
</body>
</html>