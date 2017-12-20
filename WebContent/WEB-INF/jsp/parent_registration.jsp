<!DOCTYPE html>
<html>

  <head>
    <link href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/shift.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css"> -->
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<script type="text/javascript" src="js/angular.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/MyCss.css">
    
    <link rel="stylesheet" href="http://s3.amazonaws.com/codecademy-content/courses/ltp/css/bootstrap.css">
    <link rel="stylesheet" href="main.css">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    
<style>
* {
  box-sizing: border-box;
}

body {
  background-color: #f1f1f1;
}

#regForm {
  background-color: #ffffff;
  margin: 100px auto;
  font-family: Raleway;
  padding: 40px;
  width: 70%;
  min-width: 300px;
}

h1 {
  text-align: center;  
}

input {
  padding: 10px;
  width: 100%;
  font-size: 17px;
  font-family: Raleway;
  border: 1px solid #aaaaaa;
}
    
    
    

/* Mark input boxes that gets an error on validation: */
input.invalid {
  background-color: #ffdddd;
}

/* Hide all steps by default: */
.tab {
  display: none;
}

button {
  background-color: #4CAF50;
  color: #ffffff;
  border: none;
  padding: 10px 20px;
  font-size: 17px;
  font-family: Raleway;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #bbbbbb;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}

.step.active {
  opacity: 1;
}

/* Mark the steps that are finished and valid: */
.step.finish {
  background-color: #4CAF50;
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

  <body background="${pageContext.request.contextPath}/resources/Images/background.jpg">
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

<form id="regForm" method="post" action="/BabySitterManagement/addParent">
  <center><h2>Parents enter your details</h2></center><br>
  <!-- One "tab" for each step in the form: -->
  <div class="tab">
	<p><input type="text" placeholder="First Name" oninput="this.className = ''" name="firstName" required></p>
	<p><input type="text" placeholder="Last Name" oninput="this.className = ''" name="lastName" required></p>
    <p><input type="text" placeholder="E-mail" oninput="this.className = ''" name="email" required></p>
    <p><input type="password" placeholder="Desired Password" oninput="this.className = ''" name="password" required></p>
    
      
     
   
    
  </div>
  
  <div class="tab">
    <p><input type="text" placeholder="Phone" oninput="this.className = ''" name="phone" required></p>
     <p><input type="text" placeholder="SSN" oninput="this.className = ''" name="ssn" required></p>
    <p><input type="textarea" placeholder="Address" oninput="this.className = ''" name="address" required></p>
    <p><input type="text" placeholder="Zip Code" oninput="this.className = ''" name="zipcode" required></p>
  </div>
  <div class="tab">
      <p><input type="date" placeholder="Baby's Date of Birth" oninput="this.className = ''" name="dateofBirth" required></p>
       Baby's gender:
   <input type="radio" name="gender" value="male" checked> Boy
   <input type="radio" name="gender" value="female"> Girl
   <p><input type="textarea" placeholder="Special requests" oninput="this.className = ''" name="special_requests" required></p>
  </div>
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
</form>

<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the crurrent tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>

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
    