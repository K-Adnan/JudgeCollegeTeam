<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Managers</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">
</head>
<body>
<h3 class="hello">Hello ${username }</h3>



 <div align="center">
        <table border="1" cellpadding="5">
            <caption> <h2>List of all Managers</h2></caption>
            <tr>
                <th>Manager Username</th>
                
            
            </tr>
            <c:forEach items="${managerList}" var="m">
                <tr>
                    <td>${m.username}</td>
                    
                    
                </tr>
            </c:forEach>
        </table>
    </div>


<a href="managerHome"> Go back to Home </a>






</body>
</html>