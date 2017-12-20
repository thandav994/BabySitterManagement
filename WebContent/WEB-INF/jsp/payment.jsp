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

#img.source-image {
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.nav li {
  display: inline;
}

.jumbotron {
  background-image:url("/resources/Images/bs1.png");
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
          
          <li><a href="/BabySitterManagement/getAppointmentsList">Back</a></li>
        </ul>
        <ul class="pull-right">
          <li><b>${parent.firstName}</b></li>
          <li><a href="/BabySitterManagement/login">Sign Out</a></li>
          <li><a href="/">Help</a></li>
        </ul>
      </div>
    </div>

    <div class="container">
    <h4>Congratulations,your request has been approved!!<br> Just one more step to complete the process! </h4>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">


  <div id="Checkout" class="inline">
      <div class="card-row">
          <span class="visa"></span>
          <span class="mastercard"></span>
          <span class="amex"></span>
          <span class="discover"></span>
      </div>
      <form method="post" action="/BabySitterManagement/makePayment">
          <div class="form-group">
              <label for="PaymentAmount">Payment amount</label>
              <div class="amount-placeholder">
                  <span>$</span>
                  <span>500.00</span>
              </div>
          </div>
          
          <div class="form-group">
              <label for="NameOnCard">Name on card</label>
              <input id="NameOnCard" class="form-control" type="text" maxlength="255">
          </div>
          <div class="form-group">
              <label for="CreditCardNumber">Card number</label>
              <input id="CreditCardNumber" class="null card-image form-control" placeholder="XXXX-XXXX-XXXX-XXXX" type="text">
          </div>
          <div class="expiry-date-group form-group">
              <label for="ExpiryDate">Expiry date</label>
              <input id="ExpiryDate" class="form-control" type="text" placeholder="MM / YY" maxlength="7">
          </div>
          <div class="security-code-group form-group">
              <label for="SecurityCode">Security code</label>
              <div class="input-container" >
                  <input id="SecurityCode" class="form-control" type="text" >
                  <i id="cvc" class="fa fa-question-circle"></i>
              </div>
              <div class="cvc-preview-container two-card hide">
                  <div class="amex-cvc-preview"></div>
                  <div class="visa-mc-dis-cvc-preview"></div>
              </div>
          </div>
          <div class="zip-code-group form-group">
              <label for="ZIPCode">ZIP/Postal code</label>
              <div class="input-container">
                  <input id="ZIPCode" class="form-control" type="text" maxlength="10">
                  <a tabindex="0" role="button" data-toggle="popover" data-trigger="focus" data-placement="left" data-content="Enter the ZIP/Postal code for your credit card billing address."><i class="fa fa-question-circle"></i></a>
              </div>
          </div>
          <button id="PayButton" class="btn btn-block btn-success submit-button" type="submit">
              <span class="submit-button-lock"></span>
              <span class="align-middle">Pay</span> <!--Price to be added here,depending on the babysitter's experience-->
          </button>
      </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>

    <script  src="js/index.js"></script>

    <br><br><br>
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
    