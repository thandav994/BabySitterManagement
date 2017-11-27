<html>
<head>
	<title></title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="materialize/js/materialize.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css"> -->
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<script type="text/javascript" src="js/angular.min.js"></script>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.0.3.js"></script>-->
	<link rel="stylesheet" type="text/css" href="css/MyCss.css">
	<script>
		var app = angular.module("MyApp", []); 
		app.controller("MyCtrl", function($scope, $http, $timeout) {			
			$scope.BooksList = function(Search){
				// console.log(Search);
				if(Search == ""){
					// console.log("null");
					$scope.Books = null;
				}
				else{
					// console.log(Search);
					$http.post('php/BooksList.php?Search='+ Search).then(function(data){
					// console.log(data);
					$scope.Books = data.data;				
					console.log($scope.Books);
				});
				}
			}	
			$scope.CheckBorrowerId = function(BorrowerId, BookId){
				// console.log(BorrowerId);
				$http.post('php/CheckBorrowerId.php?BorrowerId=' + BorrowerId).then(function(data){
					// console.log(data.data);
					$scope.Borrower = data.data;
					console.log($scope.Borrower);					
					if($scope.Borrower == 'no one'){
						console.log('there is no one with this name');
						$scope.ErrorMessageBorrowerId = "Enter a Valid Borrower Id";
					}
					else{
						$scope.ErrorMessageBorrowerId='';
						console.log('there is one guy');
						$scope.CheckBorrowerLoans(BorrowerId, BookId);
						// $scope.BorrowBook(BorrowerId, BookId);
					}
				});
			}
			$scope.CheckAvailability = function(BookId){
				// console.log(BookId);
				$http.post('php /CheckAvailability.php?BookId='+BookId).then(function(data){
					console.log('in the Availability function');
					console.log(data.data);
					$scope.Status = data.data;
					// $scope.CheckInDate = data.data[0].DateIn;
					// console.log($scope.CheckInDate);
					if($scope.Status == 'Available'){
						$scope.ErrorMessageBorrowerId='';
						$scope.BookStatus = "Available";
						console.log('Great the Book is Available');
					}
					if($scope.Status=='Not Available'){
						$scope.ErrorMessageBorrowerId='';
						$scope.BookStatus = "Not Available";
						console.log('sorry the book is not Available');
					}
				})
			}
			$scope.BorrowBook = function(BorrowerId, BookId){
				console.log("In the borrow book fucntion");
				console.log(BookId, BorrowerId);
				$http.post('php/BorrowBook.php?BookId='+ BookId+'&BorrowerId='+BorrowerId).then(function(data){
					console.log(data.data);
					$scope.CheckAvailability(BookId);
					$scope.ErrorMessage="";
					$scope.ErrorMessageBorrowerId='';
					$scope.BorrowBookMessage = "Great ! Now the Book is Checked Out for Borrower Id "+ BorrowerId;
				});
			}
			$scope.CloseModal = function(){
				$scope.BorrowBookMessage = "";
				$scope.ErrorMessage = "";
				$scope.ErrorMessageBorrowerId='';
			}
			$scope.CheckBorrowerLoans = function(BorrowerId, BookId){
				console.log('In the loans function');
				console.log(BorrowerId, BookId);
				$http.post('php/CheckBorrowersLoans.php?BorrowerId='+BorrowerId).then(function(data){
					$scope.Num = data.data;
					// console.log($scope.Num[0].NumberOfBooks);
					if($scope.Num[0].NumberOfBooks >= 3){
						$scope.ErrorMessageBorrowerId='';
						console.log('the id has more that or equal to 3 books cant provide more - '+ $scope.Num[0].NumberOfBooks);
						$scope.ErrorMessage = "Can't Provide more Books as the Borrower's Id already has 3 books or more"
					}
					else{
						$scope.ErrorMessageBorrowerId='';
						console.log("seems that the borrower does not have more that or equal to 3 books, have fun here is your book");
						$scope.BorrowBook(BorrowerId, BookId);
					}
				})
			}
			// $scope.BooksList();		
		});
	</script>
    
    <style>
    
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

<body ng-app="MyApp" ng-controller="MyCtrl" style=" overflow: auto;height: 100%" ng-cloak>
	<!--Navigation bar-->
	  <div class="nav">
      <div class="container">
        <ul class="pull-left">
          
          <li><a href="#">Home</a></li>
        </ul>
        <ul class="pull-right">
            <li><b>Name</b></li>
            <li><a href="parent_notifi.jsp">View Orders</a></li>
          <li><a href="#">Sign Out</a></li>
          <li><a href="#">Help</a></li>
        </ul>
      </div>
    </div>
    <!--Body-->
    <!-- background-image: url('Images/IndexPage.jpg');height: 100%;background-position: center;background-repeat: all;;background-size: cover; -->
    
       <div class="panel-body">
<center>
            <form class="form-inline">
                <div class="form-group">
                    
                    <input type="" name="name" ng-model="Search" class="form-control" placeholder="Name">
                </div>
                <div class="form-group">
            
            <input type="text" name="zipcode" class="form-control" id="zip" placeholder="ZIP">
          </div>
            
             <div class="form-group">
            
            <input type="date" name="date" class="form-control" id="date" >
          </div>
            
          <div class="form-group">
            
            <select class="form-control" name="gender" id="type1">
              
              <option value="">Male</option>
              <option value="">Female</option>
            </select>
          </div>
          <div class="form-group">
            
            <div class="input-group">
              <div class="input-group-addon" id="basic-addon1">$</div>
              <input type="text" class="form-control" name="pricefrom" aria-describedby="basic-addon1" placeholder="Min Pay">
            </div>
          </div>
          <div class="form-group">
            
            <div class="input-group">
              <div class="input-group-addon" id="basic-addon2">$</div>
              <input type="text" class="form-control" name="priceto" aria-describedby="basic-addon1" placeholder="Max Pay">
            </div>
          </div>
            
            
             
                <div class="form-group">
                 <input type="submit" value="Search" name=" " class="btn btn-primary" ng-click="BooksList(Search);show==1"/>
                </div>
            </form>
        </center></div>
    
  
  
    		<table class="table table-striped table-hover table-bordered" style="background-color: white">
	        	<thead>
	        		<tr>
	        			<th class="text-center">ID</th>
			        	<th class="text-center">Name</th>
			        	<th class="text-center">Availability</th> 	
			        	<th class="text-center">More Options</th>
			        	
	        		</tr>
	        	</thead>
	        	<tbody>
	        		<tr ng-repeat="book in Books |filter:Search">
	        			<td><img ng-src="{{book.CoverUrl}}" class="img-responsive center-block" style="max-height: 100px;max-width: 100px" /></td>
	        			<td class="text-center">{{book.BookName}}</td>
	        			<td class="text-center">{{book.AuthorName}}</td>
	        			
	        			<td>
	        				<button class="btn btn-primary btn-block" data-toggle="modal" data-target="#BorrowModal{{$index}}" ng-click="CheckAvailability(book.ISBN)">Request</button>
	        				<div id="BorrowModal{{$index}}" class="modal fade" role="dialog">
							  <div class="modal-dialog">

							    <!-- Modal content-->
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal">&times;</button>
							        <h4 class="modal-title">Request this Babysitter</h4>
							      </div>
							      <div class="modal-body">
							       <div class="row">
							       	<div class="col-lg-4 col-md-4 col-sm-4">
							       		<img ng-src="{{book.CoverUrl}}" class="img-responsive center-block"/>
							       	</div>
							       	<div class="col-lg-8 col-md-8 col-sm-8">
							       		
                                        <form action="add data to table and return here" method="post">
                                            
                                        <p><b>Date</b>  </p>
                                        <p><b>Name</b> </p>
							       		<p><b>Gender</b> </p>
							       		<p><b>Hourly Pay</b> </p>
							       		<p><b>Experience</b>  </p>
                                        <p><b>Bio</b>  </p>
                                        <p><b>Rating</b>  </p>
                                        
                                        
                                        </form>
                                        
                                       
                                        
                                        
							       		<div class="row" ng-if="BookStatus=='Available'">
							       			<div class="col-lg-8 col-md-8"><input type="textarea" class="form-control" placeholder="Special Request" ng-model="BorrowerId"/></div>
							       			<div class="col-lg-4 col-md-4"><button class="btn btn-default" ng-click="CheckBorrowerId(BorrowerId, book.ISBN)">Request</button></div>
							       		</div>
                                        
                                        <br><br>
							       		 <form action="/BabySitterManagement/rateaSitter" method="post">
                                        <p><b>Your Rating: <select>
                                            <option value="1">1 Star</option>
                                            <option value="2">2 Star</option>
                                            <option value="3">3 Star</option>
                                            <option value="4">4 Star</option>
                                            <option value="5">5 Star</option>
                                            </select>     </b>  </p>
                                             <div class="col-lg-4 col-md-4"><button class="btn btn-default" ng-click="CheckBorrowerId(BorrowerId, book.ISBN)">Submit Rating</button></div>
                                        </form>
							       		</div>
							       </div>						      
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-default" data-dismiss="modal" ng-click='CloseModal()'>Close</button>
							      </div>
							    </div>

							  </div>
							</div>
	        			</td>	        			
	        		</tr>
	        	</tbody> 
	        	<tfoot>
	        	</tfoot>      	
	        </table>	
	   
                
        
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
                  
    