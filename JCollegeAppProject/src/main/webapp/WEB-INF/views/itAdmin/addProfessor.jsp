<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<a href = "viewProfessors">Back to View Professors</a>
<title>Add Professor</title>
<br/>
<br/>
${message}
</head>
<body>
	<sf:form method="post" action="processAddProfessor" modelAttribute="professor">		 	 
		
		
		
		User Name: <sf:input type="text" path="username" required="required" /><br/>
		Password: <sf:password  path="password" required="required" /><br/>
		First Name: <sf:input type="text" path="firstName" required="required"  /><br/>
		Last Name: <sf:input type="text" path="lastName" required="required"  /><br/>
        Email Address: <sf:input type="text" path="emailAddress" required="required" /><br/>
        Address: <sf:input type="text" path="address" required="required"/><br/>
        Phone: <sf:input type="text" path="phone" required="required" /><br/>
        Fax: <sf:input type="text" path="fax" required="required" /><br/>
        
        Department
		<select name="departmentId">
        	<c:forEach items="${departmentList}" var="dep">
				<option value="${dep.departmentId}">${dep.departmentName}</option>
			</c:forEach>
		</select>
		<br/>
		<input type="submit" value="Register Professor">
	</sf:form>

</body>
</html>