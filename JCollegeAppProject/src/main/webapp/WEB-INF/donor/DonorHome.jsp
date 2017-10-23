<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donor Homepage</title>
<link href="../css/Donor.css" rel="stylesheet" media="all">
</head>
<body>


	<header class="navbar row">  <a href="logout">Log out</a>

	</header>



	<div class="row div1">
		<div class="col-3">
			<!--Charity Name and Motto-->
			<img
				src=https://www.edx.org/sites/default/files/cloud_computing_378x225_2.jpg
				class="logo">
		</div>
		<div class="col-9 last">
			<h1 class="name">Cumulus</h1>
			<h2 class="motto">The sky's the limit</h2>
			<h2 class="welcome">Welcome ${username }</h2>
			${messageD}
		</div>
	</div>




	<div class="row">

		<div class="col-6 donate">


			<a class="button" href="showProjects"> Discover Projects</a>

		</div>
		<div class="col-6 last donate">

			<a class="button" href="addDonation"> Donate</a>

		</div>
	</div>

	<div class="row">

		<div class="col-6 donate">


			<a class="button" href="showProfile"> Check Profile Details</a>

		</div>
		<div class="col-6 last donate">

			<a class="button" href="removeProfile"> Delete Account</a>

		</div>
	</div>









</body>
</html>