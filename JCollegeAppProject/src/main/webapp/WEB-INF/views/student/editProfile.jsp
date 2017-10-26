<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile Information</title>
</head>
<body>

<h1>View Personal Details</h1>

${message}

<sf:form method="post" action="updateProfile" modelAttribute="student">
	<h2 style="text-align:left"> Update Your Profile </h2>
	<p style="text-align:left">Address : <sf:input size="50" path="address" value="${student.address}"/><br/></p>
	<p style="text-align:left">Phone Number : <sf:input path="phoneNumber" value="${student.phoneNumber}"/></p>
	<p style="text-align:left">Email Address : <sf:input path="emailAddress" value="${student.emailAddress}"/></p>
	
	<div style="text-align:left" class="changePassword"><a href="changePassword"> Change Password</a></div>

<input style="text-align:left" type="submit" value="Go"/>
</sf:form>

</body>
</html>