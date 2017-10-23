<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/PageDirectives.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Donation</title>
<link href="../css/Donor.css" rel="stylesheet" media="all">
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet' type='text/css'>
</head>
<body>
<h3 class="hello">Hello ${username}</h3>


<h2>Urgent Projects</h2>


	<div class="row">

		<div class="col-4 ">

			<img
				src=http://morningpost.pk/eng/wp-content/uploads/2015/12/school.jpeg> <h3>Project Alpha - Rebuilding Akram High School after Cyclone Hunter (Id 1)</h3>


		</div>
		<div class="col-4 ">


		<img
				src=http://hopemagazine.rw/uploads/images/1492074712OLPC%20(1).JPG
				> <h3> Project Beta - Raising money for stolen school laptops in Burundi (Id 2) </h3>
		</div>

		<div class="col-4 last ">


			<img
				src=http://images.indianexpress.com/2015/06/school-girl-main.jpg
				> <h3>Project Charlie - Building high school for girls in Mumbai (Id 3)</h3>

		</div>

</div>



<div class="form-style-10">



<h4><div class="section">New Donation details</div>
<sf:form method="post" action="processAddDonation" modelAttribute="donation" >

    <div class="inner-wrap">
        <label>Project Id<sf:input path="id"/></label>
        <label>Amount(£)<sf:input path="amount"/></label>
      <input type="submit" value="Donate" class="button"/>
    </div></h4>
${message}



</sf:form>  

</div>

<a href="donorHome"> Go back to Home </a>

</body>
</html>