<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Donors</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">
</head>
<body>
<h3 class="hello">Hello ${username } </h3>



 <div align="center">
        <table border="1" cellpadding="5">
            <caption> <h2>List of all Donors</h2></caption>
            <tr>
                <th>Donor Username</th>
                <th>Donor First Name</th>
                <th>Donor Last Name</th>
                <th>Donor Email</th>
                <th>Donor Contact Number</th>
                <th>Donor Address Line 1</th>
                <th>Donor Address Line 2</th>
                <th>Donor Postcode</th>
                <th>Donor City</th>
                <th>Donor Country</th>
                <th>Donor Payment Type</th>
                
                
            
            </tr>
            <c:forEach items="${donorList}" var="d">
                <tr>
                    <th>${d.username}</th>
                    <th>${d.firstname}</th>
                    <th>${d.lastname}</th>
                    <th>${d.email}</th>
                    <th>${d.phonenumber}</th>
                    <th>${d.address1}</th>
                    <th>${d.address2}</th>
                    <th>${d.postcode}</th>
                    <th>${d.city}</th>
                    <th>${d.country}</th>
                    <th>${d.paymentype}</th>
                    
                    
                </tr>
            </c:forEach>
        </table>
    </div>




<a href="managerHome"> Go back to Home </a>




</body>
</html>