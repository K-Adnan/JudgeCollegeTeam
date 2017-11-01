<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Students</title>
</head>
<body>

<title>Home Screen</title>
</head>
<body>

${message}


     <h2>Blocked Users</h2>


     <table>
           <tr>

                <th>User Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
           </tr>
           <c:forEach items="${userList}" var="u">
                <tr>
                     <th>${u.username}</th>
                     <th>${u.firstName}</th>
                     <th>${u.lastName}</th>
                     <th>${u.emailAddress}</th>
                     <th><a href="processUnblockUser?username=${u.username}">Unblock</a></th>
           </c:forEach>
           </table>
     
     <a href="HomePage"> Back To Home  </a>
     <a href="/JCollegeAppProject/logout">Logout</a>

</body>
</html>














