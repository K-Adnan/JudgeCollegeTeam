<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
<link href="../css/Donor.css" rel="stylesheet" media="all">
</head>
<body>

Edit your details below:

	<sf:form method="post" action="editprofile" modelAttribute="professor">
		Address <sf:input path="firstname" value="${professor.address}" />
		<br />
		Phone Number <sf:input type="text" path="phone" value="${professor.phone}"/>
		<br /> 
		Fax <sf:input type="text" path="fax" value="${professor.fax}"/>
		<br />
		<input type="submit" value="Register">
		
		${message}
		
	</sf:form>





<a href="professorHome"> Go back to Home </a>






</body>
</html>