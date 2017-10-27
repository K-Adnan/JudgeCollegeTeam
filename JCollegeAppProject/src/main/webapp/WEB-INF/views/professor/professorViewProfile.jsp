<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Professor Profile Screen</title>
</head>
<body>

${message}

<c:if test="${not empty username}">
 <div align="center">

        <table border="1" cellpadding="5">
            <caption> <h2>${username}'s Profile</h2></caption>
            <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User Name</th>
            <th>Registration Date</th>
                <th>Address</th>
                <th>Phone Number</th>
                <th>Fax</th>
                <th>Department</th>
            
            </tr>
            
                <tr>
                <th>${professor.firstName}</th>
                <th>${professor.lastName}</th>
                <th>${professor.username}</th>
                <th>${professor.registrationDate}</th>
                    <th>${professor.address}</th>
                    <th>${professor.phone}</th>
                    <th>${professor.fax}</th>
                    <th>${professor.department}</th>
      
                </tr>
            
        </table>
    </div>


</c:if>

<a href="editProfile">Edit Contact information</a>



<a href="/JCollegeAppProject/logout">Logout</a>



<a href="professorHome"> Go back Home</a>




</body>
</html>