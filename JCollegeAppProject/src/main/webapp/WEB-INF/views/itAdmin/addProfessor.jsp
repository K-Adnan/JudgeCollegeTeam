<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post" action="processAddUser" modelAttribute="user">		 	 
		
		
		
		User Name <sf:input type="text" path="user.username" />
		<br />
		<br /> 
		Password <sf:password type="text" path="user.password" />
		<br />
		<br /> 
		Confirm Password <sf:password type="text" path="confirmPassword" />
		<br />
		<br />
		Email Address <sf:input type="text" path="emailAddress" />
		<br />
		<br />
		First Name: <sf:input type="text" path="firstName"  />
           <br />
           <br />
		Last Name: <br />
           <sf:input type="text" path="lastName"  />
           <br />
		
		
		



		<br /> 
	

		<br />
		<br />
		
	
		<input type="submit" value="RegisterUser">
	</sf:form>

</body>
</html>