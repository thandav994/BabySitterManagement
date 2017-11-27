<!DOCTYPE html>
<html>

  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <style>
        
        
        
            .button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
        border-radius: 8px;
}

.button1:hover {
    background-color: #008CBA;
    color: white;
}

.button2 {
    background-color: white; 
    color: black; 
    border: 2px solid #f44336;
    border-radius: 8px;
}

.button2:hover {
    background-color: #f44336;
    color: white;
}
     .button3 {
        background-color: white;
        color: black;
        border: 2px solid #555555;
             border-radius: 8px;

    }

.button3:hover {
    background-color: #555555;
    color: white;}
    
    input[type=text] {
    width: 25%;
    padding: 12px 20px;
   
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
}
    input[type=text]:focus {
    border: 3px solid #555;
}
    
        input[type=password] {
    width: 25%;
    padding: 12px 20px;
   
    box-sizing: border-box;
    border: 3px solid #ccc;
    -webkit-transition: 0.5s;
    transition: 0.5s;
    outline: none;
}
    input[type=password]:focus {
    border: 3px solid #555;
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
  background-image:url("resources/Images/bs1.jpg");
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

  <body>
    <div class="nav">
      <div class="container">
        <ul class="pull-left">
         
          <li><a href="#">Home</a></li>
        </ul>
        <ul class="pull-right">
         
          <li><a href="#">Help</a></li>
        </ul>
      </div>
    </div>

<div class="container-fluid" style="margin-top: -20px;">
    	<div class="row">
            <center>
        	<h1 style="color: black ;margin-top: 100px" >Welcome to BabySitter Managament System</h1>
<!--        	<h2 class="text-center" style="color: white; font-size: 5em">Let' Get Started</h2>-->
        	<br>        <h3>LOGIN</h3>
           
                       
                       <form method="post" action="/BabySitterManagement/login">
							<div class="form-group">      			
                           <input type="radio" name="category" value="parent" checked> Parent
  <input type="radio" name="category" value="babysitter"> Babysitter<br>
                           </div>
                           
                           <div class="form-group">
							      				<input type=text name="userID"  placeholder="Username" required/>
							      			</div>
							      			<div class="form-group">
							      				<input type=password name="password"  placeholder="Password" required />
							      			</div>
							      			<button class="button button3" type="submit" >Submit</button><br><br>
							      		</form>
                       
             <a href="/BabySitterManagement/parent_registration"> <button class="button button1">Registration for Parents</button></a>&nbsp;&nbsp;&nbsp;
            <a href="/BabySitterManagement/babysitter_registration"> <button class="button button2">Registration for babysitters</button></a>
            <br><br>
            
                 </center>
        </div>
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
    