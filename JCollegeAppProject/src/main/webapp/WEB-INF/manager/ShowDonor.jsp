<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Donor</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">
</head>
<body>
<h3 class="hello">Hello ${username } </h3>
${message5}
${errormessage}
 <c:if test="${not empty username}">
 <div align="center">

        <table border="1" cellpadding="5">
          <caption> <h2> Donor Information</h2></caption>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Contact Number</th>
                <th>Address Line 1</th>
                <th>Address Line 2</th>
                <th>Postcode</th>
                <th>City</th>
                <th>Country</th>
                <th>Payment Type</th>
                <th>Card Number</th>
                <th>Card Expiry Month</th>
                <th>Card Expiry Year</th>
            
            </tr>
            
                <tr>
                    <th>${donor.firstname}</th>
                    <th>${donor.lastname}</th>
                    <th>${donor.username}</th>                 
                    <th>${donor.email}</th>
                    <th>${donor.phonenumber}</th>
                    <th>${donor.address1}</th>
                    <th>${donor.address2}</th>
                    <th>${donor.postcode}</th>
                    <th>${donor.city}</th>
                    <th>${donor.country}</th>
                    <th>${donor.paymentype}</th>
                    <th>${donor.cardnumber}</th>
                    <th>${donor.monthExpiry}</th>
                    <th>${donor.yearExpiry}</th>
                    
                    
                </tr>
            
        </table>
    </div>


</c:if>



<a href="managerHome"> Go back to Home </a>


</body>
</html>