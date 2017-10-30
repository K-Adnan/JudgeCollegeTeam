<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Screen</title>
</head>
<body>

	<h2>View Course</h2>

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
					<c:choose>
						<c:when test="${monday eq '00:00'}">
							-
						</c:when>
						<c:otherwise>
							${monday}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${tuesday eq '00:00'}">
							-
						</c:when>
						<c:otherwise>
							${tuesday}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${wednesday eq '00:00'}">
							-
						</c:when>
						<c:otherwise>
							${wednesday}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${thursday eq '00:00'}">
							-
						</c:when>
						<c:otherwise>
							${thursday}
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${friday eq '00:00'}">
							-
						</c:when>
						<c:otherwise>
							${friday}
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>

</body>
</html>