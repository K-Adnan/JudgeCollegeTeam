<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Homepage</title>
<link href="../css/Manager.css" rel="stylesheet" media="all">




</head>
<body>


	<header class="navbar row"> <a href="logout"> Logout </a> </header>



	<div class="row div1">
		<div class="col-4">
			<!--Charity Name and Motto-->
			<img
				src=https://www.edx.org/sites/default/files/cloud_computing_378x225_2.jpg
				class="logo">


		</div>
		<div class="col-8 last">
			<h1 class="name">Cumulus</h1>
			<h2 class="motto">The sky's the limit</h2>
			<h2 class="welcome">Welcome ${username}</h2>
			${message} ${message2} ${message8} ${message9} ${message10}
			${messageD}

		</div>
	</div>



	<div class="row">

		<div class="col-12 last donate">


			<a class="button" href="showManagers"> Show all Managers</a>

		</div>
	</div>


	<div class="row">

		<div class="col-6 donate">


			<a class="button" href="addManager"> Add Manager</a>

		</div>
		<div class="col-6 last donate">

			<a class="button" href="removeManager"> Remove Manager</a>


		</div>
	</div>

	<div class="row">

		<div class="col-12 last donate">


			<a class="button" href="showDonations"> Show all Donations</a>

		</div>
	</div>



	<div class="row">

		<div class="col-6 donate">


			<a class="button" href="searchDonor"> Search for Donor</a><br />

		</div>
		<div class="col-6 last donate">

			<a class="button" href="showDonors"> Show all Donors</a>

		</div>
	</div>




	<div class="row">

		<div class="col-12 last donate">


			<a class="button" href="manageProjects"> Manage Projects</a>

		</div>
	</div>






	<!--  <div class="row">

		<div class="col-4 donate">

			<a class="button" href="updateProject"> Update Project</a>${message8}


		</div>
		<div class="col-4 donate">


			<a class="button" href="addProject"> Add Project</a>${message9}

		</div>

		<div class="col-4 last donate">


			<a class="button" href="removeProject"> Remove Project</a>${message10}

		</div>



	</div> -->








</body>
</html>