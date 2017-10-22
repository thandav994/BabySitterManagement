<html>
    <head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="css/style.css">
    </head>
<body style="background-color:#00ffff;">
	<head>
<title>Home</title>
<meta charset="utf-8">
    <link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>
<img src="images/logo.png" align=left>
<div class="header">
     <h1>FIND CARE FOR YOUR BABY.</h1>
</div>
<div class="topnav">
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#">Link</a>
</div>
  <div class="main">
<h1>The below table displays the list of babysitters </h1>
      <div class="column side"></div>
  <div class="column middle" style="background-color:#bbb;">
<c:if test="${not empty lists}">
    <c:forEach items="${lists}" var="item">
      <div class="contentlist"> <a href = "#"> SHREYASH MANE<br>Work Ex: 2 years<br> Skills: Singing, Dancing, Sports. </a> </div><br><br><br>
              <div class="contentlist"> <a href = "#"> THANDAV<br>Work Ex: 4 years<br> Skills: Musician, Dancing, Sports. </a> </div>

</c:forEach>
</c:if>	
</div>
  

</div>  
<style>
     .contentlist{
         height: 20px;
         background-color: burlywood;
    }
    .row {
    content: "";
    display: table;
    clear: both;
}
        .column {
    float: left;
    padding: 10px;
    height: 300px; 
}
    .column.side {
    width: 10%;
}
    .column.middle {
    width: 70%;
}
    @media (max-width: 600px) {
    .column.side, .column.middle {
        width: 100%;
    }
}
    </style>
</body>
</html>