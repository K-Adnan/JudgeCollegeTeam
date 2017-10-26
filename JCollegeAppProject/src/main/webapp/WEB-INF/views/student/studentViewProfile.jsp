<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile Information</title>
</head>
<body>

<h1>View Personal Details</h1>

			<strong>Username :</strong> ${student.username}<br/>
			<strong>First Name :</strong> ${student.firstName}<br/>
			<strong>Last Name :</strong> ${student.lastName}<br/>
			<strong>Address :</strong> ${student.address}<br/>
			<strong>Phone Number :</strong> ${student.phoneNumber}<br/>
			<strong>Date of Birth :</strong> ${student.dOB}<br/>
			<strong>Gender :</strong> ${student.gender}<br/>
			<strong>Email Address :</strong> ${student.emailAddress}<br/>

<a href="editProfile">Edit Profile</a>

</body>
</html>