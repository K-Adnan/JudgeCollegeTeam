<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Profile</title>
<link href="../css/Donor.css" rel="stylesheet" media="all">
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<h3 class="hello">Hello ${username}</h3>

<div class="form-style-10">


<sf:form method="post" action="processRemoveProfile">
Are you sure you want to remove your profile?

<input type="submit" value="Confirm"/>


</sf:form>  

</div>


<a href="donorHome"> Go back to Home </a>



</body>
</html>