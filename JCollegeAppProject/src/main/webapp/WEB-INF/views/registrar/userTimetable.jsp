<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../css/timetable.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user Timetable</title>
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
		<li><a href="Departments">Departments</a></li>
		<li><a href="Timetable">Timetable</a></li>
		<li><a href="Grades">Grades</a></li>
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">

<h2> Timetable for ${user.firstName} ${user.lastName}</h2>
	<table>
			<tr>
				<th>Time</th>
				<th>Monday</th>
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th>
				<th>Friday</th>
			</tr>
			<tr>
				<th>9.00 - 10.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 09:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>10.00 - 11.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 10:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>11.00 - 12.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 11:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>12.00 - 13.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 12:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>13.00 - 14.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 13:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>14.00 - 15.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 14:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>15.00 - 16.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 15:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th>16.00 - 17.00</th>
				<td>
					<c:forEach items="${courseList}" var="c">
				  <c:choose>
						<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 00:00:00 GMT 2017'}">
						</c:when>
						<c:otherwise>
						  <c:choose>
							<c:when test="${c.lessons['MONDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['MONDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['TUESDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['TUESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['WEDNESDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['WEDNESDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['THURSDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['THURSDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
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
						  <c:choose>
							<c:when test="${c.lessons['FRIDAY'].time eq 'Mon Oct 30 16:00:00 GMT 2017'}">
						  		<div class="timetableItem">
								<div class="courseName">${c.courseName}</div>
								<div class="professor">${c.professor.firstName} ${c.professor.lastName}</div>
								<div class="time"><fmt:formatDate value="${c.lessons['FRIDAY'].time}" type="both" pattern="HH:mm" /></div>
								</div>
							</c:when>
						  </c:choose>
				  </c:otherwise>
				  </c:choose>
					</c:forEach>
				</td>
			</tr>
	</table>


</body>
</html>