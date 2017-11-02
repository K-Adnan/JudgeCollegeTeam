<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Screen</title>
</head>
<body>


${message}


<a href = "addProfessor"> Add Professor </a>
<br />
<br />

     <h2>All Professors</h2>


     <table>
           <tr>

                <th>Professor User Name</th>
                <th>Professor password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Fax</th>
                <th>Department</th>
                <th>Remove Professor</th>
                
           </tr>

           <c:forEach items="${professorList}" var="p">
                <tr>
                     <th>${p.username}</th>
                     <th>${p.password}</th>
                     <th>${p.firstName}</th>
                     <th>${p.lastName}</th>
                     <th>${p.address}</th>
                     <th>${p.phone}</th>
                     <th>${p.fax}</th>
                     <th>${p.department.departmentName}</th>
                     <th><a href="processRemoveProfessor?username=${p.username}">Remove Professor</a></th>
     
           </c:forEach>
</table>

     
<a href="HomePage"> Back To Home  </a>
 <a href="/JCollegeAppProject/logout">Logout</a>

</body>
</html>
