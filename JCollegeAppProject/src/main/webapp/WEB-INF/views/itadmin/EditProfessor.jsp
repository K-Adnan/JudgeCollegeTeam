<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br />
     <br />

     <br /> ${message}

     <br />
     <br /> edit the details of a professor

     <sf:form method="post" action="UpdateProfessor" modelAttribute="professor">

           
           
First Name: <sf:input path="firstName" value="${professor.firstName}" />
           <br />
           <br />
Last Name: <br />
           <sf:input path="lastName" value="${lastName}" />
           <br />
User Name: <sf:input path="username"  value="${username}" />
           <br />
           <br />
Email:     <sf:input path="email"  value="${email}" />
           <br />
           <br />
Address <sf:input path="firstname" value="${professor.address}" />
           <br />
           <br />
Phone: <sf:input path="phone"  value="${phone}" />
           <br />
           <br />
Fax:       <sf:input path="fax"  value="${fax}" />
           <br />
           <br />
Role: <sf:input path="role"  value="${role}" />

           <input type="submit" value="Edit" />
           
     </sf:form>
     

<a href="HomePage"> Back To Home  </a>

</body>
</html>
