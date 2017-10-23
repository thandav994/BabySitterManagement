<!DOCTYPE html>
<!-- Text between angle brackets is an HTML tag and is not displayed.
Most tags, such as the HTML and /HTML tags that surround the contents of
a page, come in pairs; some tags, like HR, for a horizontal rule, stand 
alone. Comments, such as the text you're reading, are not displayed when
the Web page is shown. The information between the HEAD and /HEAD tags is 
not displayed. The information between the BODY and /BODY tags is displayed.-->
<head>
<title>Welcome!</title>
</head>
<!-- The information between the BODY and /BODY tags is displayed.-->
<body background="C:\Users\nitesh\Documents\parents-and-crying-baby-at-home.jpg">
<h1>Hello parents,Welcome!</h1>
<h2>You can view the list of available babysitters. </h2>
<p> Enter the date when you would like to hire a babysitter:</p>
<form action="/BabySitterManagement/Listofbabysitters" method="get">
	<input required="required" type="date" name="appointmentDate"><br>
    <input type="submit" value="Submit" />
</form>
</body>
<style>
.footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: None;
    color: black;
    text-align: center;
}
</style>

<div class="footer">
  <p>&#169; babysitters.org, 2017</p>
</div>

</html>