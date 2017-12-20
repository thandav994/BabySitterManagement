<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css"> -->
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.0.3.js"></script>-->
	<link rel="stylesheet" type="text/css" href="css/MyCss.css">
    
     <style>
        
        .nav a {
  color: #5a5a5a;
  font-size: 11px;
  font-weight: bold;
  padding: 14px 10px;
  text-transform: uppercase;
}

.nav li {
  display: inline;
}

       
.jumbotron {
  background-image:url("img\bs1.jpg");
  height: 500px;
  background-repeat: no-repeat;
  background-size: 100px 60px;
}

.jumbotron .container {
  position: relative;
  top:100px;
}

.jumbotron h1 {
  color: #000000;
  font-size: 48px;  
  font-family: 'Shift', sans-serif;
  font-weight: bold;
}

.jumbotron p {
  font-size: 20px;
  color: #000000;
}

.neighborhood-guides{
background-color:#efefef;
border-bottom:1px solid #dbdbdb;
}

.neighborhood-guides h2{
    color:#393c3d;
    font-size:24px;
}
.neighborhood-guides p{
    color:#393c3d;
    font-size:15px;
    margin-bottom:13px;
}

.learn-more {
  background-color: #f7f7f7;
}

.learn-more h3 {
  font-family: 'Shift', sans-serif;
  font-size: 18px;
  font-weight: bold;
}

.learn-more a {
  color: #00b0ff;
}
        
.dropdown.dropdown-lg .dropdown-menu {
    margin-top: -1px;
    padding: 4px 15px;
}

.btn-group .btn {
    border-radius: 0;
    margin-left: -1px;
}
.form-horizontal .form-group {
    margin-left: 0;
    margin-right: 0;
}


@media screen and (min-width: 768px) {
    #boot-search-box {
        width: 500px;
        margin: 0 auto;
    }
    .dropdown.dropdown-lg {
        position: static !important;
    }
    .dropdown.dropdown-lg .dropdown-menu {
        min-width: 500px;
    }
}
        
           
        .nav a {
  color: #5a5a5a;
  font-size: 11px;
  font-weight: bold;
  padding: 14px 10px;
  text-transform: uppercase;
}

.nav li {
  display: inline;
}

.jumbotron {
  background-image:url("img\bs1.jpg");
  height: 500px;
  background-repeat: no-repeat;
  background-size: 100px 60px;
}

.jumbotron .container {
  position: relative;
  top:100px;
}

.jumbotron h1 {
  color: #000000;
  font-size: 48px;  
  font-family: 'Shift', sans-serif;
  font-weight: bold;
}

.jumbotron p {
  font-size: 20px;
  color: #000000;
}

.neighborhood-guides{
background-color:#efefef;
border-bottom:1px solid #dbdbdb;
}

.neighborhood-guides h2{
    color:#393c3d;
    font-size:24px;
}
.neighborhood-guides p{
    color:#393c3d;
    font-size:15px;
    margin-bottom:13px;
}

.learn-more {
  background-color: #f7f7f7;
}

.learn-more h3 {
  font-family: 'Shift', sans-serif;
  font-size: 18px;
  font-weight: bold;
}

.learn-more a {
  color: #00b0ff;
}
        
     
        
        
        
        

    
    </style>
    
    
</head>

<body style=" overflow: auto;height: 100%">
	<!--Navigation bar-->
	  <!--Navigation bar-->
	  <div class="nav">
      <div class="container">
        <ul class="pull-left">
          
          <li><a href="/BabySitterManagement/sitter_home">Home</a></li>
        </ul>
        <ul class="pull-right">
          <li><b>${sitter.firstName}</b></li>
          <li><a href="/BabySitterManagement/login">Sign Out</a></li>
          <li><a href="#">Help</a></li>
        </ul>
      </div>
    </div>
    <!--Body-->
    <!-- background-image: url('Images/IndexPage.jpg');height: 100%;background-position: center;background-repeat: all;;background-size: cover; -->
    
       <!-- <div class="panel-body">
		<center>
            <form class="form-inline">
                <div class="form-group">
                    
                    <input type="" name="name" ng-model="Search" class="form-control" placeholder="Name">
                </div>
               
                <div class="form-group">
                 <input type="submit" value="Search" name=" " class="btn btn-primary" ng-click="BooksList(Search);show==1"/>
                </div>
            </form>
        </center></div> -->
    
  
  
    	<table class="table table-striped table-hover table-bordered" style="background-color: white">
	        	<thead>
	        		<tr>
	        			<th class="text-center">ID</th>
	        			<th class="text-center">Date</th>
			        	<th class="text-center">Name</th>
			        	<th class="text-center">Status/More Options</th>
			        	
	        		</tr>
	        	</thead>
	        	<tbody>
	        		<c:forEach var="appointment" varStatus="status" items="${appointments}">
					    <tr>
					    <td class="text-center"><option value ="10"><c:out value="${appointment.id}"/></option></td>
					    <td class="text-center"><option value ="10"><c:out value="${appointment.appointmentDate}"/></option></td>
					    <td class="text-center"><option value ="10"><c:out value="${appointment.parent.firstName} ${appointment.parent.lastName}"/></option></td>
					    <c:if test = "${appointment.status == 'Pending'}">
					    <td><a class="btn btn-primary btn-block" href="<c:url value='/getParentInformation?appointmentID=${appointments[status.index].id}&parentID=${appointments[status.index].parent.email}'/>" >View and update</a></td>
					    </c:if>
					    <c:if test = "${appointment.status != 'Pending'}">
					    <td class="text-center"><option value ="10"><c:out value="${appointment.status}"/></option></td>
					    </c:if>
					    </tr>
					</c:forEach>
	        	</tbody> 
	        	<tfoot>
	        	</tfoot>      	
	    </table>	
	   <center><h3>${errorMessage}</h3></center>
	   
	    
         <div class="row">
         <div class="col-md-4">
           <div class="thumbnail">
			<img src="${pageContext.request.contextPath}/resources/Images/bs6.jpg">
           </div>
         </div>  
         <div class="col-md-4">
           <div class="thumbnail">
             <img src="${pageContext.request.contextPath}/resources/Images/bs5.jpg">
            </div>
        </div>    
         <div class="col-md-4">
            <div class="thumbnail">
             <img src="${pageContext.request.contextPath}/resources/Images/bs1.png">
           </div>
         </div>  
        </div>
        

    <div class="learn-more">
	  <div class="container">
		<div class="row">
	      <div class="col-md-4">
			<h3>Travel</h3>
			<p>Dont own a car?Just use our very own smart car!</p>
			<p><a href="#">Click here to learn more about travel</a></p>
	      </div>
		  <div class="col-md-4">
			<h3>Payment</h3>
			<p>Get paid instantly after every session.</p>
			<p><a href="#">Click here to learn more about payment</a></p>
		  </div>
		  <div class="col-md-4">
			<h3>Trust and Safety</h3>
			<p>Safety is important for you as well.Select your own customers</p>
			<p><a href="#">Click here to learn more about our policies</a></p>
		  </div>
	    </div>
	  </div>
	</div>
  </body>
</html>
                  
    