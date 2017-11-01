<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Registrar</title>
</head>
<body>
<sf:form method="post" action="processAddRegistrar" modelAttribute="registrar">

		 	 
		
		User Name <sf:input type="text" path="username" required="required" />
		<br />
		<br /> 
		Password <sf:password path="password" required="required"/>
		<br />
		<br /> 		
		First Name <sf:input type="text" path="firstName" required="required" />
		<br />
		<br /> 
		Last Name <sf:input type="text" path="lastName" required="required" />
		<br />
		Email Address <sf:input type="text" path="emailAddress" required="required" />
		<br />
		<br />
		<br /> 
		<br />
		<br />
		
	
		<input type="submit" value="RegisterUser">
	</sf:form>

</body>
</html>