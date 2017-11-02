<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Registrars</title>
</head>
<body>

${message}

<a href = "addRegistrar"> Add Registrar</a>
<br />
<br />




     <h2>All Registrars</h2>

 

     <table>
           <tr>

                <th>Registrar User Name</th>
                <th>Registrar password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Remove Registrar</th>
           </tr>

           <c:forEach items="${registrarList}" var="r">
                <tr>
                     <th>${r.username}</th>
                     <th>${r.password}</th>
                     <th>${r.firstName}</th>
                     <th>${r.lastName}</th>
                     <th>${r.emailAddress}</th>
                      <th><a href="processRemoveRegistrar?username=${r.username}">Remove Registrar</a></th>
           </c:forEach>
  </table>
       <a href="HomePage"> Back To Home  </a>
     <a href="/JCollegeAppProject/logout">Logout</a>


</body>
</html>