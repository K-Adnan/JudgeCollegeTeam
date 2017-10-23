<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Project</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">
</head>
<body>
<h3 class="hello">Hello ${username}</h3>
<h2> Update Existing Project </h2>
${message}

<sf:form method="post" action="processUpdateProject" modelAttribute="project">

Project name : <sf:input path="name" value="${name}" /><br/>
Project location : <sf:input path="location" value="${location}"/><br/>
<sf:hidden path="id" value="${id}"/>

<input type="submit" value="Update Project"/>

</sf:form>

<a href="manageProjects"> Go back to List of Projects</a>

<a href="managerHome"> Go back to Home </a>


</body>
</html>