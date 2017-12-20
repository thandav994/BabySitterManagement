<!DOCTYPE html>
<html>

  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="main.css">
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
        
        
        
        
      </style>
  </head>

  <body background="${pageContext.request.contextPath}/resources/Images/background.jpg">
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

  <%--     <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"><center>Parent Information</center></h4>
      </div>
      <div class="modal-body">
       <div class="row">
       	<div class="col-lg-8 col-md-8 col-sm-8">
       		
          <form action="add data to table and return here" method="post">
                
            <p><b>Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.firstName} ${parent.lastName}</p>
       		<p><b>Kid's Gender</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.gender}</p>
       		<p><b>Kid's date of birth</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.dateofBirth}</p>
            <p><b>Special Request</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.special_requests}</p>
                               
       		<div class="row">
       			
       			<div class="col-lg-4 col-md-4"><a class="btn btn-default" href="/BabySitterManagement/updateanAppointment?decision=true">Accept</button></div>
       			<div class="col-lg-4 col-md-4"><a class="btn btn-default" href="/BabySitterManagement/updateanAppointment?decision=false" >Decline</button></div>
       		</div>					      
      </div>
      <center><h3>${successMessage}</h3></center>
	  <center><h3>${errorMessage}</h3></center>
    </div> --%>
    
    
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"><center>Request this Babysitter</center></h4>
      </div>
      <div class="modal-body">
       <div class="row">
       	<div class="col-lg-8 col-md-8 col-sm-8">
       		
            <p><b>Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.firstName} ${parent.lastName}</p>
       		<p><b>Kid's Gender</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.gender}</p>
       		<p><b>Kid's date of birth</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.dateofBirth}</p>
            <p><b>Special Request</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${parent.special_requests}</p>
                                 
  
       		<div class="row">
       		<p><a class="btn btn-primary btn-block" href="/BabySitterManagement/updateanAppointment?decision=true">Accept</a></td></p>
       		
       		<p><a class="btn btn-primary btn-block" href="/BabySitterManagement/updateanAppointment?decision=false">Reject</a></p>
       		</div>
                                 
             <br><br>
       		 </div>
       </div>						      
      </div>
      <center><h3>${successMessage}</h3></center>
	<center><h3>${errorMessage}</h3></center>
    </div>
      
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
    