<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/timetable.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Screen</title>
</head>
<body>

	<h2>View Timetable</h2>

	<a href="/JCollegeAppProject/logout">Logout</a><br/>

	<table>
			<tr>
				<th>Monday</th>
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th>
				<th>Friday</th>
			</tr>
			<tr>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
				  <div class="timetableItem">
						<div class="courseName">${c.courseName}</div>
						<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
						<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
				  </div>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
				  <div class="timetableItem">
						<div class="courseName">${c.courseName}</div>
						<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
						<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
				  </div>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
				  <div class="timetableItem">
						<div class="courseName">${c.courseName}</div>
						<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
						<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
				  </div>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
				  <div class="timetableItem">
						<div class="courseName">${c.courseName}</div>
						<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
						<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
				  </div>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
				  <div class="timetableItem">
						<div class="courseName">${c.courseName}</div>
						<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
						<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
				  </div>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
		</table>


</body>
</html>