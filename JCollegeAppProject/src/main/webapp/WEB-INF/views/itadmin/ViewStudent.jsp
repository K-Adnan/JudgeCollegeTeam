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

                <th>Professor User Name</th>
                <th>Professor password</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th> Fax </th>
           </tr>

           <c:forEach items="${professorList}" var="p">
                <tr>
                     <th><a href="editProfessor?username="${p.username}>${p.username}</a></th>
                     <th>${password}</th>
                     <th>${firstName}</th>
                     <th>${lastName}</th>
                     <th>${email}</th>
                     <th>${p.address}</th>
                     <th>${p.phone}</th>
                     <th>${p.fax}</th>
                     <th>${role}</th>
                     
                     <th><a href="enrollOnCourse?courseCode=${c.courseCode}">Enroll</a></th>
           </c:forEach>
     


</body>
</html>
