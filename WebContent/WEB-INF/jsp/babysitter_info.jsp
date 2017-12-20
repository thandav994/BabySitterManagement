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
          
        <li><a href="/BabySitterManagement/parent_home">Home</a></li>
        </ul>
        <ul class="pull-right">
          <li><b>${parent.firstName}</b></li>
          <li><a href="/BabySitterManagement/getAppointmentsList">View Orders</a></li>
          <li><a href="/BabySitterManagement/login">Sign Out</a></li>
          <li><a href="#">Help</a></li>
        </ul>
      </div>
    </div>

     <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"><center>Request this Babysitter</center></h4>
      </div>
      <div class="modal-body">
       <div class="row">
       	<div class="col-lg-8 col-md-8 col-sm-8">
       		
            <p><b>Date</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${appointmentDate}</p>
            <p><b>Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${sitter.firstName} ${sitter.lastName}</span></p>
       		<p><b>Gender</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${sitter.gender}</span></p>
       		<p><b>Hourly Pay</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${sitter.hourlyPay}</span></p>
       		<p><b>Experience</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>${sitter.experience}</span></p>
            <p><b>Bio</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${sitter.bio}</span></p>
            <p><b>Rating</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>${sitter.rating}</span></p>
                                 
  
       		<div class="row">
       			<form method="post" action="/BabySitterManagement/bookAppointment">
       			<div class="col-lg-8 col-md-8"><input type="textarea" class="form-control" placeholder="Special Request" name="specialRequests"/></div>
       			<div class="col-lg-4 col-md-4"><button class="btn btn-default" type="submit" href="/BabySitterManagement/bookAppointment">Request</button></div>
       			</form>
       		</div>
                                 
             <br><br>
       		 <form method="post" action="/BabySitterManagement/rateaSitter" >
                 <p><b>Your Rating: <select name="rating">
                     <option value="1">1 Star</option>
                     <option value="2">2 Star</option>
                     <option value="3">3 Star</option>
                     <option value="4">4 Star</option>
                     <option value="5">5 Star</option>
                     </select>     </b>  </p>
                      <div class="col-lg-4 col-md-4"><button class="btn btn-default" type="submit">Submit Rating</button></div>
                 </form>
       		</div>
       </div>						      
      </div>
      <center><h3>${successMessage}</h3></center>
	<center><h3>${errorMessage}</h3></center>
    </div>
    
    <div class="neighborhood-guides">
      <div class="container">
      
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
    