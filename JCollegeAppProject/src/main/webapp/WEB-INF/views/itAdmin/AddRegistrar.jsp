<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Registrar</title>
</head>
<body>
<sf:form method="post" action="processAddRegistrar" modelAttribute="user">

		 	 
		
		Registration Date <sf:input type="date" path="user.registrationDate" />
		
		First Name <sf:input type="text" path="user.firstName" />
		<br />
		<br /> 
		Last Name <sf:input type="text" path="user.lastName" />
		<br />
				
		User Name <sf:input type="text" path="username" />
		<br />
		<br /> 
		Password <sf:password path="password" />
		<br />
		<br /> 
		Confirm Password <sf:password path="confirmPassword" />
		<br />
		<br />
		Email Address <sf:input type="text" path="user.emailAddress" />
		<br />
		<br />
	



		<br /> 
	

		<br />
		<br />
		
	
		<input type="submit" value="RegisterUser">
	</sf:form>

</body>
</html>