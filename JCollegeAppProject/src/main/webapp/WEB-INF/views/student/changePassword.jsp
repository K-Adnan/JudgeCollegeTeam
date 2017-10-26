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

<form method="post" action="updatePassword">
	<h2 style="text-align:left"> Update Your Password </h2>
	<p style="text-align:left">Current Password : <input type="password" name="password"/><br/></p>
	<p style="text-align:left">New Password : <input type="password" name="newPassword"/></p>
	<p style="text-align:left">Confirm Password : <input type="password" name="confirmPassword"/></p>
	
	${message}<br/>
	
<input style="text-align:left" type="submit" value="Submit"/>
</form>

</body>
</html>