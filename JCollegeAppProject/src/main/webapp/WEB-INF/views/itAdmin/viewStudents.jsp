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


     <h2>All Students</h2>
 
     
     <a href = "addStudent"> Add Student </a>
<br />
<br />

     <table>
           <tr>

                <th>Student User Name</th>
                <th>Student password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>D.O.B</th>
                 <th>Gender</th>
           </tr>

           <c:forEach items="${studentList}" var="s">
                <tr>
                     <th>${s.username}</th>
                     <th>${s.password}</th>
                     <th>${s.firstName}</th>
                     <th>${s.lastName}</th>
                     <th>${email}</th>
                     <th>${s.address}</th>
                     <th>${s.phoneNumber}</th>
                     <th>${s.dOB}</th>
                     <th>${s.gender}</th>
                     <th><a href="processRemoveStudent?username=${s.username}">Remove Student</a></th>
                     
             
           </c:forEach>
           
           </table>
     
     <a href="HomePage"> Back To Home  </a>
     <a href="/JCollegeAppProject/logout">Logout</a>

</body>
</html>














