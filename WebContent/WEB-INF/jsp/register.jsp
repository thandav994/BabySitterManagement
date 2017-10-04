<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/logo.png" align=left>
<div class="header">
         <h1>FIND CARE FOR YOUR BABY.</h1>
</div>

<div class="topnav">
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#">Link</a>
</div>
    
<div class="row">
  <div class="column side">
    <h2>Login</h2>
    <form method="post" action="/BabySitterManagement/login">
    <div> <label for="parents">Login for Parents</label>        <input type="radio" name="category" id="parent" value="parent" />
        <label for="babysitter">Login for Babysitters</label>        <input type="radio" name="category" id="babysitter" value="babysitter" />
     </div>
    <div>
      <label for="email">Enter your Email:</label>
      <input type="email" name="userID" id="email" required placeholder="your email">
        <br>
      <label for="password">Enter your Password:</label>
      <input type="password" name="password" id="password" pattern=".{5,10}" placeholder="your password" required title="5 to 10 characters">
        
    </div>
      <div>
      <input type="submit" value="Login" />
    </div>
    </form>
    <h3>${errorMessage}<h3>
  </div>
  <div class="column middle">
  
    <h2>Register</h2>
    <form method="post" action="/BabySitterManagement/addUser">
      <div>
        <label for="parents">Find a babysitter</label>
        <input type="radio" name="category" id="parents" value="parent" />

        <label for="babysitter">Find a job</label>
        <input type="radio" name="category" id="babysitter" value="babysitter" />

     </div>
    <div>
      <label for="first-name">First Name:</label>
      <input type="text" name="firstName" id="first-name" placeholder="John" required />
      <label for="last-name">Last Name:</label>
      <input type="text" name="lastName" id="last-name" placeholder="Smith" required />
    </div>
    
     <div>
        <label for="Male">Male</label>
        <input type="radio" name="gender" id="Male" value="Male" />

        <label for="Female">Female</label>
        <input type="radio" name="gender" id="Female" value="Female" />

     </div>

    <div>
      <label for="email">Email:</label>
      <input type="email" name="email" id="email" required placeholder="your email">

      <label for="password">Password:</label>
      <input type="password" name="password" id="password" pattern=".{5,10}" placeholder="your password" required title="5 to 10 characters">
    </div>

  
    <div>
      <label for="select-choice">Birthday:</label>
        <input type="date" name="birthday">
    </div>

    <div>
      <label for="checkbox">I agree to the terms and conditions</label>
      <input type="checkbox" name="checkbox" id="checkbox" />
    </div>

    <div>
      <input type="submit" value="Submit" />
    </div>
  </form>  

  </div>
  
</div>

</body>
</html>
