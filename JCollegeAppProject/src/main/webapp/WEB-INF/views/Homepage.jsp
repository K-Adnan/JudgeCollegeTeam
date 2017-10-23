<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="PageDirectives.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="css/Style.css" rel="stylesheet" media="all">

</head>
<body>




	<header class="navbar row"> <!--Top Nav Bar--> <a href="#home">What
		we do</a> <a href="#news">News</a>
	<a href="#Gallery">Gallery</a> <a href="signup">Join</a><a href="loginDonorOrManager">Login</a>


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
			<h3>${message}</h3>	
			<h3>${message2}</h3>
		</div>
	</div>



	<div class="row">
		<div class="col-8 ">
			<!--Main Project Example-->
			<img
				src=http://morningpost.pk/eng/wp-content/uploads/2015/12/school.jpeg class="main"> Project Alpha - Rebuilding Akram High School after Cyclone Hunter 
		</div>
		<div class="col-4 last news">
			<!--News Box-->
			<h2 class="newsh">News</h2>
			<ul>
				<a href="#"><li><b>Former student wins Nobel Prize</b> <br>
						<i>10 September 2017</i></li></a>
				<br>
				<a href="#"><li><b>"Excellent progress being made at
							Cumulus" - India PM</b> <br> <i>2 September 2017</i></li></a>
				<br>
				<a href="#"><li><b>Cumulus reaches the £2 million
							donated milestone</b> <br> <i>28 August 2017</i></li></a>
				<br>
				<a href="#"><li><b>E-learning system upgraded</b> <br>
						<i>25 August 2017</i></li></a>
				<br>
				<a href="#"><li><b>Collaboration with Apple</b> <br> <i>20
							August 2017</i></li></a>
				<br>
				<a href="#"><li><b>Collaboration with Microsoft</b> <br>
						<i>15 August 2017</i></li></a>
				<br>
				<a href="#"><li><b>Survey - Students 100% satisfied
							with Cumulus</b> <br> <i>12 August 2017</i></li></a>
				<br>
			</ul>


		</div>

	</div>

	<div class="row">
		<div class="col-4">
			<img
				src=http://hopemagazine.rw/uploads/images/1492074712OLPC%20(1).JPG
				class="threep"> Project Beta - Raising money for stolen school laptops in Burundi
		</div>
		<div class="col-4">
			<!--Three project examples-->
			<img
				src=http://images.indianexpress.com/2015/06/school-girl-main.jpg
				class="threep"> Project Charlie - Building high school for girls in Mumbai 
		</div>
		<div class="col-4">
			<!--Three project examples-->
			<img src="https://tedconfblog.files.wordpress.com/2014/04/sic-doc-kids-1.jpg?w=900" class="threep"> Record progress for girls at Nimbus school in Mumbai 
		</div>
	</div>

	<div class="row">

		<div class="col-8 quote">
			<!--Upcoming Events-->
			<h2>
				<i>"Education is the most powerful weapon which you can use to
					change the world" </i>
			</h2>
			<br>
			<h3 class="Nelson">Nelson Mandela</h3>
		</div>
		<div class="col-4 last donate">
			<!--News Box-->
			<a href="signup"><button class=button>DONATE</button></a>

		</div>
	</div>

	<div class="row">

		<div class="col-8 events ">
			<!--Upcoming Events-->
			<h2>Upcoming Events</h2>
			<ul>
				<a href="#"><li><b>Fancy Dress Party : Theme - Geeks</b> <br>
						<i>5 September 2017</i></li></a>
				<br>
				<a href="#"><li><b>Tea and Cake with alumni</b> <br> <i>
							20 September 2017</i></li></a>
				<br>
				<a href="#"><li><b>Pitta in the Park</b> <br> <i>2
							October 2017</i></li></a>
				<br>
			</ul>
		</div>


		<div class="col-4 last fshape">
			<!--Register-->


			<img
				src=https://www.edx.org/sites/default/files/cloud_computing_378x225_2.jpg
				class="logo">

		</div>
	</div>


	<footer class="navbar2 row">

	<div class="col-12">

		<a href="#aboutus">About Us</a> <a href="#jobs">Jobs</a> <a
			href="#sitemap">Site Map</a> <a href="#contactus">Contact Us</a>

	</div>

	</footer>






	</div>


</body>
</html>




















