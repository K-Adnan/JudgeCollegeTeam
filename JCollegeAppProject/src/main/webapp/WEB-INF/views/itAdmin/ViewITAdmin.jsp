<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Screen</title>
</head>
<body>

     <h2>All ITAdmin</h2>

     <a href="/JCollegeAppProject/logout">Logout</a>

     <br /> ${username}

     <table>
           <tr>

                <th>IT Admin User Name</th>
                <th>IT Admin password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
           </tr>

           <c:forEach items="${itadminList}" var="i">
                <tr>
                     <th><a href="editITAdmin?username="${i.username}>${i.username}</a></th>
                     <th>${password}</th>
                     <th>${firstName}</th>
                     <th>${lastName}</th>
                     <th>${email}</th>
           </c:forEach>
     


</body>
</html>