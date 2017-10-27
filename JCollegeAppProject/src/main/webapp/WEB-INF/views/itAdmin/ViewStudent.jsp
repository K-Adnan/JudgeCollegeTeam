<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<title>Home Screen</title>
</head>
<body>

     <h2>All Students</h2>

     <a href="/JCollegeAppProject/logout">Logout</a>

     <br /> ${username}

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
                     <th><a href="editStudent?username="${s.username}>${s.username}</a></th>
                     <th>${password}</th>
                     <th>${firstName}</th>
                     <th>${lastName}</th>
                     <th>${email}</th>
                     <th>${s.address}</th>
                     <th>${s.phoneNumber}</th>
                     <th>${s.dOB}</th>
                     <th>${s.gender}</th>
                     <th>${role}</th>
                     
             
           </c:forEach>
     


</body>
</html>
