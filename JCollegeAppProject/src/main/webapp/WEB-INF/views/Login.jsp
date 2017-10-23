<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="css/Style.css" rel="stylesheet" media="all">
</head>
<body>

	

	 
	 <form action="j_security_check" method="post" class="form-style-10">
	 <h2 class="hello">Please enter login details:</h2>
		Enter username:<input name="j_username" required /> <br /> 
		Enter password:<input type="password" name="j_password" required/> <br /> 
			<input type="submit"
			value="Login">
	</form>
	<br /> 




</body>
</html>
