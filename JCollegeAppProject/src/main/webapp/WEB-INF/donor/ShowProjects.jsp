<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Projects</title>
<link href="../css/Donor.css" rel="stylesheet" media="all">
</head>
<body>
<h3 class= "hello">Hello ${username } </h3>



 <div align="center">
        <table border="1" cellpadding="5">
            <caption> <h2>List of all Projects</h2></caption>
            <tr>
                <th>Project Id</th>
                <th>Project Name</th>
                <th>Project Location</th>
               
            
            </tr>
            <c:forEach items="${projectList}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.location}</td>
                  
                    
                    
                </tr>
            </c:forEach>
        </table>
    </div>




<a href="donorHome"> Go back to Home </a>




</body>
</html>