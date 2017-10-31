<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Professor</title>
</head>
<body>
	<sf:form method="post" action="processAddItAdmin" modelAttribute="itAdmin">		 	 
		
		
		
		User Name <sf:input type="text" path="username" />
		<br />
		<br /> 
		Password <sf:password  path="password" />
		<br />
		<br />
		First Name: <sf:input type="text" path="firstName"  />
        <br />
        <br />
		Last Name: <sf:input type="text" path="lastName"  />
        <br />
        <br />
        Email Address <sf:input type="text" path="emailAddress" />
		<br />
		<br />
		
	
		<input type="submit" value="Register ItAdmin">
	</sf:form>

</body>
</html>