<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donate Page</title>
<link href="css/Style.css" rel="stylesheet" media="all">
</head>
<body>
	Please enter your details:

	<sf:form method="post" action="doRegister" modelAttribute="donor">
		First Name <sf:input type="text" path="firstname" required="required" />
		<br /> 
		Last Name <sf:input type="text" path="lastname" required="required" />
		<br /> 	
		Username <sf:input type="text" path="username" required="required"/>
		<br /> 
		Password <sf:password path="password" required="required"/>
		<br /> 
		Confirm Password <sf:password path="confirmpassword" required="required"/>
		<br />
		Email <sf:input type="text" path="email" required="required"/>
		<br />
		Contact Number <sf:input type="text" path="phonenumber" required="required"/>
		<br /> 
		Address Line 1 <sf:input type="text" path="address1" required="required"/>
		<br />
		Address Line 2 <sf:input type="text" path="address2" />
		<br /> 
		Postcode <sf:input type="text" path="postcode" required="required"/>
		<br />
		City <sf:input type="text" path="city" required="required"/>
		<br />
		Country<sf:input type="text" path="country" required="required"/>
		<br /> 
		Payment Type <sf:select path="paymentype" required="required">
			<sf:option value="Credit Card">Credit Card</sf:option>
			<sf:option value="PayPal">PayPal</sf:option> <c:redirect url="https://www.paypal.com/gb/home"/>
		</sf:select>
		<br />
		Card Number <sf:input type="text" path="cardnumber" required="required"/>
		<br />
		Card Expiry Month<sf:input type="text" path="monthExpiry" required="required"/>
		<br />
		Card Expiry Year <sf:input type="text" path="yearExpiry" />
		<br />
		<br />
		<input type="submit" value="Register">
	</sf:form>
	
</body>
</html>