<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Project</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">
</head>
<body>
<h3 class="hello">Hello ${username } </h3>
<h2> Remove Project </h2>
<sf:form method="post" action="processRemoveProject" modelAttribute="project">

                    

Project Id: <sf:input path="id"/>

<input type=submit value="Remove Project"/>

</sf:form>









${message10}
${message}








<a href="managerHome"> Go back to Home </a>

</body>
</html>