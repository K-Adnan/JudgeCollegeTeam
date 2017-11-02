<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<a href = "viewStudents">Back to View Students</a>
<br/>
<br/>

${message}
<br/>
<br/>
<title>Add Student</title>
</head>
<body>
	<sf:form method="post" action="processAddStudent" modelAttribute="student">		 	 
		
		
	
		User Name: <sf:input type="text" path="username" required="required" />
		<br />
		<br /> 
		Password: <sf:password path="password" required="required" />
		<br />
		<br />		
		First Name: <sf:input type="text" path="firstName" required="required" />
		<br />
		<br /> 
		Last Name: <sf:input type="text" path="lastName" required="required" />
		<br />
		<br />
		Email Address: <sf:input type="text" path="emailAddress" required="required" />
		<br />
		<br />
        Address: <sf:input type="text" path="address" required="required" />
		<br />
		<br />
		Date Of Birth: <sf:input type="text" path="dobString" required="required" />
		<br />
		<br /> 
		
		Gender:   <sf:select path="genderString" required="required">


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