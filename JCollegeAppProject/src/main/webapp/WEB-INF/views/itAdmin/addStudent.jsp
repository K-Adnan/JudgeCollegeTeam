<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<sf:form method="post" action="processAddStudent" modelAttribute="student">		 	 
		
		
	
		User Name <sf:input type="text" path="username" />
		<br />
		<br /> 
		Password <sf:password path="password" />
		<br />
		<br />		
		First Name <sf:input type="text" path="firstName" />
		<br />
		<br /> 
		Last Name <sf:input type="text" path="lastName" />
		<br />
		<br />
		Email Address <sf:input type="text" path="emailAddress" />
		<br />
		<br />
        Address: <sf:input type="text" path="address" />
		<br />
		<br />
		Date Of Birth: <sf:input type="text" path="dobString" />
		<br />
		<br /> 
		
		Gender:   <sf:select path="genderString">


			<sf:option value="male"> male </sf:option>
			<sf:option value="female"> female </sf:option>
			<sf:option value="undisclosed"> undisclosed </sf:option>

		</sf:select>
		<br />
		<br />
		<br />
		<br />
		<br />

		<input type="submit" value="Register Student">
	</sf:form>

</body>
</html>