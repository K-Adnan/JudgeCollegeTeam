<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="../css/Home.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #1A1A1A;
	background-image: url();
	background-repeat: repeat-x;
}
</style>
</head>
<body>
<div id="mainWrapper">
  <header> 
    <!-- This is the header content. It contains Logo and links -->
    <div id="logo"> 
      <!-- Company Logo text --> 
      <a href="../home"> <img src="https://s3.amazonaws.com/media.prestontrail.org/craft/The-Bookstore-Online-Logo-600x.png?mtime=20160930115548" width="248" height="134" alt=""/> </a></div>
    <div id="headerLinks"><a href="../logout" title="Logout">Logout</a>
    <div id="nav">
		  <ul>
		  <li><a href="../home">Home</a>
		  <li><a href="../viewPersonalDetails">Profile</a>
				<ul>
			        <li><a href="../viewPersonalDetails">View Personal Details</a></li>
			        <li><a href="../changePassword">Change Password</a></li>
			        <li><a href="../viewOrders">View Order History</a></li>
	         	</ul>
		    </li>
		   	${adminOptions}
		    <li><a href="../viewAllBooks">Books</a>
				<ul>
			        <li><a href="../viewAllBooks">View All Books</a></li>
			        <li><a href="../searchBook">Advanced Search for Books</a></li>
	         	</ul>
		    </li>
		    <li><a href="../help">Help</a>
	        </li>
		    <li><a href="../contact">Contact Us</a>
	      </ul>
    </div>
  </header>
  <div id="content">
    <nav class="sidebar"> 
      <div id="menubar">
      	<h1>Categories</h1>
      	<div class="menu">
          <ul>
					<li><a href="../viewBiographyBooks">View Courses</a></li>
                	<li><a href="../viewFictionBooks">Fiction</a></li>
                	<li><a href="../viewTechnologyBooks">Technology</a></li>
                	<li><a href="../viewTravelBooks">Travel</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="mainContent">
      
      <a href = "ViewCourses"> View Courses </a>
<a href = "ViewGrades"> View Grades</a>
<br />
<br />
<a href = "ViewProfile"> View Profile</a>
<br/>
<br/>
<a href = "viewTimetable"> View Timetable</a>
      
      
    </div>
  </div>
  <footer> 
    <!-- This is the footer with default 3 divs -->
    <div><span style="line-height: 5px"> <p><strong>Books4u</strong></p>
      <p>Cottons Centre</p>
      <p> Cottons Lane</p>
      <p> London SE1 2QG</p></span>
    </div>
    <div id="2col">
    	<span style="line-height: 10px"><p>Tel: 020 3141 5926</p> 
    	<p>Email: info@books4u.com</p></span>
    </div>
    <div>
      <span style="line-height: 10px"><p>&copy; 2017 Kamran Ahmed Adnan</p>
      <p>All Rights Reserved</p></span>
    </div>
  </footer>
</div>


</body>
</html>