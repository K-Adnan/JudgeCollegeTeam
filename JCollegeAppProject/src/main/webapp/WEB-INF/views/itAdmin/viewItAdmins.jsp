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

     <h2>All ITAdmins</h2>


     <br /> ${username}

     <table>
           <tr>

                <th>IT Admin User Name</th>
                <th>IT Admin password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Remove IT Admin</th>
           </tr>

           <c:forEach items="${itadminList}" var="i">
                  <tr>
                     <th><a>${i.username}</a></th>
                     <th>${i.password}</th>
                     <th>${i.firstName}</th>
                     <th>${i.lastName}</th>
                     <th>${i.email}</th>
                     <th><a href="processRemoveITAdmin?username=${i.username}">Remove IT Admin</a></th>
     
                     
           </c:forEach>
     
     <a href="HomePage"> Back To Home  </a>
     <a href="/JCollegeAppProject/logout">Logout </a>


</body>
</html>