<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br />
	<br />

	<br /> ${message}

	<br />
	<br /> edit the details of a professor

	<sf:form method="post" action="UpdateProfessor" modelAttribute="professor">

First Name: <br />
		<sf:input path="firstName" value="${firstName}" />
		<br />
		
		First Name: <br />
		<sf:input path="lastName" value="${lastName}" />
		<br />
Boot Brand: <br />
		<sf:input path="brandName" value="${brandName}" />
		<br />
Boot Colour: <br />
		<sf:input path="colour" value="${colour}" />
		<br />
Price: <br />
		<sf:input path="price" value="${price}" />
		<br />
Quantity In Stock: <br />
		<sf:input path="qtyInStock" value="${qtyInStock}" />
		<br />

		<sf:hidden path="bootID" value="${bootID}" />

		<input type="submit" value="Edit" />

	</sf:form>

<a href="firstPage"> Edit Boot  </a>

</body>
</html>