<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<sf:form method="post" action="processAddStudent" modelAttribute="user">

		 	 
		
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
		Address <sf:input type="text" path="student.address" />

		<br /> 
		Phone Number <sf:input type="text" path="student.phoneNumber" />

		<br /> 
		
		Date Of Birth <sf:input type="text" path="student.dob" />

		<br /> 
		
		Gender    <sf:select path="student.gender">


			<sf:option value="male"> male </sf:option>
			<sf:option value="female"> female </sf:option>
			<sf:option value="undisclosed"> undisclosed </sf:option>


		</sf:select>
		



		<br /> 
	

		<br />
		<br />
		
	
		<input type="submit" value="RegisterUser">
	</sf:form>

</body>
</html>