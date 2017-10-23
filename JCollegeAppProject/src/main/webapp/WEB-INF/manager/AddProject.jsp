<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Project</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<h3 class="hello">Hello ${username }</h3>

<div class="form-style-10">







<div class="section">New Project details</div>
<sf:form method="post" action="processAddProject" modelAttribute="project" >

    <div class="inner-wrap">
        <label>Name<sf:input path= "name"/></label>
        <label>Location<sf:input path="location"/></label>
      <input type="submit" value="Add Project" class="submitbutton"/>
    </div>
${message9}
${message11}
${message12}



</sf:form>  

</div>
<a href="managerHome"> Go back to Home </a>


</body>
</html>