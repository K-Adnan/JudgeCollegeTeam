<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
<link href="../css/Donor.css" rel="stylesheet" media="all">
</head>
<body>

Edit your details below:

	<sf:form method="post" action="editprofile" modelAttribute="donor">
		First Name <sf:input path="firstname" value="${donor.firstname}" />
		<br /> 
		Last Name <sf:input type="text" path="lastname" required="required" />
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
		
		${message}
		
	</sf:form>






<a href="donorHome"> Go back to Home </a>






</body>
</html>